/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2007 - 2008, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2008 - 2009, Johann Sorel
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
package org.geotoolkit.gui.swing.render2d.control.information;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import org.apache.sis.internal.util.UnmodifiableArrayList;
import org.geotoolkit.display2d.canvas.J2DCanvas;
import org.geotoolkit.gui.swing.render2d.CanvasHandler;
import org.geotoolkit.gui.swing.render2d.JMap2D;
import org.geotoolkit.gui.swing.render2d.control.navigation.MouseNavigatonListener;
import org.apache.sis.internal.referencing.j2d.AffineTransform2D;
import org.apache.sis.util.logging.Logging;

/**
 * Lenght mesure handler
 *
 * @author Johann Sorel (Puzzle-GIS)
 * @module pending
 */
public class LenghtHandler implements CanvasHandler {

    private static final Logger LOGGER = Logging.getLogger(LenghtHandler.class);

    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory();

    public static final List<Unit> UNITS = UnmodifiableArrayList.wrap(new Unit[] {(Unit)SI.KILOMETRE,SI.METRE});

    private final MouseListen mouseInputListener;

    private final List<Coordinate> coords = new ArrayList<Coordinate>();
    private final LenghtDecoration deco = new LenghtDecoration();
    private final JMap2D map;

    public LenghtHandler(final JMap2D map) {
        this.map = map;
        mouseInputListener = new MouseListen();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void install(final Component component) {
        mouseInputListener.install(component);
        map.addDecoration(0,deco);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void uninstall(final Component component) {
        mouseInputListener.uninstall(component);
        map.removeDecoration(deco);
    }

    private void updateGeometry(){
        final List<Geometry> geoms = new ArrayList<Geometry>();
        if(coords.size() == 1){
            //single point
            geoms.add(GEOMETRY_FACTORY.createPoint(coords.get(0)));
        }else if(coords.size() > 1){
            //line
            geoms.add(GEOMETRY_FACTORY.createLineString(coords.toArray(new Coordinate[coords.size()])));
        }

        deco.setGeometries(geoms);
    }

    @Override
    public J2DCanvas getCanvas() {
        return map.getCanvas();
    }


    //---------------------PRIVATE CLASSES--------------------------------------
    private class MouseListen extends MouseNavigatonListener {

        MouseListen(){
            super(map);
        }

        @Override
        public void mouseClicked(final MouseEvent e) {
            super.mouseClicked(e);

            final int mousebutton = e.getButton();
            if (mousebutton == MouseEvent.BUTTON1) {
                //add a coordinate
                final AffineTransform2D trs = map.getCanvas().getObjectiveToDisplay();
                try {
                    final AffineTransform dispToObj = trs.createInverse();
                    final double[] crds = new double[]{e.getX(),e.getY()};
                    dispToObj.transform(crds, 0, crds, 0, 1);
                    coords.add(new Coordinate(crds[0], crds[1]));
                    updateGeometry();
                } catch (NoninvertibleTransformException ex) {
                    LOGGER.log(Level.WARNING, null, ex);
                }

            } else if (mousebutton == MouseEvent.BUTTON3) {
                //erase coordiantes
                coords.clear();
                updateGeometry();
            }

        }

        @Override
        public void mouseEntered(final MouseEvent e) {
            map.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            map.setCursor(null);
        }
        
        

    }

}
