/*
 *    Geotoolkit.org - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2010, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2010, Geomatys
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
 */
package org.geotoolkit.referencing.adapters;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import javax.measure.unit.SI;

import ucar.nc2.Variable;
import ucar.nc2.units.DateUnit;
import ucar.nc2.constants.AxisType;
import ucar.nc2.dataset.VariableDS;
import ucar.nc2.dataset.NetcdfDataset;
import ucar.nc2.dataset.CoordinateAxis;
import ucar.nc2.dataset.CoordinateAxis1D;
import ucar.nc2.dataset.CoordinateSystem;
import ucar.nc2.dataset.CoordinateAxis1DTime;

import org.opengis.metadata.extent.Extent;
import org.opengis.util.InternationalString;
import org.opengis.referencing.operation.Matrix;
import org.opengis.referencing.operation.Projection;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.cs.TimeCS;
import org.opengis.referencing.cs.VerticalCS;
import org.opengis.referencing.cs.CartesianCS;
import org.opengis.referencing.cs.EllipsoidalCS;
import org.opengis.referencing.crs.CompoundCRS;
import org.opengis.referencing.crs.TemporalCRS;
import org.opengis.referencing.crs.VerticalCRS;
import org.opengis.referencing.crs.ProjectedCRS;
import org.opengis.referencing.crs.GeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.datum.TemporalDatum;
import org.opengis.referencing.datum.VerticalDatum;
import org.opengis.referencing.datum.GeodeticDatum;
import org.opengis.coverage.grid.GridGeometry;
import org.opengis.coverage.grid.GridEnvelope;

import org.geotoolkit.measure.Units;
import org.geotoolkit.resources.Errors;
import org.geotoolkit.image.io.WarningProducer;
import org.geotoolkit.internal.image.io.Warnings;
import org.geotoolkit.util.collection.UnmodifiableArrayList;
import org.geotoolkit.referencing.crs.DefaultGeographicCRS;
import org.geotoolkit.referencing.datum.DefaultGeodeticDatum;
import org.geotoolkit.referencing.operation.matrix.MatrixFactory;
import org.geotoolkit.referencing.operation.transform.ProjectiveTransform;
import org.geotoolkit.coverage.grid.GeneralGridEnvelope;
import org.geotoolkit.referencing.datum.DefaultTemporalDatum;
import org.geotoolkit.referencing.datum.DefaultVerticalDatum;


/**
 * Wraps a NetCDF {@link CoordinateSystem} as an implementation of GeoAPI interfaces.
 * This class implements both the GeoAPI {@link org.opengis.referencing.cs.CoordinateSystem} and
 * {@link CoordinateReferenceSystem} interfaces because the NetCDF {@code CoordinateSystem}
 * object combines the concepts of both of them. It also implements the {@link GridGeometry}
 * interface since NetCDF Coordinate Systems contain all information related to the image grid.
 *
 * {@section Axis order}
 * The order of axes returned by {@link #getAxis(int)} is reversed compared to the order of axes
 * in the wrapped NetCDF coordinate system. This is because the NetCDF convention stores axes in
 * the (<var>time</var>, <var>height</var>, <var>latitude</var>, <var>longitude</var>) order, while
 * the Geotk referencing framework typically uses the (<var>longitude</var>, <var>latitude</var>,
 * <var>height</var>, <var>time</var>) order.
 *
 * {@section Restrictions}
 * Current implementation has the following restrictions:
 * <ul>
 *   <li><p>This class supports only axes of kind {@link CoordinateAxis1D}. Callers can verify this
 *       condition with a call to the {@link CoordinateSystem#isProductSet() isProductSet()} method
 *       on the wrapped NetCDF coordinate system, which shall returns {@code true}.</p></li>
 *
 *   <li><p>At the time of writing, the NetCDF API doesn't specify the CRS datum. Consequently the
 *       current implementation assumes that all {@code NetcdfCRS} instances use the
 *       {@linkplain DefaultGeodeticDatum#WGS84 WGS84} geodetic datum.</p></li>
 *
 *   <li><p>This class assumes that the list of NetCDF axes returned by
 *       {@link CoordinateSystem#getCoordinateAxes() getCoordinateAxes()} is stable during the
 *       lifetime of this {@code NetcdfCRS} instance.</p></li>
 * </ul>
 *
 * @author Martin Desruisseaux (Geomatys)
 * @version 3.14
 *
 * @since 3.08
 * @module
 */
