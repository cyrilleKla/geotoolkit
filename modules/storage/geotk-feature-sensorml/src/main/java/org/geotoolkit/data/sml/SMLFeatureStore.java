/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2009-2010, Geomatys
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

package org.geotoolkit.data.sml;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;

import org.geotoolkit.data.AbstractFeatureStore;
import org.geotoolkit.data.FeatureStoreFactory;
import org.geotoolkit.data.FeatureStoreFinder;
import org.geotoolkit.data.FeatureStoreRuntimeException;
import org.apache.sis.storage.DataStoreException;
import org.geotoolkit.data.FeatureReader;
import org.geotoolkit.data.FeatureWriter;
import org.geotoolkit.data.query.DefaultQueryCapabilities;
import org.geotoolkit.data.query.Query;
import org.geotoolkit.data.query.QueryCapabilities;
import org.geotoolkit.factory.Hints;
import org.geotoolkit.feature.type.DefaultName;
import org.geotoolkit.feature.FeatureTypeBuilder;
import org.geotoolkit.feature.FeatureUtilities;
import org.geotoolkit.feature.type.DefaultFeatureTypeFactory;
import org.geotoolkit.geometry.jts.SRIDGenerator;
import org.geotoolkit.jdbc.ManageableDataSource;
import org.geotoolkit.referencing.CRS;
import org.geotoolkit.feature.ComplexAttribute;

import org.geotoolkit.feature.Feature;
import org.geotoolkit.feature.FeatureFactory;
import org.geotoolkit.feature.Property;
import org.geotoolkit.feature.type.AttributeDescriptor;
import org.geotoolkit.feature.type.ComplexType;
import org.geotoolkit.feature.type.FeatureType;
import org.geotoolkit.feature.type.FeatureTypeFactory;
import org.geotoolkit.feature.type.Name;
import org.geotoolkit.feature.type.PropertyDescriptor;
import org.opengis.filter.Filter;
import org.opengis.filter.identity.FeatureId;
import org.opengis.parameter.ParameterValueGroup;
import org.opengis.util.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 *
 * @author Guilhem Legal (Geomatys)
 * @author Johann Sorel (Geomatys)
 * @module pending
 */
public class SMLFeatureStore extends AbstractFeatureStore {

    private static final FeatureFactory FF = FeatureFactory.LENIENT;
    private static final FeatureTypeFactory FTF = new DefaultFeatureTypeFactory();
    private static final GeometryFactory GF = new GeometryFactory();

    private final Map<Name,FeatureType> types = new HashMap<Name, FeatureType>();

    private final ManageableDataSource source;

    private static final String SML_NAMESPACE = "http://www.opengis.net/sml/1.0";

    //Root types
    private final static Name SML_TN_SYSTEM         = new DefaultName(SML_NAMESPACE, "System");
    private final static Name SML_TN_COMPONENT      = new DefaultName(SML_NAMESPACE, "Component");
    private final static Name SML_TN_PROCESSCHAIN   = new DefaultName(SML_NAMESPACE, "ProcessChain");
    private final static Name SML_TN_PROCESSMODEL   = new DefaultName(SML_NAMESPACE, "ProcessModel");
    private final static Name SML_TN_DATASOURCETYPE = new DefaultName(SML_NAMESPACE, "DataSourceType");

    //subTypes
    private final static Name SML_KEYWORD_LIST      = new DefaultName(SML_NAMESPACE, "KeywordList");
    private final static Name SML_INPUT_LIST        = new DefaultName(SML_NAMESPACE, "InputList");
    private final static Name SML_OUTPUT_LIST       = new DefaultName(SML_NAMESPACE, "OutputList");
    private final static Name SML_INPUT             = new DefaultName(SML_NAMESPACE, "Input");
    private final static Name SML_OUTPUT            = new DefaultName(SML_NAMESPACE, "Output");

