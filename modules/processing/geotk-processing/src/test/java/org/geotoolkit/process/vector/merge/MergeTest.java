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
package org.geotoolkit.process.vector.merge;

import org.geotoolkit.process.ProcessException;
import org.opengis.util.NoSuchIdentifierException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Polygon;


import org.geotoolkit.data.FeatureStoreUtilities;
import org.geotoolkit.data.FeatureCollection;
import org.geotoolkit.feature.FeatureTypeBuilder;
import org.geotoolkit.feature.FeatureBuilder;
import org.geotoolkit.process.ProcessDescriptor;
import org.geotoolkit.process.ProcessFinder;
import org.geotoolkit.process.vector.AbstractProcessTest;
import org.geotoolkit.referencing.CRS;

import org.geotoolkit.feature.Feature;
import org.geotoolkit.feature.type.FeatureType;
import org.opengis.parameter.ParameterValueGroup;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.util.FactoryException;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test of merge process
 *
 * @author Quentin Boileau @module pending
 */
public class MergeTest extends AbstractProcessTest {

    private static FeatureBuilder sfb;
    private static final GeometryFactory geometryFactory = new GeometryFactory();
    private static FeatureType type;

    public MergeTest() {
        super("merge");
    }

    /**
     * Merge Test with 4 FeatureCollection. 1 - base FeatureCollection 2 - FeatureCollection with same FeatureType as
     * base 3 - FeatureCollection with some attribute like base and with conversion needed 4 - FeatureCollection with
     * none attribute like base
     */
    @Test
    public void testMerge() throws ProcessException, NoSuchIdentifierException, FactoryException {

        // Inputs
        final FeatureCollection featureList1 = buildFeatureList1();
        final FeatureCollection featureList2 = buildFeatureList2();
        final FeatureCollection featureList3 = buildFeatureList3();
        final FeatureCollection featureList4 = buildFeatureList4();

        FeatureCollection[] FCList = new FeatureCollection[4];
        FCList[0] = featureList1;
        FCList[1] = featureList2;
        FCList[2] = featureList3;
        FCList[3] = featureList4;

        // Process
        ProcessDescriptor desc = ProcessFinder.getProcessDescriptor("vector", "merge");

        ParameterValueGroup in = desc.getInputDescriptor().createValue();
        in.parameter("features_in").setValue(FCList);
        org.geotoolkit.process.Process proc = desc.createProcess(in);

        //Features out
        final FeatureCollection featureListOut = (FeatureCollection) proc.call().parameter("feature_out").getValue();
        //Expected Features out
        final FeatureCollection featureListResult = buildResultList();
        assertEquals(featureListOut.getFeatureType(), featureListResult.getFeatureType());
        assertEquals(featureListOut.getID(), featureListResult.getID());
        assertEquals(featureListOut.size(), featureListResult.size());
        assertTrue(featureListOut.containsAll(featureListResult));
    }

    private static FeatureType createSimpleType() throws NoSuchAuthorityCodeException, FactoryException {
        final FeatureTypeBuilder ftb = new FeatureTypeBuilder();
        ftb.setName("MergeTest");
        ftb.add("name", String.class);
        ftb.add("geom1", Polygon.class, CRS.decode("EPSG:3395"));
        ftb.add("geom2", Geometry.class, CRS.decode("EPSG:3395"));

        ftb.setDefaultGeometry("geom1");
        final FeatureType sft = ftb.buildFeatureType();
        return sft;
    }

    private static FeatureType createSimpleType2() throws NoSuchAuthorityCodeException, FactoryException {
        final FeatureTypeBuilder ftb = new FeatureTypeBuilder();
        ftb.setName("Merge2Test");
        ftb.add("name", Integer.class);
        ftb.add("geom1", Geometry.class, CRS.decode("EPSG:3395"));
        ftb.add("color", String.class);
        ftb.add("geom3", Geometry.class, CRS.decode("EPSG:3395"));

        ftb.setDefaultGeometry("geom1");
        final FeatureType sft = ftb.buildFeatureType();
        return sft;
    }

    private static FeatureType createSimpleType3() throws NoSuchAuthorityCodeException, FactoryException {
        final FeatureTypeBuilder ftb = new FeatureTypeBuilder();
        ftb.setName("Merge3Test");
        ftb.add("height", Integer.class);
        ftb.add("geom4", Geometry.class, CRS.decode("EPSG:3395"));
        ftb.add("color", String.class);
        ftb.setDefaultGeometry("geom4");
        final FeatureType sft = ftb.buildFeatureType();
        return sft;
    }

