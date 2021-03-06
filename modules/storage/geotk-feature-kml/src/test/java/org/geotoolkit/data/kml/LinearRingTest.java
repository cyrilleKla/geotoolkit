/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2010, Geomatys
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
package org.geotoolkit.data.kml;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;

import java.net.URISyntaxException;
import org.geotoolkit.data.kml.xml.KmlReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.geotoolkit.data.kml.model.Boundary;
import org.geotoolkit.data.kml.model.Kml;
import org.geotoolkit.data.kml.model.KmlException;
import org.geotoolkit.data.kml.model.KmlModelConstants;
import org.geotoolkit.data.kml.model.LinearRing;
import org.geotoolkit.data.kml.model.Polygon;
import org.geotoolkit.data.kml.xml.KmlWriter;
import org.geotoolkit.xml.DomCompare;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.geotoolkit.feature.Feature;
import org.geotoolkit.feature.FeatureFactory;
import org.geotoolkit.feature.Property;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;


/**
 *
 * @author Samuel Andrés
 * @module pending
 */
public class LinearRingTest {

    private static final double DELTA = 0.000000000001;
    private static final String pathToTestFile = "src/test/resources/org/geotoolkit/data/kml/linearRing.kml";
    private static final FeatureFactory FF = FeatureFactory.LENIENT;

    public LinearRingTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void linarRingReadTest() throws IOException, XMLStreamException, KmlException, URISyntaxException {

        final KmlReader reader = new KmlReader();
        reader.setInput(new File(pathToTestFile));
        final Kml kmlObjects = reader.read();
        reader.dispose();

        final Feature placemark = kmlObjects.getAbstractFeature();
        assertEquals("LinearRing.kml", placemark.getProperty(KmlModelConstants.ATT_NAME.getName()).getValue());
        assertTrue(placemark.getProperty(KmlModelConstants.ATT_PLACEMARK_GEOMETRY.getName()).getValue() instanceof Polygon);
        final Boundary outerBoundaryIs = ((Polygon) placemark.getProperty(KmlModelConstants.ATT_PLACEMARK_GEOMETRY.getName()).getValue()).getOuterBoundary();
        final LinearRing linearRing = outerBoundaryIs.getLinearRing();
        final CoordinateSequence coordinates = linearRing.getCoordinateSequence();

        assertEquals(5, coordinates.size());

        Coordinate coordinate0 = coordinates.getCoordinate(0);
        assertEquals(-122.365662, coordinate0.x, DELTA);
        assertEquals(37.826988, coordinate0.y, DELTA);
        assertEquals(0, coordinate0.z, DELTA);

        Coordinate coordinate1 = coordinates.getCoordinate(1);
        assertEquals(-122.365202, coordinate1.x, DELTA);
        assertEquals(37.826302, coordinate1.y, DELTA);
        assertEquals(0, coordinate1.z, DELTA);

        Coordinate coordinate2 = coordinates.getCoordinate(2);
        assertEquals(-122.364581, coordinate2.x, DELTA);
        assertEquals(37.82655, coordinate2.y, DELTA);
        assertEquals(0, coordinate2.z, DELTA);

        Coordinate coordinate3 = coordinates.getCoordinate(3);
        assertEquals(-122.365038, coordinate3.x, DELTA);
        assertEquals(37.827237, coordinate3.y, DELTA);
        assertEquals(0, coordinate3.z, DELTA);

        Coordinate coordinate4 = coordinates.getCoordinate(4);
        assertEquals(-122.365662, coordinate4.x, DELTA);
        assertEquals(37.826988, coordinate4.y, DELTA);
        assertEquals(0, coordinate4.z, DELTA);


    }

    @Test
    public void linearRingWriteTest() throws KmlException, IOException, XMLStreamException, ParserConfigurationException, SAXException {
        final KmlFactory kmlFactory = DefaultKmlFactory.getInstance();

        final Coordinate coordinate0 = kmlFactory.createCoordinate("-122.365662,37.826988,0.0");
        final Coordinate coordinate1 = kmlFactory.createCoordinate("-122.365202,37.826302,0.0");
        final Coordinate coordinate2 = kmlFactory.createCoordinate("-122.364581,37.82655,0.0");
        final Coordinate coordinate3 = kmlFactory.createCoordinate("-122.365038,37.827237,0.0");
        final Coordinate coordinate4 = kmlFactory.createCoordinate("-122.365662,37.826988,0.0");

        final CoordinateSequence coordinates = kmlFactory.createCoordinates(Arrays.asList(
                coordinate0, coordinate1, coordinate2, coordinate3, coordinate4));

        final LinearRing linearRing = kmlFactory.createLinearRing(coordinates);

        final Boundary outerBoundaryIs = kmlFactory.createBoundary();
        outerBoundaryIs.setLinearRing(linearRing);

        final Polygon polygon = kmlFactory.createPolygon(outerBoundaryIs, null);

        final Feature placemark = kmlFactory.createPlacemark();
        final Collection<Property> placemarkProperties = placemark.getProperties();
        placemarkProperties.add(FF.createAttribute("LinearRing.kml", KmlModelConstants.ATT_NAME, null));
        placemarkProperties.add(FF.createAttribute(polygon, KmlModelConstants.ATT_PLACEMARK_GEOMETRY, null));

        final Kml kml = kmlFactory.createKml(null, placemark, null, null);

        final File temp = File.createTempFile("testLinearRing", ".kml");
        temp.deleteOnExit();

        final KmlWriter writer = new KmlWriter();
        writer.setOutput(temp);
        writer.write(kml);
        writer.dispose();

        DomCompare.compare(
                new File(pathToTestFile), temp);

    }
}
