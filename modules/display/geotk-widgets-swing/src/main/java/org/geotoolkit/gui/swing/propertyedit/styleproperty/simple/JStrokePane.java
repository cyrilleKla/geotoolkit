/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2012 Geomatys
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
package org.geotoolkit.gui.swing.propertyedit.styleproperty.simple;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import org.geotoolkit.gui.swing.util.EmptyCellRenderer;
import org.geotoolkit.gui.swing.resource.MessageBundle;
import org.geotoolkit.gui.swing.style.JLineCapExpressionPane;
import org.geotoolkit.gui.swing.style.JLineJoinExpressionPane;
import org.geotoolkit.gui.swing.style.JNumberExpressionPane;
import org.geotoolkit.gui.swing.style.JPreview;
import org.geotoolkit.gui.swing.style.StyleBank;
import org.geotoolkit.gui.swing.style.StyleElementEditor;
import org.geotoolkit.map.MapLayer;
import org.geotoolkit.style.StyleConstants;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import org.opengis.filter.expression.Expression;
import org.opengis.style.Fill;
import org.opengis.style.Stroke;

/**
 * Stroke editor.
 *
 * @author Fabien Rétif (Geomatys)
 * @author Johann Sorel (Geomatys)
 */
public class JStrokePane extends StyleElementEditor<Stroke> {

    private final StyleBank model = StyleBank.getInstance();
    private MapLayer layer = null;
    
    /**
     * Creates new form JStrokePane and initializes number graphic component
     */
    public JStrokePane() {
        super(Stroke.class);
        initComponents();
        guiFill.setBackground(this.getBackground());
        guiLineType.setRenderer(new LineRenderer());
        guiLineType.setModel(new ListComboBoxModel(model.getCandidates(new StyleBank.ByClassComparator(new Class[]{Stroke.class}))));

        guiWidth.setModel(0d, 0d, Double.POSITIVE_INFINITY, 0.1d);

        guiLineCap.setExpressionVisible(false);
        guiLineJoin.setExpressionVisible(false);
        guiWidth.setExpressionVisible(false);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void setLayer(final MapLayer layer) {
        this.layer = layer;
        guiFill.setLayer(layer);
        guiLineCap.setLayer(layer);
        guiLineJoin.setLayer(layer);
        guiWidth.setLayer(layer);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public MapLayer getLayer() {
        return layer;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void parse(final Stroke stroke) {

        if (stroke != null) {
            guiWidth.parse(stroke.getWidth());
            guiLineCap.parse(stroke.getLineCap());
            guiLineJoin.parse(stroke.getLineJoin());
            Fill strokeFill = getStyleFactory().fill(stroke.getGraphicFill(), stroke.getColor(), stroke.getOpacity());
            guiFill.parse(strokeFill);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Stroke create() {
        Fill strokeFill = guiFill.create();
        final Expression dashOffset = StyleConstants.LITERAL_ZERO_FLOAT;

        if (strokeFill.getGraphicFill() != null) {
            return getStyleFactory().stroke(strokeFill.getGraphicFill(), strokeFill.getColor(), strokeFill.getOpacity(), guiWidth.create(), guiLineJoin.create(), guiLineCap.create(), ((Stroke) guiLineType.getSelectedItem()).getDashArray(), dashOffset);
        } else if (strokeFill.getColor() != null) {
            return getStyleFactory().stroke(strokeFill.getColor(), strokeFill.getOpacity(), guiWidth.create(), guiLineJoin.create(), guiLineCap.create(), ((Stroke) guiLineType.getSelectedItem()).getDashArray(), dashOffset);
        } else {
            return getStyleFactory().stroke();
        }
    }

    @Override
    protected Object[] getFirstColumnComponents() {
        return new Object[]{};
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        guiLineType = new JComboBox();
        guiLineJoin = new JLineJoinExpressionPane();
        guiLineCap = new JLineCapExpressionPane();
        jLabel6 = new JLabel();
        guiWidth = new JNumberExpressionPane();
        guiFill = new JFillControlPane();

        jLabel1.setText(MessageBundle.getString("style")); // NOI18N

        jLabel3.setText(MessageBundle.getString("linejoin")); // NOI18N

        jLabel4.setText(MessageBundle.getString("linecap")); // NOI18N

        jLabel5.setText(MessageBundle.getString("width")); // NOI18N

        guiLineType.setModel(new DefaultComboBoxModel(new String[] { "ligne simple 1pt", "ligne simple 2pt", "ligne double 1pt", "ligne double 4pt" }));
        guiLineType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                guiLineTypeItemStateChanged(evt);
            }
        });

        guiLineJoin.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                JStrokePane.this.propertyChange(evt);
            }
        });

        guiLineCap.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                JStrokePane.this.propertyChange(evt);
            }
        });

        jLabel6.setText(MessageBundle.getString("fill")); // NOI18N

        guiWidth.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                JStrokePane.this.propertyChange(evt);
            }
        });

        guiFill.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                JStrokePane.this.propertyChange(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(guiLineType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(guiWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(guiLineCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(guiLineJoin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(guiFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jLabel3, jLabel4, jLabel5, jLabel6});

        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(guiLineType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(guiFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(guiLineJoin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(guiLineCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(guiWidth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {guiLineCap, guiLineJoin, jLabel3, jLabel4});

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {guiFill, jLabel6});

    }// </editor-fold>//GEN-END:initComponents

    private void guiLineTypeItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_guiLineTypeItemStateChanged
        guiWidth.parse(((Stroke) evt.getItem()).getWidth());
    }//GEN-LAST:event_guiLineTypeItemStateChanged

    private void propertyChange(PropertyChangeEvent evt) {//GEN-FIRST:event_propertyChange
        if (PROPERTY_UPDATED.equalsIgnoreCase(evt.getPropertyName())) {
            firePropertyChange(PROPERTY_UPDATED, null, create());
        }
    }//GEN-LAST:event_propertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JFillControlPane guiFill;
    private JLineCapExpressionPane guiLineCap;
    private JLineJoinExpressionPane guiLineJoin;
    private JComboBox guiLineType;
    private JNumberExpressionPane guiWidth;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    /**
     * Redefines ListRenderer in order to display preview of stroke
     */
    private static class LineRenderer extends DefaultListCellRenderer {

        private final JPreview preview = new JPreview();

        @Override
        public Component getListCellRendererComponent(JList jlist, Object o, int i, boolean bln, boolean bln1) {
            final JLabel lbl = (JLabel) super.getListCellRendererComponent(jlist, o, i, bln, bln1);

            final JPanel pane = new JPanel(new BorderLayout());
            pane.add(BorderLayout.CENTER, lbl);
            pane.add(BorderLayout.WEST, preview);
            pane.setOpaque(false);
            EmptyCellRenderer.mimicStyle(lbl, preview);
            
            if (o instanceof Stroke) {
                Stroke symbol = (Stroke) o;
                preview.parse(symbol);
                lbl.setText(symbol.getWidth().evaluate(null, String.class));

            }

            return pane;

        }
    }
}
