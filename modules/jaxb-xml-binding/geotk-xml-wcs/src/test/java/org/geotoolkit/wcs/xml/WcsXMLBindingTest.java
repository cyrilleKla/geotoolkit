/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2008 - 2010, Geomatys
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotoolkit.wcs.xml;

import java.io.IOException;
import java.util.Arrays;
import org.geotoolkit.wcs.xml.v100.GetCoverageType;
import java.io.StringWriter;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;

//Junit dependencies
import org.geotoolkit.ows.xml.v110.CodeType;
import org.geotoolkit.wcs.xml.v100.OutputType;
import org.apache.sis.xml.MarshallerPool;
import org.junit.*;
import org.xml.sax.SAXException;

import static org.apache.sis.test.Assert.*;


/**
 *
 * @author Guilhem Legal (Geomatys)
 * @module pending
 */
public class WcsXMLBindingTest {

    private static final MarshallerPool pool = WCSMarshallerPool.getInstance();
    private Marshaller   marshaller;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws JAXBException {
        marshaller = pool.acquireMarshaller();
    }

    @After
    public void tearDown() {
        if (marshaller != null) {
            pool.recycle(marshaller);
        }
    }

    /**
     * Test simple Record Marshalling.
     *
     * @throws JAXBException
     */
    @Test
    public void marshallingTest111() throws JAXBException, IOException, ParserConfigurationException, SAXException {

        org.geotoolkit.wcs.xml.v111.RangeSubsetType.FieldSubset field = new org.geotoolkit.wcs.xml.v111.RangeSubsetType.FieldSubset("id1", "NEAREST");
        org.geotoolkit.wcs.xml.v111.RangeSubsetType dsub = new org.geotoolkit.wcs.xml.v111.RangeSubsetType(Arrays.asList(field));
        org.geotoolkit.wcs.xml.v111.GetCoverageType getCoverage
                = new org.geotoolkit.wcs.xml.v111.GetCoverageType(new CodeType("source1"), null, dsub, new org.geotoolkit.wcs.xml.v111.OutputType(null, "EPSG:4326"));

        StringWriter sw = new StringWriter();
        marshaller.marshal(getCoverage, sw);

        String result = sw.toString();

        String expResult = "<ns5:GetCoverage version=\"1.1.1\" service=\"WCS\"" +
                                    " xmlns:ns5=\"http://www.opengis.net/wcs/1.1.1\"" +
                                    " xmlns:ows=\"http://www.opengis.net/ows/1.1\">" + '\n'
                         + "    <ows:Identifier>source1</ows:Identifier>" + '\n'
                         + "    <ns5:RangeSubset>" + '\n'
                         + "        <ns5:FieldSubset>" + '\n'
                         + "            <ows:Identifier>id1</ows:Identifier>" + '\n'
                         + "            <ns5:InterpolationType>NEAREST</ns5:InterpolationType>" + '\n'
                         + "        </ns5:FieldSubset>" + '\n'
                         + "    </ns5:RangeSubset>" + '\n'
                         + "    <ns5:Output store=\"false\" format=\"EPSG:4326\"/>" + '\n'
                         + "</ns5:GetCoverage>" + '\n';
        assertXmlEquals(expResult, result, "xmlns:*");

    }

    /**
     * Test simple Record Marshalling.
     *
     * @throws JAXBException
     */
    @Test
    public void marshallingTest100() throws JAXBException, IOException, ParserConfigurationException, SAXException {

        GetCoverageType getCoverage = new GetCoverageType("source1", null, null, "nearest neighbor", new OutputType("image/png", "EPSG:4326"));

        StringWriter sw = new StringWriter();
        marshaller.marshal(getCoverage, sw);

        String result = sw.toString();

        String expResult = "<wcs:GetCoverage version=\"1.0.0\" service=\"WCS\" " +
                                    "xmlns:wcs=\"http://www.opengis.net/wcs\">" + '\n' +
                           "    <wcs:sourceCoverage>source1</wcs:sourceCoverage>" + '\n' +
                           "    <wcs:interpolationMethod>nearest neighbor</wcs:interpolationMethod>" + '\n' +
                           "    <wcs:output>" + '\n' +
                           "        <wcs:crs>EPSG:4326</wcs:crs>" + '\n' +
                           "        <wcs:format>image/png</wcs:format>" + '\n' +
                           "    </wcs:output>" + '\n' +
                           "</wcs:GetCoverage>" + '\n' ;
        assertXmlEquals(expResult, result, "xmlns:*");
    }
}
