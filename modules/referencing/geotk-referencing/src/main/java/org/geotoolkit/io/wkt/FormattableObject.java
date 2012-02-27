/*
 *    Geotoolkit.org - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2001-2012, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2009-2012, Geomatys
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    This package contains documentation from OpenGIS specifications.
 *    OpenGIS consortium's work is fully acknowledged here.
 */
package org.geotoolkit.io.wkt;

import java.io.Console;
import java.io.PrintWriter;
import org.opengis.metadata.citation.Citation;
import org.opengis.parameter.GeneralParameterValue;
import org.opengis.referencing.cs.CoordinateSystem;

import org.geotoolkit.io.X364;
import org.geotoolkit.lang.Debug;
import org.geotoolkit.lang.Configuration;
import org.geotoolkit.util.ArgumentChecks;
import org.geotoolkit.util.converter.Classes;
import org.geotoolkit.metadata.iso.citation.Citations;
import org.geotoolkit.metadata.iso.citation.DefaultCitation;
import org.geotoolkit.metadata.iso.citation.DefaultResponsibleParty;


/**
 * Base class for objects formattable as <cite>Well Known Text</cite> (WKT).
 * Almost every Geotk implementations of referencing objects extend this class,
 * except {@link org.geotoolkit.referencing.operation.transform.AffineTransform2D}.
 *
 * {@section Strict and lenient WKT formatting}
 * Strict WKT formatting is performed by various {@code toWKT(...)} methods. Those methods may
 * fail to format a particular object, in which case a {@link UnformattableObjectException} is
 * thrown. A formatting may fail because an object is too complex for the WKT format capability
 * (for example an {@link org.geotoolkit.referencing.crs.DefaultEngineeringCRS EngineeringCRS}
 * with different unit for different axis), or because only some specific implementations can be
 * formatted as WKT.
 * <p>
 * The default {@link #toString()} implementation is like {@link #toWKT()} except that no
 * exception is thrown if the resulting WKT is not compliant with the specification. The
 * {@code toString()} method does not provide control over indentation and other features.
 * But if such control is desired, it can be obtained by using directly the {@link Formatter}
 * class.
 *
 * {@section Syntax coloring}
 * A convenience {@link #print()} method is provided, which is roughly equivalent to
 * {@code System.out.println(this)} except that syntax coloring is automatically applied
 * if the terminal seems to support the {@link X364 X3.64} standard.
 *
 * @author Martin Desruisseaux (IRD, Geomatys)
 * @version 3.20
 *
 * @since 2.0
 * @module
 */
public class FormattableObject implements Formattable {
    /**
     * The formatter for the {@link #toWKT()} method.
     */
    private static final ThreadLocal<Formatter> FORMATTER = new ThreadLocal<>();

    /**
     * The indentation value to give to the {@link #toWKT(int)} method for formatting the complete
     * object on a single line.
     *
     * @since 2.6
     *
     * @deprecated Moved to {@link WKTFormat#SINGLE_LINE} in order to reduce the amount
     * of declarations in this base class. The raison is that {@code FormattableObject}
     * is extended by a lot of objects, and those rarely-used WKT stuff are distracting.
     */
    @Deprecated
    public static final int SINGLE_LINE = 0;

    /**
     * Frequently used authority for formatting WKT. This is the same reference than
     * the one declared in the {@link Citations} class, copied here for convenience.
     *
     * @see Citations#OGC
     *
     * @since 3.00
     *
     * @deprecated Replaced by {@link Convention#OGC}.
     */
    @Deprecated
    public static final Citation OGC = Citations.OGC;

    /**
     * Frequently used authority for formatting WKT. This is the same reference than
     * the one declared in the {@link Citations} class, copied here for convenience.
     *
     * @see Citations#EPSG
     *
     * @since 3.00
     *
     * @deprecated Replaced by {@link Convention#EPSG}.
     */
    @Deprecated
    public static final Citation EPSG = Citations.EPSG;

    /**
     * Frequently used authority for formatting WKT. This is the same reference than
     * the one declared in the {@link Citations} class, copied here for convenience.
     *
     * @see Citations#GEOTIFF
     *
     * @since 3.00
     *
     * @deprecated Replaced by {@link Convention#GEOTIFF}.
     */
    @Deprecated
    public static final Citation GEOTIFF = Citations.GEOTIFF;

