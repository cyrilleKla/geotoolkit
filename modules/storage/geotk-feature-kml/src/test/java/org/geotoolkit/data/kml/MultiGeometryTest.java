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

import org.geotoolkit.data.kml.model.AbstractGeometry;
import org.geotoolkit.data.kml.model.Kml;
import org.geotoolkit.data.kml.model.KmlException;
import org.geotoolkit.data.kml.model.KmlModelConstants;
import org.geotoolkit.data.kml.model.LineString;
import org.geotoolkit.data.kml.model.MultiGeometry;
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
public class MultiGeometryTest {

    private static final double DELTA = 0.000000000001;
    private static final String pathToTestFile = "src/test/resources/org/geotoolkit/data/kml/multiGeometry.kml";
    private static final FeatureFactory FF = FeatureFactory.LENIENT;

    public MultiGeometryTest() {
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
    public void multiGeometryReadTest() throws IOException, XMLStreamException, KmlException, URISyntaxException {

        final KmlReader reader = new KmlReader();
        reader.setInput(new File(pathToTestFile));
        final Kml kmlObjects = reader.read();
        reader.dispose();

        final Feature placemark = kmlObjects.getAbstractFeature();
        assertEquals("SF Marina Harbor Master", placemark.getProperty(KmlModelConstants.ATT_NAME.getName()).getValue());
        assertFalse((Boolean) placemark.getProperty(KmlModelConstants.ATT_VISIBILITY.getName()).getValue());

        assertTrue(placemark.getProperty(KmlModelConstants.ATT_PLACEMARK_GEOMETRY.getName()).getValue() instanceof MultiGeometry);
        final MultiGeometry multiGeometry = (MultiGeometry) placemark.getProperty(KmlModelConstants.ATT_PLACEMARK_GEOMETRY.getName()).getValue();
        assertEquals(2, multiGeometry.getGeometries().size());
        assertTrue(multiGeometry.getGeometries().get(0) instanceof LineString);
        assertTrue(multiGeometry.getGeometries().get(1) instanceof LineString);
        LineString lineString0 = (LineString) multiGeometry.getGeometries().get(0);
        LineString lineString1 = (LineString) multiGeometry.getGeometries().get(1);

        final CoordinateSequence coordinates0 = lineString0.getCoordinateSequence();
        final CoordinateSequence coordinates1 = lineString1.getCoordinateSequence();
        assertEquals(2, coordinates0.size());
        assertEquals(2, coordinates1.size());

        final Coordinate coordinate00 = coordinates0.getCoordinate(0);
        final Coordinate coordinate01 = coordinates0.getCoordinate(1);
        final Coordinate coordinate10 = coordinates1.getCoordinate(0);
        final Coordinate coordinate11 = coordinates1.getCoordinate(1);

        assertEquals(-122.4425587930444, coordinate00.x, DELTA);
        assertEquals(37.80666418607323, coordinate00.y, DELTA);
        assertEquals(0, coordinate00.z, DELTA);

        assertEquals(-122.4428379594768, coordinate01.x, DELTA);
        assertEquals(37.80663578323093, coordinate01.y, DELTA);
        assertEquals(0, coordinate01.z, DELTA);

        assertEquals(-122.4425509770566, coordinate10.x, DELTA);
        assertEquals(37.80662588061205, coordinate10.y, DELTA);
        assertEquals(0, coordinate10.z, DELTA);

        assertEquals(-122.4428340530617, coordinate11.x, DELTA);
        assertEquals(37.8065999493009, coordinate11.y, DELTA);
        assertEquals(0, coordinate11.z, DELTA);

    }

    @Test
    public void multiGeometryWriteTest() throws KmlException, IOException, XMLStreamException, ParserConfigurationException, SAXException {
        final KmlFactory kmlFactory = DefaultKmlFactory.getInstance();

        final Coordinate coordinate00 = kmlFactory.createCoordinate("-122.4425587930444,37.80666418607323,0.0");
        final Coordinate coordinate01 = kmlFactory.createCoordinate("-122.4428379594768,37.80663578323093,0.0");
        final Coordinate coordinate10 = kmlFactory.createCoordinate("-122.4425509770566,37.80662588061205,0.0");
        final Coordinate coordinate11 = kmlFactory.createCoordinate("-122.4428340530617,37.8065999493009,0.0");

        final CoordinateSequence coordinates0 = kmlFactory.createCoordinates(Arrays.asList(coordinate00, coordinate01));
        final CoordinateSequence coordinates1 = kmlFactory.createCoordinates(Arrays.asList(coordinate10, coordinate11));

        final LineString lineString0 = kmlFactory.createLineString(coordinates0);

        final LineString lineString1 = kmlFactory.createLineString(coordinates1);

        final MultiGeometry multiGeometry = kmlFactory.createMultiGeometry();
        multiGeometry.setGeometries(Arrays.asList((AbstractGeometry) lineString0, (AbstractGeometry) lineString1));

        final Feature placemark = kmlFactory.createPlacemark();
        final Collection<Property> placemarkProperties = placemark.getProperties();
        placemarkProperties.add(FF.createAttribute("SF Marina Harbor Master", KmlModelConstants.ATT_NAME, null));
        placemark.getProperty(KmlModelConstants.ATT_VISIBILITY.getName()).setValue(Boolean.FALSE);
        placemarkProperties.add(FF.createAttribute(multiGeometry, KmlModelConstants.ATT_PLACEMARK_GEOMETRY, null));

        final Kml kml = kmlFactory.createKml(null, placemark, null, null);

        final File temp = File.createTempFile("testMultiGeometry", ".kml");
        temp.deleteOnExit();

        final KmlWriter writer = new KmlWriter();
        writer.setOutput(temp);
        writer.write(kml);
        writer.dispose();

        DomCompare.compare(
                new File(pathToTestFile), temp);

    }
}
