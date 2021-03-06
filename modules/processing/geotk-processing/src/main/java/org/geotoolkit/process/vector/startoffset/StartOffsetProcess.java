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
package org.geotoolkit.process.vector.startoffset;

import org.geotoolkit.data.FeatureCollection;
import org.geotoolkit.data.memory.GenericStartIndexFeatureIterator;
import org.geotoolkit.parameter.Parameters;
import org.geotoolkit.process.AbstractProcess;
import org.opengis.parameter.ParameterValueGroup;

import static org.geotoolkit.process.vector.startoffset.StartOffsetDescriptor.*;
import static org.geotoolkit.parameter.Parameters.*;

/**
 * Start FeatureCollection iteration at given offset
 * @see org.geotoolkit.data.memory.GenericSortByFeatureIterator
 * @author Quentin Boileau
 * @module pending
 */
public class StartOffsetProcess extends AbstractProcess {

    /**
     * Default constructor
     */
    public StartOffsetProcess(final ParameterValueGroup input) {
        super(INSTANCE,input);
    }

    /**
     *  {@inheritDoc }
     */
    @Override
    protected void execute() {
        final FeatureCollection inputFeatureList   = Parameters.value(FEATURE_IN, inputParameters);
        final int offset                                    = Parameters.value(OFFSET_IN, inputParameters);

        final FeatureCollection resultFeatureList = GenericStartIndexFeatureIterator.wrap(inputFeatureList, offset);

        getOrCreate(FEATURE_OUT, outputParameters).setValue(resultFeatureList);
    }
}
