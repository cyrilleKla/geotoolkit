/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2012-2013, Geomatys
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
package org.geotoolkit.process.chain;

import org.geotoolkit.parameter.DefaultParameterDescriptor;
import org.geotoolkit.parameter.DefaultParameterDescriptorGroup;
import org.geotoolkit.process.AbstractProcess;
import org.geotoolkit.process.AbstractProcessDescriptor;
import org.geotoolkit.process.Process;
import org.geotoolkit.process.ProcessDescriptor;
import org.apache.sis.util.iso.SimpleInternationalString;
import org.opengis.parameter.GeneralParameterDescriptor;
import org.opengis.parameter.ParameterDescriptor;
import org.opengis.parameter.ParameterDescriptorGroup;
import org.opengis.parameter.ParameterValueGroup;

public class MockAddDescriptor extends AbstractProcessDescriptor{

    public static final String NAME = "add";

    public static final ParameterDescriptor<Double> FIRST_NUMBER = new DefaultParameterDescriptor<Double>("first", "", Double.class, null, true);
    public static final ParameterDescriptor<Double> SECOND_NUMBER = new DefaultParameterDescriptor<Double>("second", "", Double.class, null, true);    
    public static final ParameterDescriptorGroup INPUT_DESC =
            new DefaultParameterDescriptorGroup("InputParameters",
            new GeneralParameterDescriptor[]{FIRST_NUMBER,SECOND_NUMBER});

    public static final ParameterDescriptor<Double> RESULT_NUMBER = new DefaultParameterDescriptor<Double>("result", "", Double.class, null, true);
    public static final ParameterDescriptorGroup OUTPUT_DESC =
            new DefaultParameterDescriptorGroup("OutputParameters",
            new GeneralParameterDescriptor[]{RESULT_NUMBER});

    /** Instance */
    public static final ProcessDescriptor INSTANCE = new MockAddDescriptor();

    private MockAddDescriptor() {
        super(NAME, MockProcessRegistry.IDENTIFICATION,
                new SimpleInternationalString(""),INPUT_DESC, OUTPUT_DESC);
    }

    @Override
    public Process createProcess(final ParameterValueGroup input) {
        return new AddProcess(this, input);
    }

    public class AddProcess extends AbstractProcess {

        public AddProcess(final ProcessDescriptor descriptor, final ParameterValueGroup input) {
            super(descriptor, input);
        }

        @Override
        protected void execute() {
            final double first = (Double) inputParameters.parameter(MockAddDescriptor.FIRST_NUMBER.getName().getCode()).getValue();
            final double second = (Double) inputParameters.parameter(MockAddDescriptor.SECOND_NUMBER.getName().getCode()).getValue();
            Double result = first + second;
            outputParameters.parameter(MockAddDescriptor.RESULT_NUMBER.getName().getCode()).setValue(result);
        }
    }
    
}