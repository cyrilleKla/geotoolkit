/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2014, Geomatys
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 3 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */

package org.geotoolkit.gui.javafx.chooser;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;
import org.apache.sis.storage.DataStoreException;
import org.geotoolkit.client.ClientFactory;
import org.geotoolkit.coverage.CoverageStoreFactory;
import org.geotoolkit.data.AbstractFolderFeatureStoreFactory;
import org.geotoolkit.data.FeatureStore;
import org.geotoolkit.data.FeatureStoreFactory;
import org.geotoolkit.data.FeatureStoreFinder;
import org.geotoolkit.data.FileFeatureStoreFactory;
import org.geotoolkit.db.AbstractJDBCFeatureStoreFactory;
import org.geotoolkit.font.FontAwesomeIcons;
import org.geotoolkit.font.IconBuilder;
import org.geotoolkit.gui.javafx.parameter.FXParameterEditor;
import org.geotoolkit.gui.javafx.parameter.FXValueEditor;
import org.geotoolkit.gui.javafx.util.FXOptionDialog;
import org.geotoolkit.internal.GeotkFX;
import org.geotoolkit.internal.Loggers;
import org.geotoolkit.map.MapLayer;
import org.geotoolkit.storage.DataStoreFactory;
import org.opengis.parameter.ParameterValueGroup;

/**
 *
 * @author Johann Sorel (Geomatys)
 */
public class FXFeatureStoreChooser extends SplitPane {

