/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
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
package org.geotoolkit.display2d.style;

import org.geotoolkit.style.MutableStyleFactory;
import org.geotoolkit.style.DefaultStyleFactory;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import org.geotoolkit.data.FeatureStoreUtilities;
import org.geotoolkit.data.FeatureCollection;
import org.geotoolkit.data.FeatureWriter;
import org.geotoolkit.feature.FeatureTypeBuilder;
import java.awt.Color;
import java.awt.Dimension;
import org.geotoolkit.display.PortrayalException;
import org.geotoolkit.display2d.GO2Hints;
import org.geotoolkit.display2d.service.CanvasDef;
import org.geotoolkit.display2d.service.DefaultPortrayalService;
import org.geotoolkit.display2d.service.SceneDef;
import org.geotoolkit.display2d.service.ViewDef;
import org.geotoolkit.factory.Hints;
import org.apache.sis.geometry.GeneralEnvelope;
import org.geotoolkit.map.MapBuilder;
import org.geotoolkit.map.MapContext;
import org.apache.sis.referencing.CommonCRS;
import org.geotoolkit.feature.Feature;
import org.geotoolkit.feature.type.FeatureType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test that symbolizer renderer are properly called and only once.
 *
 * @author Johann Sorel (Geomatys)
 * @module pending
 */
public class MokSymbolizerTest {

    private static final GeometryFactory GF = new GeometryFactory();
    private static final MutableStyleFactory SF = new DefaultStyleFactory();


    private final MapContext context;
    private final GeneralEnvelope env;

    public MokSymbolizerTest() throws Exception {

        env = new GeneralEnvelope(CommonCRS.WGS84.normalizedGeographic());
        env.setRange(0, -180, 180);
        env.setRange(1, -90, 90);

        context = MapBuilder.createContext();

        // create the feature collection for tests -----------------------------
        final FeatureTypeBuilder sftb = new FeatureTypeBuilder();
        sftb.setName("test");
        sftb.add("geom", Point.class, CommonCRS.WGS84.normalizedGeographic());
        sftb.add("att1", String.class);
        sftb.add("att2", Double.class);
        final FeatureType sft = sftb.buildSimpleFeatureType();
        FeatureCollection col = FeatureStoreUtilities.collection("id", sft);

        final FeatureWriter writer = col.getSession().getFeatureStore().getFeatureWriterAppend(sft.getName());
        Feature sf = writer.next();
        sf.setPropertyValue("geom", GF.createPoint(new Coordinate(0, 0)));
        sf.setPropertyValue("att1", "value1");
        writer.write();
        sf = writer.next();
        sf.setPropertyValue("geom", GF.createPoint(new Coordinate(-180, -90)));
        sf.setPropertyValue("att1", "value1");
        writer.write();
        sf = writer.next();
        sf.setPropertyValue("geom", GF.createPoint(new Coordinate(-180, 90)));
        sf.setPropertyValue("att1", "value1");
        writer.write();
        sf = writer.next();
        sf.setPropertyValue("geom", GF.createPoint(new Coordinate(180, -90)));
        sf.setPropertyValue("att1", "value1");
        writer.write();
        sf = writer.next();
        sf.setPropertyValue("geom", GF.createPoint(new Coordinate(180, -90)));
        sf.setPropertyValue("att1", "value1");
        writer.write();
        writer.close();

        context.layers().add(MapBuilder.createFeatureLayer(col, SF.style(new MokSymbolizer())));

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
    public void testSymbolizer() throws PortrayalException {

        //test normal pass
        Hints hints = new Hints();
        hints.put(GO2Hints.KEY_MULTI_THREAD, Boolean.FALSE);
        hints.put(GO2Hints.KEY_SYMBOL_RENDERING_ORDER, GO2Hints.SYMBOL_RENDERING_SECOND);

        MokSymbolizerRenderer.called = 0;
        DefaultPortrayalService.portray(
                new CanvasDef(new Dimension(500, 500),Color.WHITE),
                new SceneDef(context,hints),
                new ViewDef(env));

        assertEquals(5, MokSymbolizerRenderer.called);


        //test multithread
        hints = new Hints();
        hints.put(GO2Hints.KEY_MULTI_THREAD, Boolean.TRUE);
        hints.put(GO2Hints.KEY_SYMBOL_RENDERING_ORDER, GO2Hints.SYMBOL_RENDERING_SECOND);

        MokSymbolizerRenderer.called = 0;
        DefaultPortrayalService.portray(
                new CanvasDef(new Dimension(500, 500),Color.WHITE),
                new SceneDef(context,hints),
                new ViewDef(env));

        assertEquals(5, MokSymbolizerRenderer.called);


        //test symbol rendering order
        hints = new Hints();
        hints.put(GO2Hints.KEY_MULTI_THREAD, Boolean.FALSE);
        hints.put(GO2Hints.KEY_SYMBOL_RENDERING_ORDER, GO2Hints.SYMBOL_RENDERING_PRIME);

        MokSymbolizerRenderer.called = 0;
        DefaultPortrayalService.portray(
                new CanvasDef(new Dimension(500, 500),Color.WHITE),
                new SceneDef(context,hints),
                new ViewDef(env));

        assertEquals(5, MokSymbolizerRenderer.called);


        //test symbol rendering order + multithread
        hints = new Hints();
        hints.put(GO2Hints.KEY_MULTI_THREAD, Boolean.TRUE);
        hints.put(GO2Hints.KEY_SYMBOL_RENDERING_ORDER, GO2Hints.SYMBOL_RENDERING_PRIME);

        MokSymbolizerRenderer.called = 0;
        DefaultPortrayalService.portray(
                new CanvasDef(new Dimension(500, 500),Color.WHITE),
                new SceneDef(context,hints),
                new ViewDef(env));

        assertEquals(5, MokSymbolizerRenderer.called);



    }

}