    private static final String pathDescription        = "SensorML:SensorML:member:description";
    private static final String pathName               = "SensorML:SensorML:member:name";
    private static final String pathKeywords           = "SensorML:SensorML:member:keywords:keyword";
    private static final String pathPhenomenonsSystem  = "SensorML:SensorML:member:outputs:output:field:name";
    private static final String pathPhenomenonsCompo   = "SensorML:SensorML:member:outputs:output:definition";
    private static final String pathInputsDef          = "SensorML:SensorML:member:inputs:input:definition";
    private static final String pathInputsNam          = "SensorML:SensorML:member:inputs:input:name";
    private static final String pathOutputsDef         = "SensorML:SensorML:member:outputs:output:field:definition";
    private static final String pathOutputsNam         = "SensorML:SensorML:member:outputs:output:field:name";
    private static final String pathContactType        = "SensorML:SensorML:member:contact:role";
    private static final String pathProducerOrg        = "SensorML:SensorML:member:contact:organizationName";
    private static final String pathProducerInd        = "SensorML:SensorML:member:contact:individualName";
    private static final String pathComponentsNam      = "SensorML:SensorML:member:components:component:name";
    private static final String pathComponentsRef      = "SensorML:SensorML:member:components:component:href";
    private static final String pathMethod             = "SensorML:SensorML:member:description";  // TODO
    private static final String pathCharacteristicsNam = "SensorML:SensorML:member:characteristics:field:field:name";
    private static final String pathCharacteristicsVal = "SensorML:SensorML:member:characteristics:field:field:value";
    private static final String pathLocation           = "SensorML:SensorML:member:location:pos";
    private static final String pathCRS                = "SensorML:SensorML:member:location:pos:srsName";
    private static final String pathSmlRef             = "SensorML:SensorML:member:documentation:onlineResource:href";

    private static final String SQL_MDW_VERSION  = "SELECT * FROM \"version\"";

    private static final String SQL_ALL_FORM_ID  = "SELECT \"identifier\" FROM \"Storage\".\"Forms\" WHERE \"catalog\"='SMLC'";
    private static final String SQL_TEXT_VALUE   = "SELECT \"value\" FROM \"Storage\".\"TextValues\" WHERE \"path\"=? AND \"form\"=?";
    private static final String SQL_TEXT_VALUE_2 = "SELECT \"value\" FROM \"Storage\".\"TextValues\" WHERE \"path\"=? AND \"form\"=?";
    private static final String SQL_SML_TYPE     = "SELECT \"type\" FROM \"Storage\".\"Values\" WHERE \"path\"='SensorML:SensorML:member' AND \"form\"=?";
    private static final String SQL_CONTACT_ROLE = "SELECT \"id_value\"  FROM \"Storage\".\"TextValues\" " +
                                                   "WHERE \"path\"='SensorML:SensorML:member:contact:role' " +
                                                   "AND \"value\"='urn:x-ogc:def:role:producer' " +
                                                   "AND \"form\"=? ";
    private static final String SQL_CONTACT_NAME = "SELECT \"value\" FROM \"Storage\".\"TextValues\" WHERE \"id_value\"=? AND \"form\"=?";

    private static final String SQL_ALL_FORM_ID_21  = "SELECT \"accessionNumber\" FROM \"Storage\".\"Records\" WHERE \"recordSet\"='SMLC'";


    // Shared attributes
    private static final Name ATT_DESC        = new DefaultName(GML_311_NAMESPACE, "description");
    private static final Name ATT_NAME        = new DefaultName(GML_311_NAMESPACE, "name");
    private static final Name ATT_CODESPACE   = new DefaultName(GML_311_NAMESPACE, "codespace");
    private static final Name ATT_KEYWORDS    = new DefaultName(SML_NAMESPACE, "keywords");
    private static final Name ATT_KEYWORD     = new DefaultName(SML_NAMESPACE, "keyword");
    private static final Name ATT_LOCATION    = new DefaultName(SML_NAMESPACE, "location");
    private static final Name ATT_PHENOMENONS = new DefaultName(SML_NAMESPACE, "phenomenons");
    private static final Name ATT_SMLTYPE     = new DefaultName(SML_NAMESPACE, "smltype");
    private static final Name ATT_SMLREF      = new DefaultName(SML_NAMESPACE, "smlref");
    private static final Name ATT_INPUTS      = new DefaultName(SML_NAMESPACE, "inputs");
    private static final Name ATT_INPUT       = new DefaultName(SML_NAMESPACE, "input");
    private static final Name ATT_OUTPUTS     = new DefaultName(SML_NAMESPACE, "outputs");
    private static final Name ATT_OUTPUT      = new DefaultName(SML_NAMESPACE, "output");
    // attribute for sml:System or sml:ProcessChain
    private static final Name ATT_PRODUCER = new DefaultName(SML_NAMESPACE, "producer");
    private static final Name ATT_COMPONENTS = new DefaultName(SML_NAMESPACE, "components");
    // attribute for sml:ProccessModel
    private static final Name ATT_METHOD = new DefaultName(SML_NAMESPACE, "method");
    // attribute for sml:DatasourceType
    private static final Name ATT_CHARACTERISTICS = new DefaultName(SML_NAMESPACE, "characteristics");


