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
package org.geotoolkit.process.vector.regroup;

import org.geotoolkit.parameter.DefaultParameterDescriptor;
import org.geotoolkit.parameter.DefaultParameterDescriptorGroup;
import org.geotoolkit.process.ProcessDescriptor;
import org.geotoolkit.process.Process;
import org.geotoolkit.process.vector.VectorDescriptor;

import org.opengis.parameter.GeneralParameterDescriptor;
import org.opengis.parameter.ParameterDescriptor;
import org.opengis.parameter.ParameterDescriptorGroup;
import org.opengis.parameter.ParameterValueGroup;

/**
 * Parameters description of Regroup process.
 * name of the process : "regroup"
 * inputs :
 * <ul>
 *     <li>FEATURE_IN "feature_in" FeatureCollection source</li>
 *     <li>REGROUP_ATTRIBUTE "regroup_attribute" Attribute name to apply the regroup process</li>
 *     <li>GEOMETRY_NAME "regroup_attribute" Geometry property name. Optional</li>
 * </ul>
 * outputs :
 * <ul>
 *     <li>FEATURE_OUT "feature_out" resulting FeatureCollection</li>
 * </ul>
 * @author Quentin Boileau
 * @module pending
 */
public final class RegroupDescriptor extends VectorDescriptor {

    /**Process name : regroup */
    public static final String NAME = "regroup";

    /**
     * Optional - Attribute name to apply the regroup process
     */
    public static final ParameterDescriptor<String> REGROUP_ATTRIBUTE =
            new DefaultParameterDescriptor("regroup_attribute", "Attribute name used for the regroup process", String.class, null, false);

    /**
     * Optional - Geometry property name. Refer to the geometry used for the regroup process
     */
    public static final ParameterDescriptor<String> GEOMETRY_NAME =
            new DefaultParameterDescriptor("geometry_name", "Geometry property name", String.class, null, false);

    /** Input Parameters */
    public static final ParameterDescriptorGroup INPUT_DESC =
            new DefaultParameterDescriptorGroup("InputParameters",
            new GeneralParameterDescriptor[]{FEATURE_IN, REGROUP_ATTRIBUTE,GEOMETRY_NAME});

    /** Ouput Parameters */
    public static final ParameterDescriptorGroup OUTPUT_DESC =
            new DefaultParameterDescriptorGroup("OutputParameters",
            new GeneralParameterDescriptor[]{FEATURE_OUT});
    
    /** Instance */
    public static final ProcessDescriptor INSTANCE = new RegroupDescriptor();

    /**
     * Default constructor
     */
    private RegroupDescriptor() {
        super(NAME, "Return a Featrue Collection generated by the Regroup process"
                + "Each different value of the given attribute name return a Feature.", INPUT_DESC, OUTPUT_DESC);
    }

    /**
     *  {@inheritDoc }
     */
    @Override
    public Process createProcess(final ParameterValueGroup input) {
        return new RegroupProcess(input);
    }
}
