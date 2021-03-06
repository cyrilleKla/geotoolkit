/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2011, Geomatys
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
package org.geotoolkit.process.jts.boundary;

import com.vividsolutions.jts.geom.Geometry;

import org.geotoolkit.geometry.jts.JTS;
import org.geotoolkit.process.AbstractProcess;
import org.geotoolkit.process.ProcessException;

import org.opengis.parameter.ParameterValueGroup;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.util.FactoryException;

import static org.geotoolkit.process.jts.boundary.BoundaryDescriptor.*;
import static org.geotoolkit.parameter.Parameters.*;

/**
 * Compute boundary geometry of given geometry.
 * The returned boundary keep the CRS of the given geometry.
 * @author Quentin Boileau (Geomatys)
 * @module pending
 */
public class BoundaryProcess extends AbstractProcess {

    public BoundaryProcess(final ParameterValueGroup input) {
        super(INSTANCE,input);
    }

    @Override
    protected void execute() throws ProcessException {

        try {
            final Geometry geom = value(GEOM, inputParameters);

            final CoordinateReferenceSystem geomCRS = JTS.findCoordinateReferenceSystem(geom);

            final Geometry result = geom.getBoundary();
            JTS.setCRS(result, geomCRS);

            getOrCreate(RESULT_GEOM, outputParameters).setValue(result);


        } catch (NoSuchAuthorityCodeException ex) {
            throw new ProcessException(ex.getMessage(), this, ex);
        } catch (FactoryException ex) {
            throw new ProcessException(ex.getMessage(), this, ex);
        }
    }

}