    /**
     * A special citation for formatting objects as stored internally by Geotk. This citation
     * can be given to the {@code authority} argument of the {@link #toWKT(Citation,int)} method.
     * In the majority of cases, the result will be identical to the one we would get using the
     * {@link #OGC} authority. However in the particular case of map projections, the result may be
     * quite different because of the way Geotk separates the linear from the non-linear parameters.
     * <p>
     * This citation is used only for debugging purpose.
     *
     * @see Formatter#isInternalWKT()
     *
     * @since 3.00
     *
     * @deprecated Replaced by {@link Convention#INTERNAL}.
     */
    @Debug
    @Deprecated
    public static final Citation INTERNAL;
    static {
        final DefaultCitation c = new DefaultCitation("Internal WKT");
        c.getCitedResponsibleParties().add(DefaultResponsibleParty.GEOTOOLKIT);
        c.freeze();
        INTERNAL = c;
    }

    /**
     * The default indentation value.
     *
     * @see WKTFormat#setDefaultIndentation(int)
     */
    static volatile int defaultIndentation = 2;

    /**
     * Default constructor.
     */
    protected FormattableObject() {
    }

    /**
     * Prints a string representation of this object to the {@linkplain System#out standard
     * output stream}. If a {@linkplain Console console} is attached to the running JVM (i.e.
     * if the application is run from the command-line and the output is not redirected to a
     * file) and if Geotk thinks that the console supports the {@link X364 X3.64} standard,
     * then a syntax coloring will be applied.
     * <p>
     * This is a convenience method for debugging purpose and for console applications.
     *
     * {@note We don't use the standard error stream (the stream used by the Java logging
     *        framework) because it is different than the stream used by the console.}
     *
     * @since 3.00
     */
    @Debug
    public void print() {
        PrintWriter out = null;
        final Console console = System.console();
        if (console != null) {
            out = console.writer();
        }
        final boolean color = (out != null) && X364.isSupported();
        final String wkt = formatWKT(Convention.OGC, defaultIndentation, color, false);
        if (out != null) {
            out.println(wkt);
        } else {
            System.out.println(wkt);
        }
    }

    /**
     * Returns a string representation for this object. The default implementation returns the same
     * string than {@link #toWKT()}, except that no exception is thrown if the string contains
     * non-standard keywords. For example the WKT specification does not defines any keyword for
     * {@linkplain CoordinateSystem coordinate system} objects. If this object is an instance of
     * {@link org.geotoolkit.referencing.cs.DefaultCartesianCS}, then the WKT will be formatted as
     * <code>CartesianCS[AXIS["</code>...<code>"], AXIS["</code>...<code>"], </code><i>etc.</i><code>]</code>.
     */
    @Override
    public String toString() {
        return formatWKT(Convention.OGC, defaultIndentation, false, false);
    }

    /**
     * Returns a <cite>Well Known Text</cite> (WKT) using the
     * {@linkplain WKTFormat#getDefaultIndentation default indentation}.
     *
     * @return The Well Know Text for this object.
     * @throws UnformattableObjectException If this object can't be formatted as WKT.
     *
     * @see org.opengis.referencing.IdentifiedObject#toWKT()
     */
    public String toWKT() throws UnformattableObjectException {
        return formatWKT(Convention.OGC, defaultIndentation, false, true);
    }

    /**
     * Returns a <cite>Well Known Text</cite> (WKT) for this object using the specified
     * indentation.
     *
     * @param  indentation The amount of spaces to use in indentation for WKT formatting,
     *         or {@value org.geotoolkit.io.wkt.WKTFormat#SINGLE_LINE} for formatting the
     *         whole WKT on a single line.
     * @return The Well Know Text for this object.
     * @throws UnformattableObjectException If this object can't be formatted as WKT.
     *
     * @deprecated Replaced by {@link #toWKT(Convention, int)} with {@link Convention#OGC}.
     *             This method will be removed in order to simplify the API.
     */
    @Deprecated
    public String toWKT(final int indentation) throws UnformattableObjectException {
        return formatWKT(Convention.OGC, indentation, false, true);
    }

    /**
     * Returns a <cite>Well Known Text</cite> (WKT) for this object using the specified
     * indentation and authority. The authority is usually {@link #OGC}, but other common
     * authorities are {@link #GEOTIFF} and {@link #EPSG}. The {@link #INTERNAL} citation
     * is a special value for debugging map projections.
     *
     * @param  authority The authority to prefer when choosing WKT entities names.
     * @param  indentation The amount of spaces to use in indentation for WKT formatting,
     *         or {@value org.geotoolkit.io.wkt.WKTFormat#SINGLE_LINE} for formatting the
     *         whole WKT on a single line.
     * @return The Well Know Text for this object.
     * @throws UnformattableObjectException If this object can't be formatted as WKT.
     *
     * @deprecated Replaced by {@link #toWKT(Convention, int)}.
     */
    @Deprecated
    public String toWKT(final Citation authority, final int indentation)
            throws UnformattableObjectException
    {
        return toWKT(Convention.forCitation(authority, Convention.OGC), indentation);
    }