public class NetcdfCRS extends NetcdfIdentifiedObject implements CoordinateReferenceSystem,
        org.opengis.referencing.cs.CoordinateSystem, GridGeometry
{
    /**
     * The NetCDF coordinate system wrapped by this {@code NetcdfCRS} instance.
     */
    private final CoordinateSystem cs;

    /**
     * The NetCDF axes.
     */
    private final NetcdfAxis[] axes;

    /**
     * The grid envelope, computed when first needed.
     */
    private transient GridEnvelope gridEnvelope;

    /**
     * The grid to CRS transform, computed when first needed.
     */
    private transient MathTransform gridToCRS;

    /**
     * Creates a new {@code NetcdfCRS} object wrapping the given NetCDF coordinate system.
     * The {@link CoordinateSystem#getCoordinateAxes()} is invoked at construction time and
     * every elements are assumed instance of {@link CoordinateAxis1D}.
     *
     * @param  netcdfCS The NetCDF coordinate system to wrap.
     * @throws ClassCastException If at least one axis is not an instance of the
     *         {@link CoordinateAxis1D} subclass.
     */
    protected NetcdfCRS(final CoordinateSystem netcdfCS) throws ClassCastException {
        this(netcdfCS, netcdfCS.getCoordinateAxes());
    }

    /**
     * Creates a new {@code NetcdfCRS} object wrapping the given axes of the given NetCDF
     * coordinate system. The axes will be retained in reverse order, as documented in
     * class javadoc.
     *
     * @param  netcdfCS The NetCDF coordinate system to wrap.
     * @param  The axes to add, in reverse order.
     */
    NetcdfCRS(final CoordinateSystem netcdfCS, final List<CoordinateAxis> netcdfAxis) {
        ensureNonNull("netcdfCS", netcdfCS);
        cs = netcdfCS;
        final int dimension = netcdfAxis.size();
        axes = new NetcdfAxis[dimension];
        for (int i=0; i<dimension; i++) {
            // Adds the axis in reverse order. See class javadoc for explanation.
            axes[(dimension-1) - i] = new NetcdfAxis((CoordinateAxis1D) netcdfAxis.get(i));
        }
    }

    /**
     * Creates a new {@code NetcdfCRS} with {@link NetcdfAxis} instances fetched
     * from the given components. This is used by the {@link Compound} constructor.
     */
    NetcdfCRS(final CoordinateSystem netcdfCS, final NetcdfCRS... components) {
        cs = netcdfCS;
        final List<NetcdfAxis> axes = new ArrayList<NetcdfAxis>(netcdfCS.getRankRange());
        for (final NetcdfCRS c : components) {
            axes.addAll(Arrays.asList(c.axes));
        }
        this.axes = axes.toArray(new NetcdfAxis[axes.size()]);
    }

    /**
     * Creates a new {@code NetcdfCRS} object wrapping the given NetCDF coordinate system.
     * The returned object may implement any of the {@link ProjectedCRS}, {@link GeographicCRS}
     * {@link VerticalCRS} or {@link TemporalCRS}, depending on the {@linkplain AxisType axis
     * types}.
     * <p>
     * If the NetCDF object contains different kind of CRS, then the returned CRS will be an
     * instance of {@link CompoundCRS} in which each component implements one of the above-cited
     * interfaces.
     * <p>
     * If the NetCDF object contains axes of unknown type, then the returned CRS will not
     * implement any of the above-cited interfaces.
     *
     * @param  netcdfCS The NetCDF coordinate system to wrap.
     * @return A wrapper for the given object, or {@code null} if the argument was null.
     * @throws ClassCastException If at least one axis is not an instance of the
     *         {@link CoordinateAxis1D} subclass.
     */
    public static NetcdfCRS wrap(final CoordinateSystem netcdfCS) throws ClassCastException {
        try {
            return wrap(netcdfCS, null, null);
        } catch (IOException e) {
            throw new AssertionError(e); // Should never happen, since we didn't performed any I/O.
        }
    }

    /**
     * Creates a new {@code NetcdfCRS} object, optionally using the given file for completing
     * dataset file. This method performs the same work than {@link #wrap(CoordinateSystem)},
     * except that more accurate coordinate axes may be created if a reference to the original
     * dataset file is created. This apply especially to {@link CoordinateAxis1DTime}.
     * <p>
     *
     * @param  netcdfCS The NetCDF coordinate system to wrap.
     * @param  file The originating dataset file, or {@code null} if none.
     * @param  logger An optional object where to log warnings, or {@code null} if none.
     * @return A wrapper for the given object, or {@code null} if the argument was null.
     * @throws ClassCastException If at least one axis is not an instance of the
     *         {@link CoordinateAxis1D} subclass.
     * @throws IOException If an I/O operation was needed and failed.
     *
     * @since 3.14
     */
    public static NetcdfCRS wrap(final CoordinateSystem netcdfCS, final NetcdfDataset file,
                final WarningProducer logger) throws IOException, ClassCastException
    {
        if (netcdfCS == null) {
            return null;
        }
        /*
         * Separate the horizontal, vertical and temporal components. We need to iterate
         * over the Netcdf axes in reverse order (see class javadoc). We don't use the
         * CoordinateAxis.getTaxis() and similar methods because we want to ensure that
         * the components are build in the same order than axes are found.
         */
        final List<NetcdfCRS> components = new ArrayList<NetcdfCRS>(4);
        final List<CoordinateAxis>  axes = netcdfCS.getCoordinateAxes();
        for (int i=axes.size(); --i>=0;) {
            CoordinateAxis1D axis = (CoordinateAxis1D) axes.get(i);
            switch (axis.getAxisType()) {
                case Pressure:
                case Height:
                case GeoZ: {
                    components.add(new Vertical(netcdfCS, axis));
                    break;
                }
                case RunTime:
                case Time: {
                    components.add(new Temporal(netcdfCS, Temporal.complete(axis, file, logger)));
                    break;
                }
                case Lat:
                case Lon: {
                    final int upper = i+1;
                    i = lower(axes, i, AxisType.Lat, AxisType.Lon);
                    components.add(new Geographic(netcdfCS, axes.subList(i, upper)));
                    break;
                }
                case GeoX:
                case GeoY: {
                    final int upper = i+1;
                    i = lower(axes, i, AxisType.GeoX, AxisType.GeoY);
                    components.add(new Projected(netcdfCS, axes.subList(i, upper)));
                    break;
                }
                default: {
                    // Unknown axes: do not try to split.
                    return new NetcdfCRS(netcdfCS, axes);
                }
            }
        }
        final int size = components.size();
        switch (size) {
            case 0: return new NetcdfCRS(netcdfCS, axes);
            case 1: return components.get(0);
            default: {
                return new Compound(netcdfCS, components.toArray(new NetcdfCRS[size]));
            }
        }
    }

    /**
     * Returns the lower index of the sublist containing axes of the given types.
     *
     * @param axes  The list from which to get the sublist indices.
     * @param upper The upper index of the sublist, inclusive.
     * @param t1    The first axis type to accept.
     * @param t2    The second axis type to accept.
     * @return      The lower index of the sublist range.
     */
    private static int lower(final List<CoordinateAxis> axes, int upper, final AxisType t1, final AxisType t2) {
        while (upper != 0) {
            final AxisType type = axes.get(upper-1).getAxisType();
            if (!t1.equals(type) && !t2.equals(type)) {
                break;
            }
            upper--;
        }
        return upper;
    }

    /**
     * Returns the wrapped NetCDF coordinate system. Note that the dimension of the returned
     * NetCDF coordinate system may be greater than the dimension of the GeoAPI CRS implemented
     * by this object, because NetCDF puts all axes in a single object while GeoAPI CRS may have
     * separated the axes between various kind of CRS ({@link GeographicCRS}, {@link TemporalCRS},
     * <i>etc</i>).
     */
    @Override
    public CoordinateSystem delegate() {
        return cs;
    }

    /**
     * Returns the coordinate system name. The default implementation delegates to
     * {@link CoordinateSystem#getName()}.
     *
     * @see CoordinateSystem#getName()
     */
    @Override
    public String getCode() {
        return cs.getName();
    }

    /**
     * Returns the number of dimensions.
     *
     * @see CoordinateSystem#getRankRange()
     */
    @Override
    public int getDimension() {
        return axes.length;
    }

    /**
     * Returns the coordinate system, which is {@code this}.
     */
    @Override
    public org.opengis.referencing.cs.CoordinateSystem getCoordinateSystem() {
        return this;
    }

    /**
     * Returns the axis at the given dimension. Note that the order of axes returned by this
     * method is reversed compared to the order of axes in the NetCDF coordinate system. See
     * the <a href="#skip-navbar_top">class javadoc</a> for more information.
     *
     * @param  dimension The zero based index of axis.
     * @return The axis at the specified dimension.
     * @throws IndexOutOfBoundsException if {@code dimension} is out of bounds.
     *
     * @see CoordinateSystem#getCoordinateAxes()
     */
    @Override
    public NetcdfAxis getAxis(final int dimension) throws IndexOutOfBoundsException {
        return axes[dimension];
    }

    /**
     * Returns the valid coordinate range of the NetCDF grid coordinates.
     * The lowest valid grid coordinate is zero.
     *
     * @return The valid coordinate range of a grid coverage.
     *
     * @since 3.09
     */
    @Override
    public synchronized GridEnvelope getGridRange() {
        if (gridEnvelope == null) {
            final int[] lower = new int[axes.length];
            final int[] upper = new int[axes.length];
            for (int i=0; i<upper.length; i++) {
                upper[i] = axes[i].delegate().getDimension(0).getLength();
            }
            gridEnvelope = new GeneralGridEnvelope(lower, upper, false);
        }
        return gridEnvelope;
    }

    /**
     * Returns the transform from grid coordinates to this CRS coordinates, or {@code null} if
     * none. The returned transform is often specialized in two ways:
     * <p>
     * <ul>
     *   <li>If the underlying NetCDF coordinate system {@linkplain CoordinateSystem#isRegular()
     *       is regular}, then the returned transform implements the
     *       {@link org.geotoolkit.referencing.operation.transform.LinearTransform} interface.</li>
     *   <li>If in addition of being regular this CRS is also two-dimensional, then the returned
     *       transform is also an instance of Java2D {@link java.awt.geom.AffineTransform}.</li>
     * </ul>
     *
     * {@section Limitation}
     * Current implementation can build a transform only for regular coordinate systems.
     * A future implementation may be more general.
     *
     * @return The transform from grid to this CRS, or {@code null} if none.
     */
    @Override
    public synchronized MathTransform getGridToCRS() {
        if (gridToCRS == null) {
            gridToCRS = getGridToCRS(0, axes.length);
        }
        return gridToCRS;
    }

    /**
     * Returns the transform from grid coordinates to this CRS coordinates in the given
     * range of dimensions. The returned transform is often specialized in two ways:
     * <p>
     * <ul>
     *   <li>If every NetCDF axes in the given range of dimensions are
     *       {@linkplain CoordinateAxis1D#isRegular() regular}, then the returned transform implements
     *       the {@link org.geotoolkit.referencing.operation.transform.LinearTransform} interface.</li>
     *   <li>If in addition of the above the range spans two dimensions (i.e. {@code upperDimension}
     *       - {@code lowerDimension} == 2), then the returned transform is also an instance of Java2D
     *       {@link java.awt.geom.AffineTransform}.</li>
     * </ul>
     *
     * {@section Limitation}
     * Current implementation can build a transform only for regular axes.
     * A future implementation may be more general.
     *
     * @param  lowerDimension Index of the first dimension for which to get the transform.
     * @param  upperDimension Index after the last dimension for which to get the transform.
     * @return The transform from grid to this CRS in the given range of dimensions, or
     *         {@code null} if none.
     * @throws IllegalArgumentException If the given dimensions are not in the
     *         [0 &hellip; {@linkplain #getDimension() dimension}] range.
     */
    public MathTransform getGridToCRS(final int lowerDimension, final int upperDimension) {
        if (lowerDimension < 0 || upperDimension > axes.length || upperDimension < lowerDimension) {
            throw new IllegalArgumentException(Errors.format(
                    Errors.Keys.BAD_RANGE_$2, lowerDimension, upperDimension));
        }
        final int numDimensions = upperDimension - lowerDimension;
        final Matrix matrix = MatrixFactory.create(numDimensions + 1);
        for (int i=0; i<numDimensions; i++) {
            final CoordinateAxis1D axis = axes[lowerDimension + i].delegate();
            if (!axis.isRegular()) {
                return null;
            }
            matrix.setElement(i, i, axis.getIncrement());
            matrix.setElement(i, numDimensions, axis.getStart());
        }
        return ProjectiveTransform.create(matrix);
    }

    /**
     * Returns {@code null} since NetCDF coordinate systems don't specify their domain
     * of validity.
     */
    @Override
    public Extent getDomainOfValidity() {
        return null;
    }

    /**
     * Returns {@code null} since NetCDF coordinate systems don't specify their scope.
     */
    @Override
    public InternationalString getScope() {
        return null;
    }




    /**
     * The CRS for compound CRS.
     *
     * @author Martin Desruisseaux (Geomatys)
     * @version 3.14
     *
     * @since 3.14
     * @module
     */
    private static final class Compound extends NetcdfCRS implements CompoundCRS,
            org.opengis.referencing.cs.CoordinateSystem
    {
        /**
         * The components of this compound CRS.
         */
        private final List<CoordinateReferenceSystem> components;

        /**
         * Wraps the given coordinate system.
         */
        Compound(final CoordinateSystem cs, final NetcdfCRS[] components) {
            super(cs, components);
            this.components = UnmodifiableArrayList.<CoordinateReferenceSystem>wrap(components);
        }

        /**
         * Returns the coordinate system, which is {@code this}.
         */
        @Override
        public org.opengis.referencing.cs.CoordinateSystem getCoordinateSystem() {
            return this;
        }

        /**
         * Returns the components of this compound CRS.
         */
        @Override
        public List<CoordinateReferenceSystem> getComponents() {
            return components;
        }
    }




    /**
     * The CRS for temporal coordinates.
     *
     * @author Martin Desruisseaux (Geomatys)
     * @version 3.14
     *
     * @since 3.14
     * @module
     */
    private static final class Temporal extends NetcdfCRS implements TemporalCRS, TimeCS {
        /**
         * The temporal datum.
         */
        private final TemporalDatum datum;

        /**
         * Wraps the given coordinate system.
         */
        Temporal(final CoordinateSystem cs, final CoordinateAxis netcdfAxis) {
            super(cs, Collections.singletonList(netcdfAxis));
            final String unitSymbol = netcdfAxis.getUnitsString();
            final DateUnit unit;
            try {
                unit = new DateUnit(unitSymbol);
            } catch (Exception e) {
                throw new IllegalArgumentException(Errors.format(
                        Errors.Keys.UNKNOWN_UNIT_$1, unitSymbol), e);
            }
            datum = new DefaultTemporalDatum(unitSymbol, unit.getDateOrigin());
            getAxis(0).unit = Units.multiply(SI.SECOND, unit.getTimeUnit().getValueInSeconds());
        }

        /**
         * If the given axis is not an instance of {@link CoordinateAxis1DTime}, tries to build
         * a {@code CoordinateAxis1DTime} now. Otherwise returns the axis unchanged. This method
         * can be invoked before to pass the axis to the constructor, if desired.
         *
         * @param  axis The axis to check.
         * @param  file The originating dataset, or {@code null} if none.
         * @param  logger An optional object where to log warnings, or {@code null} if none.
         * @return The axis as an (@link CoordinateAxis1DTime} if possible.
         * @throws IOException If an I/O operation was needed and failed.
         */
        static CoordinateAxis complete(CoordinateAxis axis, final NetcdfDataset file,
                final WarningProducer logger) throws IOException
        {
            if (!(axis instanceof CoordinateAxis1DTime) && file != null) {
                final Variable variable = file.findVariable(axis.getNameEscaped());
                if (variable instanceof VariableDS) {
                    final Formatter formatter = (logger != null) ? new Formatter() : null;
                    axis = CoordinateAxis1DTime.factory(file, (VariableDS) variable, formatter);
                    if (formatter != null) {
                        final StringBuilder buffer = (StringBuilder) formatter.out();
                        if (buffer.length() != 0) {
                            Warnings.log(logger, null, NetcdfCRS.class, "wrap", buffer.toString());
                        }
                    }
                }
            }
            return axis;
        }

        /**
         * Returns the coordinate system, which is {@code this}.
         */
        @Override
        public TimeCS getCoordinateSystem() {
            return this;
        }

        /**
         * Returns the datum.
         */
        @Override
        public TemporalDatum getDatum() {
            return datum;
        }
    }




    /**
     * The CRS for vertical coordinates.
     *
     * @author Martin Desruisseaux (Geomatys)
     * @version 3.14
     *
     * @since 3.14
     * @module
     */
    private static final class Vertical extends NetcdfCRS implements VerticalCRS, VerticalCS {
        /**
         * The vertical datum.
         */
        private final VerticalDatum datum;

        /**
         * Wraps the given coordinate system.
         */
        Vertical(final CoordinateSystem cs, final CoordinateAxis netcdfAxis) {
            super(cs, Collections.singletonList(netcdfAxis));
            switch (netcdfAxis.getAxisType()) {
                case Pressure: datum = DefaultVerticalDatum.BAROMETRIC;    break;
                case Height:   datum = DefaultVerticalDatum.GEOIDAL;       break;
                case GeoZ:     datum = DefaultVerticalDatum.ELLIPSOIDAL;   break;
                default:       datum = DefaultVerticalDatum.OTHER_SURFACE; break;
            }
        }

        /**
         * Returns the coordinate system, which is {@code this}.
         */
        @Override
        public VerticalCS getCoordinateSystem() {
            return this;
        }

        /**
         * Returns the datum.
         */
        @Override
        public VerticalDatum getDatum() {
            return datum;
        }
    }




    /**
     * The CRS for geographic coordinates.
     *
     * @author Martin Desruisseaux (Geomatys)
     * @version 3.08
     *
     * @since 3.08
     * @module
     */
    private static final class Geographic extends NetcdfCRS implements GeographicCRS, EllipsoidalCS {
        /**
         * Wraps the given coordinate system.
         */
        Geographic(final CoordinateSystem cs, final List<CoordinateAxis> netcdfAxis) {
            super(cs, netcdfAxis);
        }

        /**
         * Returns the coordinate system, which is {@code this}.
         */
        @Override
        public EllipsoidalCS getCoordinateSystem() {
            return this;
        }

        /**
         * Returns the datum, which is assumed WGS84.
         */
        @Override
        public GeodeticDatum getDatum() {
            return DefaultGeodeticDatum.WGS84;
        }
    }




    /**
     * The CRS for projected coordinates.
     *
     * @author Martin Desruisseaux (Geomatys)
     * @version 3.08
     *
     * @since 3.08
     * @module
     */
    private static final class Projected extends NetcdfCRS implements ProjectedCRS, CartesianCS {
        /**
         * Wraps the given coordinate system.
         */
        Projected(final CoordinateSystem cs, final List<CoordinateAxis> netcdfAxis) {
            super(cs, netcdfAxis);
        }

        /**
         * Returns the coordinate system, which is {@code this}.
         */
        @Override
        public CartesianCS getCoordinateSystem() {
            return this;
        }

        /**
         * Returns the datum, which is assumed WGS84.
         */
        @Override
        public GeodeticDatum getDatum() {
            return DefaultGeodeticDatum.WGS84;
        }

        /**
         * Returns the base CRS, which is assumed WGS84.
         */
        @Override
        public GeographicCRS getBaseCRS() {
            return DefaultGeographicCRS.WGS84;
        }

        /**
         * @todo Not yet implemented.
         */
        @Override
        public Projection getConversionFromBase() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