    static final Comparator<Object> SORTER = new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            final String o1Name = getText(o1);
            final String o2Name = getText(o1);
            return o1Name.compareTo(o2Name);
        }
        
        private String getText(Object candidate){
            if(candidate instanceof DataStoreFactory){
                return ((DataStoreFactory)candidate).getDisplayName().toString();
            }else if(candidate instanceof ClientFactory){
                return ((ClientFactory)candidate).getDisplayName().toString();
            }else{
                return "";
            }
        }
    };
    
    private final Accordion accordion = new Accordion();
    private final ListView<FeatureStoreFactory> factoryView = new ListView<>();
    private final FXLayerChooser layerChooser = new FXLayerChooser();
    private final FXParameterEditor paramEditor = new FXParameterEditor();
    private final ScrollPane listScroll = new ScrollPane(factoryView);
    private final Button connectButton = new Button(GeotkFX.getString(FXFeatureStoreChooser.class,"apply"));
    private final Label infoLabel = new Label();
        
    public FXFeatureStoreChooser() {
        
        final ObservableList<FeatureStoreFactory> factories = FXCollections.observableArrayList(FeatureStoreFinder.getAvailableFactories(null));
        Collections.sort(factories, SORTER);

        factoryView.setItems(factories);
        factoryView.setCellFactory(new Callback<ListView<FeatureStoreFactory>, ListCell<FeatureStoreFactory>>() {

            @Override
            public ListCell<FeatureStoreFactory> call(ListView<FeatureStoreFactory> param) {
                return new FactoryCell();
            }
        });
        
        listScroll.setFitToHeight(true);
        listScroll.setFitToWidth(true);        
        
        //hide the tree table header
        paramEditor.getTreetable().widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                Pane header = (Pane)paramEditor.getTreetable().lookup("TableHeaderRow");
                if(header!=null && header.isVisible()) {
                  header.setMaxHeight(0);
                  header.setMinHeight(0);
                  header.setPrefHeight(0);
                  header.setVisible(false);
                  header.setManaged(false);
                }
            }
        });
        
        final BorderPane hpane = new BorderPane(infoLabel, null, connectButton, null, null);        
        hpane.setPadding(new Insets(6, 6, 6, 6));
        final BorderPane vpane = new BorderPane(paramEditor, null, null, hpane, null);
        vpane.setPadding(Insets.EMPTY);
        
        final TitledPane paneFactory = new TitledPane(GeotkFX.getString(FXFeatureStoreChooser.class,"factory"), listScroll);
        paneFactory.setFont(Font.font(paneFactory.getFont().getFamily(), FontWeight.BOLD, paneFactory.getFont().getSize()));
        final TitledPane paneConfig = new TitledPane(GeotkFX.getString(FXFeatureStoreChooser.class,"config"), vpane);
        
        accordion.getPanes().add(paneFactory);
        accordion.getPanes().add(paneConfig);
        accordion.setPrefSize(400, 400);        
        accordion.setExpandedPane(paneFactory);
        
        getItems().add(accordion);
        getItems().add(layerChooser);
        
        factoryView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        factoryView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<FeatureStoreFactory>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends FeatureStoreFactory> c) {
                final FeatureStoreFactory factory = factoryView.getSelectionModel().getSelectedItem();
                if(factory==null) return;
                final ParameterValueGroup param = factory.getParametersDescriptor().createValue();
                paramEditor.setParameter(param);        
                accordion.setExpandedPane(paneConfig);
            }
        });
        
        
        connectButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FeatureStore store = null;
                try {
                    layerChooser.setSource(null);
                    store = getStore();
                    layerChooser.setSource(store);
                } catch (DataStoreException ex) {
                    infoLabel.setText("Error "+ex.getMessage());
                    Loggers.JAVAFX.log(Level.WARNING, ex.getMessage(),ex);
                }
            }
        });
        
    }
    
    private void setLayerSelectionVisible(boolean layerVisible) {
        layerChooser.setVisible(layerVisible);
    }
    
    
    private FeatureStore getStore() throws DataStoreException {
        final FeatureStoreFactory factory = factoryView.getSelectionModel().getSelectedItem();

        if(factory == null){
            return null;
        }

        final ParameterValueGroup param = (ParameterValueGroup) paramEditor.getParameter();
        return factory.open(param);
    }
    
    private List<MapLayer> getSelectedLayers() throws DataStoreException {
        return layerChooser.getLayers();
    }
    
    
    /**
     * Display a modal dialog.
     *
     * @return
     * @throws DataStoreException
     */
    public static List<FeatureStore> showDialog(Node parent) throws DataStoreException{
        return showDialog(parent,Collections.EMPTY_LIST);
    }

    /**
     * Display a modal dialog.
     *
     * @param editors : additional FeatureOutline editors
     * @return
     * @throws DataStoreException
     */
    public static List<FeatureStore> showDialog(Node parent, List<FXValueEditor> editors) throws DataStoreException{
        return showDialog(parent,editors, false);
    }

    /**
     * Display a modal dialog choosing layers.
     *
     * @param editors : additional FeatureOutline editors
     * @return
     * @throws DataStoreException
     */
    public static List<MapLayer> showLayerDialog(Node parent, List<FXValueEditor> editors) throws DataStoreException{
        return showDialog(parent,editors, true);
    }

    private static List showDialog(Node parent, List<FXValueEditor> editors, boolean layerVisible) throws DataStoreException{
        final FXFeatureStoreChooser chooser = new FXFeatureStoreChooser();
        if(editors != null){
            chooser.paramEditor.setAvailableEditors(editors);
        }
        chooser.setLayerSelectionVisible(layerVisible);
        
        
        final boolean res = FXOptionDialog.showOkCancel(parent, chooser, "", true);

        if (res) {
            if(layerVisible){
                return chooser.getSelectedLayers();
            }else{
                final FeatureStore store = chooser.getStore();
                if(store == null){
                    return Collections.EMPTY_LIST;
                }else{
                    return Collections.singletonList(store);
                }
            }
        } else {
            return Collections.EMPTY_LIST;
        }

    }

    
    static class FactoryCell extends ListCell{
        
        @Override
        protected void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty);

            setText(null);
            setGraphic(null);
            if(!empty && item!=null){
                if(item instanceof DataStoreFactory){
                    setText(((DataStoreFactory)item).getDisplayName().toString());
                }else if(item instanceof ClientFactory){
                    setText(((ClientFactory)item).getDisplayName().toString());
                }
                setGraphic(new ImageView(findIcon(item)));
            }
        }

    }

    private static final Image EMPTY_24 = SwingFXUtils.toFXImage(new BufferedImage(24, 24, BufferedImage.TYPE_INT_ARGB),null);
    private static final Image ICON_SERVER = SwingFXUtils.toFXImage(IconBuilder.createImage(FontAwesomeIcons.ICON_GLOBE, 24, FontAwesomeIcons.DISABLE_COLOR),null);
    private static final Image ICON_DATABASE = SwingFXUtils.toFXImage(IconBuilder.createImage(FontAwesomeIcons.ICON_DATABASE, 24, FontAwesomeIcons.DISABLE_COLOR),null);
    private static final Image ICON_VECTOR = SwingFXUtils.toFXImage(IconBuilder.createImage(FontAwesomeIcons.ICON_PENCIL_SQUARE, 24, FontAwesomeIcons.DISABLE_COLOR),null);
    private static final Image ICON_COVERAGE = SwingFXUtils.toFXImage(IconBuilder.createImage(FontAwesomeIcons.ICON_PICTURE_O, 24, FontAwesomeIcons.DISABLE_COLOR),null);
    private static final Image ICON_FOLDER = SwingFXUtils.toFXImage(IconBuilder.createImage(FontAwesomeIcons.ICON_FOLDER, 24, FontAwesomeIcons.DISABLE_COLOR),null);
    private static final Image ICON_FILE = SwingFXUtils.toFXImage(IconBuilder.createImage(FontAwesomeIcons.ICON_FILE, 24, FontAwesomeIcons.DISABLE_COLOR),null);

    private static Image findIcon(Object candidate){

        Image icon = EMPTY_24;
        if(candidate instanceof AbstractFolderFeatureStoreFactory){
            icon = ICON_FOLDER;
        }else if(candidate instanceof FileFeatureStoreFactory){
            icon = ICON_FILE;
        }else if(candidate instanceof ClientFactory){
            icon = ICON_SERVER;
        }else if(candidate instanceof AbstractJDBCFeatureStoreFactory){
            icon = ICON_DATABASE;
        }else if(candidate instanceof CoverageStoreFactory){
            icon = ICON_COVERAGE;
        }else if(candidate instanceof FeatureStoreFactory){
            icon = ICON_VECTOR;
        }

        return icon;
    }
    
}