    /**
     * Returns a <cite>Well Known Text</cite> (WKT) for this object using the specified
     * convention and indentation. The convention is usually {@link Convention#OGC OGC},
     * but other common conventions are {@link Convention#GEOTIFF GEOTIFF} and
     * {@link Convention#EPSG EPSG}. The {@link Convention#INTERNAL INTERNAL}
     * convention is a special value for debugging map projections.
     *
     * @param  convention The convention for choosing WKT entities names.
     *         The default value is {@link #OGC}.
     * @param  indentation The amount of spaces to use in indentation for WKT formatting,
     *         or {@value org.geotoolkit.io.wkt.WKTFormat#SINGLE_LINE} for formatting the
     *         whole WKT on a single line.
     * @return The Well Know Text for this object.
     * @throws UnformattableObjectException If this object can't be formatted as WKT.
     *
     * @since 3.20 (derived from 3.00)
     */
    public String toWKT(final Convention convention, final int indentation)
            throws UnformattableObjectException
    {
        ArgumentChecks.ensureNonNull("convention", convention);
        return formatWKT(convention, indentation, false, true);
    }

    /**
     * Returns a WKT for this object using the specified convention and indentation.
     * If {@code strict} is true, then an exception is thrown if the WKT contains
     * invalid keywords.
     *
     * @param  convention The convention for choosing WKT entities names.
     *         The default value is {@link #OGC}.
     * @param  indentation The amount of spaces to use in indentation for WKT formatting,
     *         or {@value org.geotoolkit.io.wkt.WKTFormat#SINGLE_LINE} for formatting the
     *         whole WKT on a single line.
     * @param  color {@code true} for applying syntax coloring, or {@code false} otherwise.
     * @param  strict {@code true} if an exception should be thrown for unformattable objects,
     *         or {@code false} for providing a non-standard formatting instead. The default
     *         value is {@code true}.
     * @return The Well Know Text for this object.
     * @throws UnformattableObjectException If {@code strict} is {@code true} and this object
     *         can't be formatted as WKT.
     */
    private String formatWKT(final Convention convention, final int indentation,
                             final boolean color, final boolean strict)
             throws UnformattableObjectException
    {
        Formatter formatter = FORMATTER.get();
        if (formatter == null) {
            formatter = new Formatter();
            FORMATTER.set(formatter);
        }
        formatter.indentation = indentation;
        formatter.colors = color ? Colors.DEFAULT : null;
        formatter.setConvention(convention, null);
        try {
            if (this instanceof GeneralParameterValue) {
                // Special processing for parameter values, which is formatted
                // directly in 'Formatter'. Note that in GeoAPI, this interface
                // doesn't share the same parent interface than other interfaces.
                formatter.append((GeneralParameterValue) this);
            } else {
                formatter.append(this);
            }
            if (strict && formatter.isInvalidWKT() && formatter.getConvention() != Convention.INTERNAL) {
                final Class<?> unformattable = formatter.getUnformattableClass();
                throw new UnformattableObjectException(formatter.warning, unformattable);
            }
            return formatter.toString();
        } finally {
            formatter.clear();
        }
    }

    /**
     * {@inheritDoc}
     *
     * The default implementation declares that this object produces an invalid WKT.
     * Subclasses must override this method for proper WKT formatting and should
     * <strong>not</strong> invoke {@code super.formatWKT(formatter)} if they can
     * use a valid WKT syntax.
     *
     * @see #toWKT()
     * @see #toString()
     *
     * @level advanced
     */
    @Override
    public String formatWKT(final Formatter formatter) {
        Class<?> type = getClass();
        formatter.setInvalidWKT(type);
        final Class<?>[] interfaces = type.getInterfaces();
        for (final Class<?> candidate : interfaces) {
            final String name = candidate.getName();
            if (name.startsWith("org.opengis.") && !name.startsWith("org.opengis.util.")) {
                type = candidate;
                break;
            }
        }
        return Classes.getShortName(type);
    }

    /**
     * Returns the default indentation. The default value can be modified by a call to
     * {@link #setDefaultIndentation}.
     *
     * @return The default indentation.
     *
     * @since 3.00
     *
     * @deprecated Moved to {@link WKTFormat#getDefaultIndentation()}.
     */
    @Deprecated
    public static int getDefaultIndentation() {
        return defaultIndentation;
    }

    /**
     * Sets the default value for indentation.
     *
     * @param indentation The new default value for indentation.
     *
     * @since 3.00
     *
     * @deprecated Moved to {@link WKTFormat#setDefaultIndentation(int)}.
     */
    @Deprecated
    @Configuration
    public static void setDefaultIndentation(final int indentation) {
        // No need to synchronize since setting a 32 bits integer is an atomic operation.
        defaultIndentation = indentation;
    }
}