    private static FeatureCollection buildFeatureList1() throws FactoryException {

        type = createSimpleType();

        final FeatureCollection featureList = FeatureStoreUtilities.collection("", type);


        Feature myFeature1;
        LinearRing ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(3.0, 3.0),
                    new Coordinate(3.0, 4.0),
                    new Coordinate(4.0, 4.0),
                    new Coordinate(4.0, 3.0),
                    new Coordinate(3.0, 3.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature1");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", geometryFactory.createPoint(new Coordinate(3.5, 3.5)));
        myFeature1 = sfb.buildFeature("id-01");
        featureList.add(myFeature1);

        Feature myFeature2;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(5.0, 6.0),
                    new Coordinate(5.0, 7.0),
                    new Coordinate(6.0, 7.0),
                    new Coordinate(6.0, 6.0),
                    new Coordinate(5.0, 6.0)
                });
        MultiPoint multPt = geometryFactory.createMultiPoint(
                new Coordinate[]{
                    new Coordinate(5.0, 4.0),
                    new Coordinate(3.0, 6.0),
                    new Coordinate(4.0, 7.0),
                    new Coordinate(5.5, 6.5)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature2");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", multPt);
        myFeature2 = sfb.buildFeature("id-02");
        featureList.add(myFeature2);

        Feature myFeature3;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(9.0, 4.0),
                    new Coordinate(9.0, 5.0),
                    new Coordinate(11.0, 5.0),
                    new Coordinate(11.0, 4.0),
                    new Coordinate(9.0, 4.0)
                });
        LineString line = geometryFactory.createLineString(
                new Coordinate[]{
                    new Coordinate(7.0, 0.0),
                    new Coordinate(9.0, 3.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature3");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", line);
        myFeature3 = sfb.buildFeature("id-03");
        featureList.add(myFeature3);

        return featureList;
    }

    private static FeatureCollection buildFeatureList2() throws FactoryException {

        type = createSimpleType();
        final FeatureCollection featureList = FeatureStoreUtilities.collection("", type);


        Feature myFeature1;
        LinearRing ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(1.0, 4.0),
                    new Coordinate(1.0, 5.0),
                    new Coordinate(2.0, 5.0),
                    new Coordinate(2.0, 4.0),
                    new Coordinate(1.0, 4.0)
                });
        MultiPoint multPt = geometryFactory.createMultiPoint(
                new Coordinate[]{
                    new Coordinate(1.0, 6.0), //nothing
                    new Coordinate(3.0, 6.0), //intersection with a point
                    new Coordinate(3.5, 3.5) //intersection with a polygon
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature11");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", multPt);
        myFeature1 = sfb.buildFeature("id-11");
        featureList.add(myFeature1);

        Feature myFeature2;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(4.0, 2.0),
                    new Coordinate(4.0, 5.0),
                    new Coordinate(7.0, 5.0),
                    new Coordinate(7.0, 2.0),
                    new Coordinate(4.0, 2.0)
                });
        LineString line = geometryFactory.createLineString(
                new Coordinate[]{
                    new Coordinate(8.0, 4.5),
                    new Coordinate(11.0, 4.5)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature12");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", line);
        myFeature2 = sfb.buildFeature("id-12");
        featureList.add(myFeature2);

        Feature myFeature3;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(0.0, 0.0),
                    new Coordinate(0.0, 8.0),
                    new Coordinate(10.0, 8.0),
                    new Coordinate(10.0, 0.0),
                    new Coordinate(0.0, 0.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature13");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", null);
        myFeature3 = sfb.buildFeature("id-13");
        featureList.add(myFeature3);

        return featureList;
    }

    private static FeatureCollection buildFeatureList3() throws FactoryException {

        type = createSimpleType2();

        final FeatureCollection featureList = FeatureStoreUtilities.collection("", type);


        Feature myFeature1;
        LinearRing ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(1.0, 4.0),
                    new Coordinate(1.0, 5.0),
                    new Coordinate(2.0, 5.0),
                    new Coordinate(2.0, 4.0),
                    new Coordinate(1.0, 4.0)
                });
        MultiPoint multPt = geometryFactory.createMultiPoint(
                new Coordinate[]{
                    new Coordinate(1.0, 6.0), //nothing
                    new Coordinate(3.0, 6.0), //intersection with a point
                    new Coordinate(3.5, 3.5) //intersection with a polygon
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", 21);
        sfb.setPropertyValue("color", "grey");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom3", multPt);
        myFeature1 = sfb.buildFeature("id-21");
        featureList.add(myFeature1);

        Feature myFeature2;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(4.0, 2.0),
                    new Coordinate(4.0, 5.0),
                    new Coordinate(7.0, 5.0),
                    new Coordinate(7.0, 2.0),
                    new Coordinate(4.0, 2.0)
                });
        LineString line = geometryFactory.createLineString(
                new Coordinate[]{
                    new Coordinate(8.0, 4.5),
                    new Coordinate(11.0, 4.5)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", 22);
        sfb.setPropertyValue("color", "red");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom3", line);
        myFeature2 = sfb.buildFeature("id-22");
        featureList.add(myFeature2);

        Feature myFeature3;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(0.0, 0.0),
                    new Coordinate(0.0, 8.0),
                    new Coordinate(10.0, 8.0),
                    new Coordinate(10.0, 0.0),
                    new Coordinate(0.0, 0.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", 23);
        sfb.setPropertyValue("color", "blue");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom3", null);
        myFeature3 = sfb.buildFeature("id-23");
        featureList.add(myFeature3);

        return featureList;
    }

    private static FeatureCollection buildFeatureList4() throws FactoryException {

        type = createSimpleType3();

        final FeatureCollection featureList = FeatureStoreUtilities.collection("", type);


        Feature myFeature1;
        LinearRing ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(1.0, 4.0),
                    new Coordinate(1.0, 5.0),
                    new Coordinate(2.0, 5.0),
                    new Coordinate(2.0, 4.0),
                    new Coordinate(1.0, 4.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("height", 31);
        sfb.setPropertyValue("color", "grey");
        sfb.setPropertyValue("geom4", geometryFactory.createPolygon(ring, null));
        myFeature1 = sfb.buildFeature("id-31");
        featureList.add(myFeature1);

        Feature myFeature2;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(4.0, 2.0),
                    new Coordinate(4.0, 5.0),
                    new Coordinate(7.0, 5.0),
                    new Coordinate(7.0, 2.0),
                    new Coordinate(4.0, 2.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("height", 32);
        sfb.setPropertyValue("color", "red");
        sfb.setPropertyValue("geom4", geometryFactory.createPolygon(ring, null));
        myFeature2 = sfb.buildFeature("id-32");
        featureList.add(myFeature2);

        Feature myFeature3;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(0.0, 0.0),
                    new Coordinate(0.0, 8.0),
                    new Coordinate(10.0, 8.0),
                    new Coordinate(10.0, 0.0),
                    new Coordinate(0.0, 0.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("height", 33);
        sfb.setPropertyValue("color", "blue");
        sfb.setPropertyValue("geom4", geometryFactory.createPolygon(ring, null));
        myFeature3 = sfb.buildFeature("id-33");
        featureList.add(myFeature3);

        return featureList;
    }

    private static FeatureCollection buildResultList() throws FactoryException {


        type = createSimpleType();

        final FeatureCollection featureList = FeatureStoreUtilities.collection("", type);


        Feature myFeature1;
        LinearRing ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(3.0, 3.0),
                    new Coordinate(3.0, 4.0),
                    new Coordinate(4.0, 4.0),
                    new Coordinate(4.0, 3.0),
                    new Coordinate(3.0, 3.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature1");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", geometryFactory.createPoint(new Coordinate(3.5, 3.5)));
        myFeature1 = sfb.buildFeature("id-01");
        featureList.add(myFeature1);

        Feature myFeature2;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(5.0, 6.0),
                    new Coordinate(5.0, 7.0),
                    new Coordinate(6.0, 7.0),
                    new Coordinate(6.0, 6.0),
                    new Coordinate(5.0, 6.0)
                });
        MultiPoint multPt = geometryFactory.createMultiPoint(
                new Coordinate[]{
                    new Coordinate(5.0, 4.0),
                    new Coordinate(3.0, 6.0),
                    new Coordinate(4.0, 7.0),
                    new Coordinate(5.5, 6.5)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature2");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", multPt);
        myFeature2 = sfb.buildFeature("id-02");
        featureList.add(myFeature2);

        Feature myFeature3;
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(9.0, 4.0),
                    new Coordinate(9.0, 5.0),
                    new Coordinate(11.0, 5.0),
                    new Coordinate(11.0, 4.0),
                    new Coordinate(9.0, 4.0)
                });
        LineString line = geometryFactory.createLineString(
                new Coordinate[]{
                    new Coordinate(7.0, 0.0),
                    new Coordinate(9.0, 3.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature3");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", line);
        myFeature3 = sfb.buildFeature("id-03");
        featureList.add(myFeature3);

        ///////////////////////////////////////////////////////////// 2nd FeatureCollection
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(1.0, 4.0),
                    new Coordinate(1.0, 5.0),
                    new Coordinate(2.0, 5.0),
                    new Coordinate(2.0, 4.0),
                    new Coordinate(1.0, 4.0)
                });
        multPt = geometryFactory.createMultiPoint(
                new Coordinate[]{
                    new Coordinate(1.0, 6.0),
                    new Coordinate(3.0, 6.0),
                    new Coordinate(3.5, 3.5)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature11");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", multPt);
        myFeature1 = sfb.buildFeature("id-11");
        featureList.add(myFeature1);

        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(4.0, 2.0),
                    new Coordinate(4.0, 5.0),
                    new Coordinate(7.0, 5.0),
                    new Coordinate(7.0, 2.0),
                    new Coordinate(4.0, 2.0)
                });
        line = geometryFactory.createLineString(
                new Coordinate[]{
                    new Coordinate(8.0, 4.5),
                    new Coordinate(11.0, 4.5)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature12");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", line);
        myFeature2 = sfb.buildFeature("id-12");
        featureList.add(myFeature2);

        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(0.0, 0.0),
                    new Coordinate(0.0, 8.0),
                    new Coordinate(10.0, 8.0),
                    new Coordinate(10.0, 0.0),
                    new Coordinate(0.0, 0.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "feature13");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", null);
        myFeature3 = sfb.buildFeature("id-13");
        featureList.add(myFeature3);
        ////////////////////////////////////////////////////////////////////// 3rd FeatureCollection
        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(1.0, 4.0),
                    new Coordinate(1.0, 5.0),
                    new Coordinate(2.0, 5.0),
                    new Coordinate(2.0, 4.0),
                    new Coordinate(1.0, 4.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "21");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", null);
        myFeature1 = sfb.buildFeature("id-21");
        featureList.add(myFeature1);

        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(4.0, 2.0),
                    new Coordinate(4.0, 5.0),
                    new Coordinate(7.0, 5.0),
                    new Coordinate(7.0, 2.0),
                    new Coordinate(4.0, 2.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "22");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", null);
        myFeature2 = sfb.buildFeature("id-22");
        featureList.add(myFeature2);

        ring = geometryFactory.createLinearRing(
                new Coordinate[]{
                    new Coordinate(0.0, 0.0),
                    new Coordinate(0.0, 8.0),
                    new Coordinate(10.0, 8.0),
                    new Coordinate(10.0, 0.0),
                    new Coordinate(0.0, 0.0)
                });
        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", "23");
        sfb.setPropertyValue("geom1", geometryFactory.createPolygon(ring, null));
        sfb.setPropertyValue("geom2", null);
        myFeature3 = sfb.buildFeature("id-23");
        featureList.add(myFeature3);
        ////////////////////////////////////////////////////////////////////// 4th FeatureCollection

        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", null);
        sfb.setPropertyValue("geom1", null);
        sfb.setPropertyValue("geom2", null);
        myFeature1 = sfb.buildFeature("id-31");
        featureList.add(myFeature1);

        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", null);
        sfb.setPropertyValue("geom1", null);
        sfb.setPropertyValue("geom2", null);
        myFeature2 = sfb.buildFeature("id-32");
        featureList.add(myFeature2);

        sfb = new FeatureBuilder(type);
        sfb.setPropertyValue("name", null);
        sfb.setPropertyValue("geom1", null);
        sfb.setPropertyValue("geom2", null);
        myFeature3 = sfb.buildFeature("id-33");
        featureList.add(myFeature3);


        return featureList;
    }
}
