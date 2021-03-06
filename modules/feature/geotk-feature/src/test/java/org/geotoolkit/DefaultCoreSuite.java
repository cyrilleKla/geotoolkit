/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 * 
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
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
package org.geotoolkit;

import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.geotoolkit.feature.FeatureFlatTest;

/**
 *
 * @author jamesm
 * @module pending
 */                                
public class DefaultCoreSuite extends TestCase {
    private static final Logger LOGGER = org.apache.sis.util.logging.Logging.getLogger("org.geotoolkit.core");
    public DefaultCoreSuite(final java.lang.String testName) {
        super(testName);
    }        
    
    public static Test suite() {
        //_log = org.apache.sis.util.logging.Logging.getLogger(DefaultCoreSuite.class);
       
        
        TestSuite suite = new TestSuite("All core tests");                
        suite.addTestSuite(FeatureFlatTest.class);
        return suite;
    }
}
