/*
 *    GeoAPI - Java interfaces for OGC/ISO standards
 *    http://www.geoapi.org
 *
 *    Copyright (C) 2006-2014 Open Geospatial Consortium, Inc.
 *    All Rights Reserved. http://www.opengeospatial.org/ogc/legal
 *
 *    Permission to use, copy, and modify this software and its documentation, with
 *    or without modification, for any purpose and without fee or royalty is hereby
 *    granted, provided that you include the following on ALL copies of the software
 *    and documentation or portions thereof, including modifications, that you make:
 *
 *    1. The full text of this NOTICE in a location viewable to users of the
 *       redistributed or derivative work.
 *    2. Notice of any changes or modifications to the OGC files, including the
 *       date changes were made.
 *
 *    THIS SOFTWARE AND DOCUMENTATION IS PROVIDED "AS IS," AND COPYRIGHT HOLDERS MAKE
 *    NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 *    TO, WARRANTIES OF MERCHANTABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT
 *    THE USE OF THE SOFTWARE OR DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY
 *    PATENTS, COPYRIGHTS, TRADEMARKS OR OTHER RIGHTS.
 *
 *    COPYRIGHT HOLDERS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, SPECIAL OR
 *    CONSEQUENTIAL DAMAGES ARISING OUT OF ANY USE OF THE SOFTWARE OR DOCUMENTATION.
 *
 *    The name and trademarks of copyright holders may NOT be used in advertising or
 *    publicity pertaining to the software without specific, written prior permission.
 *    Title to copyright in this software and any associated documentation will at all
 *    times remain with copyright holders.
 */
package org.geotoolkit.feature.type;

import static org.opengis.annotation.Obligation.MANDATORY;
import static org.opengis.annotation.Specification.ISO_19103;

import org.opengis.annotation.UML;

/**
 * A qualified Name (with respect to a namespace rather than just a simple prefix).
 * <p>
 * This interface provides method names similar to the Java QName interface in
 * order to facilitate those transition from an XML models. We are recording
 * the a full namespace (rather than just a prefix) in order to sensibly compare
 * Names produced from different contexts. Since the idea of a "prefix" in a QName
 * is only used to refer to a namespace defined earlier in the document it is sensible
 * for us to ask this prefix be resolved (allowing us to reliability compare names
 * produced from different documents; or defined by different repositories).
 * </p>
 * Notes:
 * <ul>
 * <li>You should not need to use the "separator" when working with Name as a programmer. There
 * is no need to do a string concatenation; just compare getNamespaceURI() and compare
 * getLocalPart(). Do not build a lot of strings to throw away.
 * <li>prefix: If you need to store the prefix information please make use of
 * "client properties" facilities located on PropertyType data structure. The prefix is not
 * a logical part of a Name; but often it is nice to preserve prefix when processing data
 * in order not to disrupt other components in a processing chain.
 * <li>Name is to be understood with respect to its getNamespaceURI(), if needed
 * you make look up a Namespace using this information. This is however not a
 * backpointer (Name does not require a Namespace to be constructed) and the
 * lookup mechanism is not specified, indeed we would recommend the use of JNDI
 * , and we suspect that the Namespace should be lazily created as required.
 * <li>Name may also be "global" in which case the getNamespaceURI() is <code>null</code>, we
 * have made a test for this case explicit with the isGlobal() method.
 * </ul>
 * Name is a lightweight data object with identity (equals method) based on
 * getNameSpaceURI() and getLocalPart() information. This interface is strictly used for
 * identification and should not be extended to express additional functionality.
 * </p>
 *
 * @author Jody Garnett (Refractions Research, Inc.)
 *
 * @deprecated To be replaced by {@link GenericName}.
 * See <a href="http://jira.codehaus.org/browse/GEO-237">GEO-237</a> for details.
 */
@Deprecated
public interface Name extends org.opengis.util.TypeName {

    /**
     * Returns <code>true</code> if getNamespaceURI is <code>null</code>
     *
     * @return Returns <code>true</code> if getNamespaceURI is <code>null</code>
     */
    boolean isGlobal();

    /**
     * Returns the URI of the namespace for this name.
     * <p>
     * In ISO 19103 this is known as <b>scope</b> and containes a backpointer
     * to the containing namespace. This solution is too heavy for our purposes,
     * and we expect applications to provide their own lookup mechanism through
     * which they can use this URI.
     * </p>
     * The namespace URI does serve to make this name unique and is checked as
     * part of the equals operation.
     * </p>
     *
     * @since GeoAPI 2.1
     */
    @UML(identifier = "scope", obligation = MANDATORY, specification = ISO_19103)
    String getNamespaceURI();

    /**
     * Separator to use between getNamespaceURI() and getLocalPart() when
     * constructing getURI().
     * <p>
     * This separator is only used to construct a visually pleasing getURI()
     * result. The value to use as a separator depends on the registry
     * or namespace you are working with. JNDI naming services have
     * been known to use "/" and ":". Referring to an element in an XMLSchema
     * document has been represented with a "#" symbol.
     * <p>
     * @return A separator (such as "/" or ":").
     */
    String getSeparator();

    /**
     * Retrieve the "local" name.
     * <p>
     * This mechanism captures the following ISO 19103 concerns:
     * <ul>
     * <li>GenericName.depth(): this concept is not interesting, we assume a
     * namespace would be able to navigate through contained namespace on its
     * own based on this local part.
     * <li>GenericName.asLocalName()
     * <li>GenericName.name()
     * </ul>
     * @return local name (can be used in namespace lookup)
     */
    String getLocalPart();

    /**
     * Convert this name to a complete URI.
     * <p>
     * This URI is constructed with the getNamespaceURI(), getSeparator() and getLocalPart().
     * </p>
     * <p>
     * This method captures the following concerns of ISO 19103 concerns:
     * <ul>
     * <li>GenericName.getParsedNames()
     * <li>toFullyQuantifiedName()
     * </ul>
     * <p>
     * As an example:
     * <ul>
     * <li>namespace: "gopher://localhost/example" separator: "/" local: "name"
     * <li>namespace: "gopher://localhost" separator: "/" local: "example/name"
     * </ul>
     * Both return: "gopher://localhost/example/name" as they indicate the same entry
     * in the namespace system (such as a Registry or JNDI naming service).
     * </p>
     * @return a complete URI constructed of namespace URI and the local part.
     */
    @UML(identifier = "parsedName", obligation = MANDATORY, specification = ISO_19103)
    String getURI();

    /**
     * Must be based on getURI().
     *
     * @return a hash code based on getURI()
     */
    @Override
    int hashCode();

    /**
     * <code>true</code> if getURI is equal.
     *
     * @param other
     * @return <code>true</code> if getURI is equal.
     */
    @Override
    boolean equals(Object obj);

    /**
     * A local-independent representation of this name, see getURI().
     */
    @Override
    String toString();
}
