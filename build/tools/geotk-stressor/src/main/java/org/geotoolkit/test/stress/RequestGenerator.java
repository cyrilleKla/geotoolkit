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
package org.geotoolkit.test.stress;

import java.util.Arrays;
import java.util.Random;

import org.opengis.coverage.grid.GridEnvelope;
import org.opengis.referencing.operation.Matrix;
import org.opengis.referencing.datum.PixelInCell;

import org.geotoolkit.math.XMath;
import org.geotoolkit.coverage.grid.GeneralGridEnvelope;
import org.geotoolkit.coverage.grid.GeneralGridGeometry;
import org.geotoolkit.referencing.operation.matrix.XMatrix;
import org.geotoolkit.referencing.operation.transform.LinearTransform;
import org.geotoolkit.referencing.operation.transform.ProjectiveTransform;


/**
 * Generates random grid geometries in order to create random requests.
 *
 * @author Martin Desruisseaux (Geomatys)
 * @version 3.15
 *
 * @since 3.14
 */
public class RequestGenerator {
    /**
     * The random number generator.
     */
    final Random random;

    /**
     * Contains the maximal extent of the random envelopes to be generated by
     * {@link #getRandomGrid()}. This grid geometry must have a valid CRS.
     */
    protected final GeneralGridGeometry domain;

    /**
     * The minimal grid size to be requested. The default value is 1 for every dimensions.
     * Subclass constructors can modify those values in-place if they need different ones.
     */
    protected final int[] minimalGridSize;

    /**
     * The maximal grid size to be requested. The default value is the grid span for every
     * dimensions. Subclass constructors can modify those values in-place if they need
     * different ones.
     */
    protected final int[] maximalGridSize;

    /**
     * The maximal scale factor, relative to the domain <cite>grid to CRS</cite>. Shall always
     * be greater or equals than 1. The default value is computed in such a way that the image
     * at the largest resolution is 256 pixels width or height.
     *
     * @since 3.15
     */
    private double maximumScale = Double.POSITIVE_INFINITY;

    /**
     * The domain <cite>grid to CRS</cite> transform, represented as a matrix.
     */
    private final XMatrix gridToCRS;

    /**
     * Creates a new request generator for the given domain. The domain shall use an
     * affine <cite>grid to CRS</cite> transform.
     *
     * @param domain Contains the maximal extent of the random envelopes to be generated.
     */
    public RequestGenerator(final GeneralGridGeometry domain) {
        this.random    = new Random();
        this.domain    = domain;
        this.gridToCRS = (XMatrix) ((LinearTransform) domain.getGridToCRS(PixelInCell.CELL_CORNER)).getMatrix();
        final GridEnvelope gridRange = domain.getGridRange();
        final int dimension = gridRange.getDimension();
        minimalGridSize = new int[dimension];
        maximalGridSize = new int[dimension];
        Arrays.fill(minimalGridSize, 1);
        for (int i=0; i<dimension; i++) {
            final double s = (maximalGridSize[i] = gridRange.getSpan(i)) / 256.0;
            if (s < maximumScale) {
                maximumScale = s;
            }
        }
    }

    /**
     * Returns the current maximal scale factor relative to the domain resolution.
     *
     * @return The maximal scale factor, as a value equals or greater than 1.
     *
     * @since 3.15
     */
    public double getMaximumScale() {
        return maximumScale;
    }

    /**
     * Sets the maximal scale factor, relative to the domain <cite>grid to CRS</cite>. The scale
     * shall always be greater or equals than 1. The default value is computed in such a way that
     * the image at the largest resolution is 256 pixels width or height.
     *
     * @param scale
     *
     * @since 3.15
     */
    public void setMaximumScale(final double scale) {
        if (!(scale >= 1)) {
            throw new IllegalArgumentException("Illegal maximum scale: " + scale);
        }
        maximumScale = scale;
    }

    /**
     * Returns a random grid geometry inside the {@linkplain #domain}. The grid envelope
     * size will range from {@link #minimalGridSize} to {@link #maximalGridSize} inclusive.
     * The <cite>grid to CRS</cite> transform is scaled to a maximal factor of
     * {@link #maximumScale} compare to the original grid.
     *
     * @return A new random grid geometry inside the domain.
     */
    public GeneralGridGeometry getRandomGrid() {
        final GridEnvelope gridRange = domain.getGridRange();
        final int dimension = gridRange.getDimension();
        final int[] lower = new int[dimension];
        final int[] upper = new int[dimension];
        final double samp = Math.sqrt(maximumScale - 1);
        final XMatrix mx  = gridToCRS.clone();
        for (int i=0; i<dimension; i++) {
            /*
             * Select a scale between 1 and maximumScale,
             * with highest probability for low values.
             */
            double scale = samp*random.nextDouble();
            scale = (scale * scale) + 1;
            assert (scale >= 1 && scale <= maximumScale) : scale;
            mx.setElement(i, i, scale * mx.getElement(i, i));
            /*
             * Compute the bounds.
             */
            int span = minimalGridSize[i];
            span += random.nextInt(maximalGridSize[i] - span + 1);
            int min = (int) Math.ceil ( gridRange.getLow (i)      / scale);
            int max = (int) Math.floor((gridRange.getHigh(i) + 1) / scale);
            final int remainingSpace = (max - min) - span;
            if (remainingSpace > 0) {
                min += random.nextInt(remainingSpace + 1);
                max = min + span;
            }
            lower[i] = min;
            upper[i] = max;
        }
        return new GeneralGridGeometry(new GeneralGridEnvelope(lower, upper, false),
                PixelInCell.CELL_CORNER, ProjectiveTransform.create(mx),
                domain.getCoordinateReferenceSystem());
    }

    /**
     * Returns the resolution of the given grid geometry, in units of the envelope.
     *
     * @param  request The grid geometry from which to extract the resolution.
     * @return The resolution, in units of the envelope.
     */
    public static double[] getResolution(final GeneralGridGeometry request) {
        final Matrix gridToCRS = ((LinearTransform) request.getGridToCRS()).getMatrix();
        final double[] row = new double[gridToCRS.getNumCol() - 1];
        final double[] res = new double[gridToCRS.getNumRow() - 1];
        for (int j=0; j<res.length; j++) {
            for (int i=0; i<row.length; i++) {
                row[i] = gridToCRS.getElement(j, i);
            }
            res[j] = XMath.magnitude(row);
        }
        return res;
    }
}