    private final QueryCapabilities capabilities = new DefaultQueryCapabilities(false);

    public SMLFeatureStore(final ParameterValueGroup params, final ManageableDataSource source) {
        super(params);
        this.source = source;
        initTypes();
    }

    @Override
    public FeatureStoreFactory getFactory() {
        return FeatureStoreFinder.getFactoryById(SMLFeatureStoreFactory.NAME);
    }

    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    private void initTypes() {
        final FeatureTypeBuilder featureTypeBuilder = new FeatureTypeBuilder();

        //subType KeywordList
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_KEYWORD_LIST);
        featureTypeBuilder.add(ATT_CODESPACE,  String.class, 0, 1, true, null); // TODO xml attribute ?
        featureTypeBuilder.add(ATT_KEYWORD,    List.class, 0, Integer.MAX_VALUE, true, null);

        final ComplexType kwList = featureTypeBuilder.buildType();

        //subType Input
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_INPUT);
        featureTypeBuilder.add(ATT_NAME,     String.class, 0, 1, true, null); // TODO xml attribute ?
        featureTypeBuilder.add(ATT_DESC,     String.class, 0, 1, true, null);

        final ComplexType input = featureTypeBuilder.buildType();


        //subType InputList
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_INPUT_LIST);
        featureTypeBuilder.add(input, ATT_INPUT,    null, 0, Integer.MAX_VALUE, true, null);

        final ComplexType inList = featureTypeBuilder.buildType();

        //subType Output
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_OUTPUT);
        featureTypeBuilder.add(ATT_NAME,     String.class, 0, 1, true, null); // TODO xml attribute ?
        featureTypeBuilder.add(ATT_DESC,     String.class, 0, 1, true, null);

        final ComplexType output = featureTypeBuilder.buildType();

        //subType OutputList
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_OUTPUT_LIST);
        featureTypeBuilder.add(output, ATT_OUTPUT,    null, 0, Integer.MAX_VALUE, true, null);

        final ComplexType outList = featureTypeBuilder.buildType();


        // Feature type sml:System
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_TN_SYSTEM);
        featureTypeBuilder.add(ATT_DESC,        String.class, 0, 1, true, null);
        featureTypeBuilder.add(ATT_NAME,        String.class, 1, 1, false, null);
        featureTypeBuilder.add(kwList, ATT_KEYWORDS,    null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_LOCATION,    Point.class, 1, 1, false, null);
        featureTypeBuilder.add(ATT_PHENOMENONS, List.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_SMLTYPE,     String.class, 1, 1, true, null);
        featureTypeBuilder.add(ATT_SMLREF,      String.class, 1, 1, true, null);
        featureTypeBuilder.add(inList, ATT_INPUTS,      null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(outList, ATT_OUTPUTS,     null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_PRODUCER,    Map.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_COMPONENTS,  Map.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.setDefaultGeometry(ATT_LOCATION);
        types.put(SML_TN_SYSTEM, featureTypeBuilder.buildFeatureType());

        // Feature type sml:Component
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_TN_COMPONENT);
        featureTypeBuilder.add(ATT_DESC,        String.class, 0, 1, true, null);
        featureTypeBuilder.add(ATT_NAME,        String.class, 1, 1, false, null);
        featureTypeBuilder.add(kwList, ATT_KEYWORDS,    null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_LOCATION,    Point.class, 1, 1, false, null);
        featureTypeBuilder.add(ATT_PHENOMENONS, List.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_SMLTYPE,     String.class, 1, 1, true, null);
        featureTypeBuilder.add(ATT_SMLREF,      String.class, 1, 1, true, null);
        featureTypeBuilder.add(inList, ATT_INPUTS,      null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(outList, ATT_OUTPUTS,     null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.setDefaultGeometry(ATT_LOCATION);
        types.put(SML_TN_COMPONENT, featureTypeBuilder.buildFeatureType());

        // Feature type sml:ProcessChain
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_TN_PROCESSCHAIN);
        featureTypeBuilder.add(ATT_DESC,        String.class, 0, 1, true, null);
        featureTypeBuilder.add(ATT_NAME,        String.class, 1, 1, false, null);
        featureTypeBuilder.add(kwList, ATT_KEYWORDS,    null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_LOCATION,    Point.class, 1, 1, false, null);
        featureTypeBuilder.add(ATT_PHENOMENONS, List.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_SMLTYPE,     String.class, 1, 1, true, null);
        featureTypeBuilder.add(ATT_SMLREF,      String.class, 1, 1, true, null);
        featureTypeBuilder.add(inList, ATT_INPUTS,      null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(outList, ATT_OUTPUTS,     null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_PRODUCER,    Map.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_COMPONENTS,  Map.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.setDefaultGeometry(ATT_LOCATION);
        types.put(SML_TN_PROCESSCHAIN, featureTypeBuilder.buildFeatureType());

        // Feature type sml:ProcessModel
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_TN_PROCESSMODEL);
        featureTypeBuilder.add(ATT_DESC,        String.class, 0, 1, true, null);
        featureTypeBuilder.add(ATT_NAME,        String.class, 1, 1, false, null);
        featureTypeBuilder.add(kwList, ATT_KEYWORDS,    null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_LOCATION,    Point.class, 1, 1, false, null);
        featureTypeBuilder.add(ATT_PHENOMENONS, List.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_SMLTYPE,     String.class, 1, 1, true, null);
        featureTypeBuilder.add(ATT_SMLREF,      String.class, 1, 1, true, null);
        featureTypeBuilder.add(inList, ATT_INPUTS,      null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(outList, ATT_OUTPUTS,     null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_METHOD,      String.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.setDefaultGeometry(ATT_LOCATION);
        types.put(SML_TN_PROCESSMODEL, featureTypeBuilder.buildFeatureType());

        // Feature type sml:DataSourceType
        featureTypeBuilder.reset();
        featureTypeBuilder.setName(SML_TN_DATASOURCETYPE);
        featureTypeBuilder.add(ATT_DESC,        String.class, 0, 1, true, null);
        featureTypeBuilder.add(ATT_NAME,        String.class, 1, 1, false, null);
        featureTypeBuilder.add(kwList, ATT_KEYWORDS,    null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_LOCATION,    Point.class, 1, 1, false, null);
        featureTypeBuilder.add(ATT_PHENOMENONS, List.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_SMLTYPE,     String.class, 1, 1, true, null);
        featureTypeBuilder.add(ATT_SMLREF,      String.class, 1, 1, true, null);
        featureTypeBuilder.add(inList, ATT_INPUTS,      null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(outList, ATT_OUTPUTS,     null, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.add(ATT_CHARACTERISTICS,Map.class, 0, Integer.MAX_VALUE, true, null);
        featureTypeBuilder.setDefaultGeometry(ATT_LOCATION);
        types.put(SML_TN_DATASOURCETYPE, featureTypeBuilder.buildFeatureType());
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public FeatureReader getFeatureReader(final Query query) throws DataStoreException {
        final FeatureType ft = getFeatureType(query.getTypeName()); //raise an error if type does not exist.

        try {
            final FeatureReader fr = new SMLFeatureReader(ft);
            return handleRemaining(fr, query);
        } catch (SQLException ex) {
            throw new DataStoreException(ex);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void close() throws DataStoreException {
        super.close();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Set<Name> getNames() throws DataStoreException {
        return types.keySet();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public FeatureType getFeatureType(final Name typeName) throws DataStoreException {
        typeCheck(typeName);
        return types.get(typeName);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public QueryCapabilities getQueryCapabilities() {
        return capabilities;
    }

    ////////////////////////////////////////////////////////////////////////////
    // No supported stuffs /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    /**
     * {@inheritDoc }
     */
    @Override
    public void createFeatureType(final Name typeName, final FeatureType featureType) throws DataStoreException {
        throw new DataStoreException("Not Supported.");
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void updateFeatureType(final Name typeName, final FeatureType featureType) throws DataStoreException {
        throw new DataStoreException("Not Supported.");
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void deleteFeatureType(final Name typeName) throws DataStoreException {
        throw new DataStoreException("Not Supported.");
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public FeatureWriter getFeatureWriter(final Name typeName, final Filter filter, final Hints hints) throws DataStoreException {
        throw new DataStoreException("Not supported.");
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<FeatureId> addFeatures(final Name groupName, final Collection<? extends Feature> newFeatures,
            final Hints hints) throws DataStoreException {
        throw new DataStoreException("Not supported.");
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void updateFeatures(final Name groupName, final Filter filter, final Map<? extends PropertyDescriptor, ? extends Object> values) throws DataStoreException {
        throw new DataStoreException("Not supported.");
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void removeFeatures(final Name groupName, final Filter filter) throws DataStoreException {
        throw new DataStoreException("Not supported.");
    }


    ////////////////////////////////////////////////////////////////////////////
    // Feature Reader //////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    private class SMLFeatureReader implements FeatureReader{

        private final FeatureType type;
        private Feature current = null;

        private final Connection cnx = getConnection();
        private final PreparedStatement stmtAllFormId;
        private final PreparedStatement stmtTextValue;
        private final PreparedStatement stmtSMLType;
        private final PreparedStatement stmtTextValue2;
        private final PreparedStatement stmtContactRole;
        private final PreparedStatement stmtContactName;
        private final ResultSet result;

        public SMLFeatureReader(final FeatureType type) throws SQLException{
            this.type = type;
            final PreparedStatement st = cnx.prepareStatement(SQL_MDW_VERSION);
            final ResultSet rs         = st.executeQuery();
            final PreparedStatement identifierStmt;
            if (rs.next()) {
                final String version = rs.getString(1);
                if (version != null && version.startsWith("2.0")) {
                    identifierStmt = cnx.prepareStatement(SQL_ALL_FORM_ID);
                } else if (version != null && (version.startsWith("2.1") || version.startsWith("2.2") || version.startsWith("2.3") || version.startsWith("2.4"))) {
                    identifierStmt = cnx.prepareStatement(SQL_ALL_FORM_ID_21);
                } else {
                    throw new IllegalArgumentException("unexpected database mdw version");
                }
            } else {
                 identifierStmt = cnx.prepareStatement(SQL_ALL_FORM_ID);
            }
            stmtAllFormId = identifierStmt;
            stmtTextValue = cnx.prepareStatement(SQL_TEXT_VALUE);
            stmtSMLType = cnx.prepareStatement(SQL_SML_TYPE);
            stmtTextValue2 = cnx.prepareStatement(SQL_TEXT_VALUE_2);
            stmtContactRole = cnx.prepareStatement(SQL_CONTACT_ROLE);
            stmtContactName = cnx.prepareStatement(SQL_CONTACT_NAME);
            result = stmtAllFormId.executeQuery();
        }

        @Override
        public FeatureType getFeatureType() {
            return type;
        }

        @Override
        public Feature next() throws FeatureStoreRuntimeException {
            try {
                read();
            } catch (IOException ex) {
                throw new FeatureStoreRuntimeException(ex);
            } catch (SQLException ex) {
                throw new FeatureStoreRuntimeException(ex);
            }
            final Feature f = current;
            if(f == null){
                throw new NoSuchElementException("No more feature.");
            }
            current = null;
            return f;
        }

        @Override
        public boolean hasNext() throws FeatureStoreRuntimeException {
            try {
                read();
            } catch (IOException ex) {
                throw new FeatureStoreRuntimeException(ex);
            } catch (SQLException ex) {
                throw new FeatureStoreRuntimeException(ex);
            }
            return current != null;
        }

        @Override
        public void close() {
            try {
                result.close();
                stmtAllFormId.close();
                stmtTextValue.close();
                stmtSMLType.close();
                stmtTextValue2.close();
                stmtContactRole.close();
                stmtContactName.close();
                cnx.close();
            } catch (SQLException ex) {
                getLogger().info("SQL Exception while closing SML datastore");
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private void read() throws IOException, SQLException{
            if(current != null) return;

            //find a feature
            int formID = -1;
            while(result.next() && current == null){
                formID = result.getInt(1);
                current = readFeature(formID, type.getName());
            }

        }

        private Feature readFeature(final int formID, final Name typeName) throws SQLException{
            final Collection<Property> props = new ArrayList<Property>();

            /*
             * we filter on the type
             */
            stmtSMLType.setInt(1, formID);
            ResultSet rset = stmtSMLType.executeQuery();
            String tn = null;
            if (rset.next()) {
                tn = rset.getString(1);
                props.add(FF.createAttribute(tn, (AttributeDescriptor) type.getDescriptor(ATT_SMLTYPE), null));
            }
            rset.close();
            if (!tn.equals(typeName.getLocalPart())) {
                return null;
            }

            /*
             * GML : DESCRIPTION
             */
            stmtTextValue.setString(1, pathDescription);
            stmtTextValue.setInt(2, formID);
            rset = stmtTextValue.executeQuery();
            if (rset.next()) {
                props.add(FF.createAttribute(rset.getString(1), (AttributeDescriptor) type.getDescriptor(ATT_DESC), null));
            }
            rset.close();

            /*
             * GML : NAME
             */
            stmtTextValue.setString(1, pathName);
            stmtTextValue.setInt(2, formID);
            rset = stmtTextValue.executeQuery();
            if (rset.next()) {
                props.add(FF.createAttribute(rset.getString(1), (AttributeDescriptor) type.getDescriptor(ATT_NAME), null));
            }
            rset.close();

            /*
             * SML : KEYWORDS (multiple)
             */
            stmtTextValue.setString(1, pathKeywords);
            stmtTextValue.setInt(2, formID);
            rset = stmtTextValue.executeQuery();
            final List<String> keywords = new ArrayList<String>();
            while (rset.next()) {
                keywords.add(rset.getString(1));
            }
            rset.close();
            final ComplexAttribute keywordList = (ComplexAttribute) FeatureUtilities.defaultProperty(type.getDescriptor(ATT_KEYWORDS));
            final ComplexType ktype = keywordList.getType();
            final Collection<Property> kprops = new ArrayList<Property>();
            kprops.add(FF.createAttribute(keywords, (AttributeDescriptor) ktype.getDescriptor(ATT_KEYWORD), null));
            //TODO codespace

            props.add(FF.createComplexAttribute(kprops, (AttributeDescriptor) type.getDescriptor(ATT_KEYWORDS), null));


            /*
             *  SML : REF
             */
            stmtTextValue.setString(1, pathSmlRef);
            stmtTextValue.setInt(2, formID);
            rset = stmtTextValue.executeQuery();
            if (rset.next()) {
                props.add(FF.createAttribute(rset.getString(1), (AttributeDescriptor) type.getDescriptor(ATT_SMLREF), null));
            }
            rset.close();


            /*
             * SML : INPUTS (multiple map)
             */
            stmtTextValue.setString(1, pathInputsDef);
            stmtTextValue.setInt(2, formID);
            rset = stmtTextValue.executeQuery();
            stmtTextValue2.setString(1, pathInputsNam);
            stmtTextValue2.setInt(2, formID);
            ResultSet result3 = stmtTextValue2.executeQuery();

            final ComplexAttribute inputList = (ComplexAttribute) FeatureUtilities.defaultProperty(type.getDescriptor(ATT_INPUTS));
            final ComplexType istype = inputList.getType();
            final Collection<Property> isprops = new ArrayList<Property>();

            final ComplexAttribute input = (ComplexAttribute) FeatureUtilities.defaultProperty(istype.getDescriptor(ATT_INPUT));
            final ComplexType itype = input.getType();

            while (rset.next() && result3.next()) {
                final Collection<Property> iprops = new ArrayList<Property>();
                iprops.add(FF.createAttribute(result3.getString(1), (AttributeDescriptor) itype.getDescriptor(ATT_NAME), null));
                iprops.add(FF.createAttribute(rset.getString(1),    (AttributeDescriptor) itype.getDescriptor(ATT_DESC), null));
                isprops.add(FF.createComplexAttribute(iprops, (AttributeDescriptor) istype.getDescriptor(ATT_INPUT), null));
            }
            rset.close();
            result3.close();

            props.add(FF.createComplexAttribute(isprops, (AttributeDescriptor) type.getDescriptor(ATT_INPUTS), null));

            /*
             * SML : OUTPUTS (multiple map)
             */
            stmtTextValue.setString(1, pathOutputsDef);
            stmtTextValue.setInt(2, formID);
            rset = stmtTextValue.executeQuery();
            stmtTextValue2.setString(1, pathOutputsNam);
            stmtTextValue2.setInt(2, formID);
            result3 = stmtTextValue2.executeQuery();

            final ComplexAttribute outputList = (ComplexAttribute) FeatureUtilities.defaultProperty(type.getDescriptor(ATT_OUTPUTS));
            final ComplexType ostype = outputList.getType();
            final Collection<Property> osprops = new ArrayList<Property>();

            final ComplexAttribute output = (ComplexAttribute) FeatureUtilities.defaultProperty(ostype.getDescriptor(ATT_OUTPUT));
            final ComplexType otype = output.getType();

            while (rset.next() && result3.next()) {
                final Collection<Property> oprops = new ArrayList<Property>();
                oprops.add(FF.createAttribute(result3.getString(1), (AttributeDescriptor) otype.getDescriptor(ATT_NAME), null));
                oprops.add(FF.createAttribute(rset.getString(1),    (AttributeDescriptor) otype.getDescriptor(ATT_DESC), null));
                osprops.add(FF.createComplexAttribute(oprops, (AttributeDescriptor) ostype.getDescriptor(ATT_OUTPUT), null));
            }
            rset.close();
            result3.close();

            props.add(FF.createComplexAttribute(osprops, (AttributeDescriptor) type.getDescriptor(ATT_OUTPUTS), null));

            /*
             * SML : LOCATION (geometric)
             */

            int crsID = -1;
            //read the feature crs
            stmtTextValue.setString(1, pathCRS);
            stmtTextValue.setInt(2, formID);
            final ResultSet resultCRS = stmtTextValue.executeQuery();
            if (resultCRS.next()) {
                String srsName = resultCRS.getString(1);

                if (srsName.startsWith("urn:ogc:crs:")) {
                    srsName = "urn:ogc:def:crs:" + srsName.substring(12);
                }
                try {
                    final CoordinateReferenceSystem crs = CRS.decode(srsName);
                    crsID = SRIDGenerator.toSRID(crs, SRIDGenerator.Version.V1);
                } catch (NoSuchAuthorityCodeException ex) {
                    throw new SQLException(ex);
                } catch (FactoryException ex) {
                    throw new SQLException(ex);
                }
            }

            stmtTextValue.setString(1, pathLocation);
            stmtTextValue.setInt(2, formID);
            rset = stmtTextValue.executeQuery();
            if (rset.next()) {
                final String location = rset.getString(1);
                try {
                    final int pos = location.indexOf(' ');
                    final double x = Double.parseDouble(location.substring(0, pos));
                    final double y = Double.parseDouble(location.substring(pos+1));
                    final Coordinate coord = new Coordinate(x, y);
                    final Point pt = GF.createPoint(coord);
                    pt.setSRID(crsID);
                    props.add(FF.createAttribute(pt,(AttributeDescriptor)type.getDescriptor(ATT_LOCATION), null));
                } catch (NumberFormatException ex) {
                    getLogger().log(Level.WARNING, "unable to extract the point coordinate from the text value:{0}", location);
                }
            }
            rset.close();

            if (typeName.equals(SML_TN_COMPONENT)) {

                /*
                 * SML : PHENOMENONS
                 */
                stmtTextValue.setString(1, pathPhenomenonsCompo);
                stmtTextValue.setInt(2, formID);
                rset = stmtTextValue.executeQuery();
                final List<String> phenomenons = new ArrayList<String>();
                if (rset.next()) {
                    phenomenons.add(rset.getString(1));
                }
                rset.close();
                props.add(FF.createAttribute(phenomenons, (AttributeDescriptor) type.getDescriptor(ATT_PHENOMENONS), null));

            } else if (typeName.equals(SML_TN_SYSTEM) || typeName.equals(SML_TN_PROCESSCHAIN)) {

                /*
                 * SML : PHENOMENONS (multiple)
                 */
                stmtTextValue.setString(1, pathPhenomenonsSystem);
                stmtTextValue.setInt(2, formID);
                rset = stmtTextValue.executeQuery();
                List<String> phenomenons = new ArrayList<String>();
                while (rset.next()) {
                    phenomenons.add(rset.getString(1));
                }
                rset.close();
                props.add(FF.createAttribute(phenomenons, (AttributeDescriptor) type.getDescriptor(ATT_PHENOMENONS), null));


                /*
                 * TODO SML : PRODUCER
                 */
                 final Map<String, String> producers = new HashMap<String, String>();
                 stmtContactRole.setInt(1, formID);
                 final List<String> contacts = new ArrayList<String>();
                 rset = stmtContactRole.executeQuery();
                 while (rset.next()) {
                     final String completePath = rset.getString(1);
                     contacts.add(completePath.substring(0, completePath.lastIndexOf(':')));
                 }
                 rset.close();
                 for (String contactPath : contacts) {
                     stmtContactName.setString(1, contactPath + ":organizationName.1");
                     stmtContactName.setInt(2, formID);
                     rset = stmtContactName.executeQuery();
                     String orgName = null;
                     if (rset.next()) {
                         orgName = rset.getString(1);
                     }
                     stmtContactName.setString(1, contactPath + ":individualName.1");
                     stmtContactName.setInt(2, formID);
                     rset = stmtContactName.executeQuery();
                     String indName = null;
                     if (rset.next()) {
                         indName = rset.getString(1);
                     }
                     producers.put(orgName, indName);
                 }
                 rset.close();
                 props.add(FF.createAttribute(producers, (AttributeDescriptor) type.getDescriptor(ATT_PRODUCER), null));


                /*
                 * SML : COMPONENT (multiple map)
                 */
                stmtTextValue.setString(1, pathComponentsRef);
                stmtTextValue.setInt(2, formID);
                rset = stmtTextValue.executeQuery();
                stmtTextValue2.setString(1, pathComponentsNam);
                stmtTextValue2.setInt(2, formID);
                result3 = stmtTextValue2.executeQuery();
                Map<String, String> components = new HashMap<String, String>();
                while (rset.next() && result3.next()) {
                    components.put(result3.getString(1), rset.getString(1));
                }
                rset.close();
                result3.close();
                if (components.isEmpty()) {
                    components = null;
                }
                props.add(FF.createAttribute(components, (AttributeDescriptor) type.getDescriptor(ATT_COMPONENTS), null));

            } else if (typeName.equals(SML_TN_PROCESSMODEL)) {
                // TODO method
            } else if (typeName.equals(SML_TN_DATASOURCETYPE)) {

                /*
                 * SML : CHARACTERISTIC (multiple map)
                 */
                stmtTextValue.setString(1, pathCharacteristicsVal);
                stmtTextValue.setInt(2, formID);
                rset = stmtTextValue.executeQuery();
                stmtTextValue2.setString(1, pathCharacteristicsNam);
                stmtTextValue2.setInt(2, formID);
                result3 = stmtTextValue2.executeQuery();
                final Map<String, String> characteristics = new HashMap<String, String>();
                while (rset.next() && result3.next()) {
                    characteristics.put(result3.getString(1), rset.getString(1));
                }
                rset.close();
                result3.close();
                props.add(FF.createAttribute(characteristics, (AttributeDescriptor) type.getDescriptor(ATT_CHARACTERISTICS), null));
            }

            return FF.createFeature(props, type, ""+formID);
        }

    }


	@Override
	public void refreshMetaModel() {
		return;

	}

}
