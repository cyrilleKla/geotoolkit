/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2009-2014, Geomatys
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
package org.geotoolkit.feature;

import com.vividsolutions.jts.geom.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.rmi.server.UID;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.geotoolkit.parameter.Parameters;
import org.apache.sis.util.ArgumentChecks;
import org.apache.sis.util.ObjectConverters;
import org.apache.sis.util.logging.Logging;
import org.opengis.coverage.grid.GridCoverage;
import org.opengis.filter.identity.Identifier;
import org.opengis.parameter.*;
import org.apache.sis.util.UnconvertibleObjectException;
import org.geotoolkit.filter.identity.DefaultFeatureId;
import org.opengis.feature.Attribute;
import org.opengis.feature.AttributeType;
import org.opengis.feature.Feature;
import org.opengis.feature.FeatureType;
import org.opengis.feature.PropertyType;

/**
 *
 * @version $Id$
 *
 * @author Cédric Briançon (Geomatys)
 * @author Johann Sorel (Geomatys)
 * @module pending
 */
public final class FeatureUtilities {
    
    /**
     * Get the default geometry attribute name, or the first geometric attribute
     * if there is no defined geometry attribute. null otherwise.
     * 
     * @param feature not null
     * @return Attribute can be null if there is no geometric attribute
     */
    public static Attribute getDefaultGeometryProperty(Feature feature){
        
        final AttributeType geomAttType = FeatureTypeUtilities.getDefaultGeometryProperty(feature.getType());
                
        if(geomAttType==null){
            //no default geometry attribute
            return null;
        }
        
        return (Attribute)feature.getProperty(geomAttType.getName().toString());
    }
    
    /**
     * Get feature identifier.
     * 
     * @param feature not null
     * @return Object identifier
     */
    public static Identifier getId(Feature feature){
        final Object obj = feature.getPropertyValue(FeatureTypeUtilities.ATT_ID);
        if(obj instanceof Identifier){
            return (Identifier) obj;
        }else{
            return new DefaultFeatureId(String.valueOf(obj));
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Key used if properties to store a version manager for the object.
     */
    public static final String ATT_VERSIONING = "versioning";

    private static final Logger LOGGER = Logging.getLogger(FeatureUtilities.class);

    private static final FeatureFactory FF = FeatureFactory.LENIENT;

    private static final GeometryFactory GF = new GeometryFactory();

    private FeatureUtilities(){}

    /**
     * Returns a non-null default value for the class that is passed in.  This is a helper class an can't create a
     * default class for any type but it does support:
     * <ul>
     * <li>String</li>
     * <li>Object - will return empty string</li>
     * <li>Number</li>
     * <li>Character</li>
     * <li>JTS Geometries</li>
     * </ul>
     *
     *
     * @param type
     * @return a default value for the given class.
     */
    public static Object defaultValue(final Class type) {
        if (type == String.class || type == Object.class) {
            return "";
        }
        if (type == Integer.class) {
            return Integer.valueOf(0);
        }
        if (type == Double.class) {
            return Double.valueOf(0);
        }
        if (type == Long.class) {
            return Long.valueOf(0);
        }
        if (type == Short.class) {
            return Short.valueOf((short) 0);
        }
        if (type == Float.class) {
            return Float.valueOf(0.0f);
        }
        if (type == BigDecimal.class) {
            return BigDecimal.valueOf(0);
        }
        if (type == BigInteger.class) {
            return BigInteger.valueOf(0);
        }
        if (type == Character.class) {
            return Character.valueOf(' ');
        }
        if (type == Boolean.class) {
            return Boolean.FALSE;
        }
        if (type == Timestamp.class) {
            return new Timestamp(System.currentTimeMillis());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(System.currentTimeMillis());
        }
        if (type == java.sql.Time.class) {
            return new java.sql.Time(System.currentTimeMillis());
        }
        if (type == java.util.Date.class) {
            return new java.util.Date();
        }

        final Coordinate crd = new Coordinate(0, 0);

        if (type == Point.class) {
            final Point pt = GF.createPoint(crd);
            return pt;
        }
        if (type == MultiPoint.class) {
            final Point pt = GF.createPoint(crd);
            return GF.createMultiPoint(new Point[]{pt});
        }
        if (type == LineString.class) {
            return GF.createLineString(new Coordinate[]{crd, crd, crd, crd});
        }
        final LinearRing linearRing = GF.createLinearRing(new Coordinate[]{crd, crd, crd, crd});
        if (type == LinearRing.class) {
            return linearRing;
        }
        if (type == MultiLineString.class) {
            return GF.createMultiLineString(new LineString[]{linearRing});
        }
        final Polygon polygon = GF.createPolygon(linearRing, new LinearRing[0]);
        if (type == Polygon.class) {
            return polygon;
        }
        if (type == MultiPolygon.class) {
            return GF.createMultiPolygon(new Polygon[]{polygon});
        }

        throw new IllegalArgumentException(type + " is not supported by this method");
    }

    /**
     * Method for creating feature id's when none is specified.
     */
    public static String createDefaultFeatureId() {
        // According to GML and XML schema standards, FID is a XML ID
        // (http://www.w3.org/TR/xmlschema-2/#ID), whose acceptable values are those that match an
        // NCNAME production (http://www.w3.org/TR/1999/REC-xml-names-19990114/#NT-NCName):
        // NCName ::= (Letter | '_') (NCNameChar)* /* An XML Name, minus the ":" */
        // NCNameChar ::= Letter | Digit | '.' | '-' | '_' | CombiningChar | Extender
        // We have to fix the generated UID replacing all non word chars with an _ (it seems
        // they area all ":")
        //return "fid-" + NON_WORD_PATTERN.matcher(new UID().toString()).replaceAll("_");
        // optimization, since the UID toString uses only ":" and converts long and integers
        // to strings for the rest, so the only non word character is really ":"
        return "fid-" + new UID().toString().replace(':', '_');
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // COPY OPERATIONS /////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public static <T extends Property> T copy(final T property){
        return copy(property,false,null);
    }

    public static <T extends Property> T copy(final T property, final String newId){
        return copy(property,false,newId);
    }

    /**
     * Copy values from one property to another.
     * Based on cardinalities, only value or the complete property might be copied.
     * Types migth not be exactly the same, this is a best effort copy.
     *
     * @param source : not null
     * @param target : not null
     * @param <T>
     */
    public static void copy(final Property source, final Property target, final boolean deep){

        if(source instanceof ComplexAttribute && target instanceof ComplexAttribute){
            final ComplexAttribute sourceComplex = (ComplexAttribute)source;
            final ComplexAttribute targetComplex = (ComplexAttribute)target;
            final ComplexType targetType = targetComplex.getType();
            for(final Property p : sourceComplex.getProperties()){
                //find or build the property to copy to
                final PropertyDescriptor sourceDesc = p.getDescriptor();
                final Name name = sourceDesc.getName();
                Property targetCopy = null;
                if(sourceDesc.getMaxOccurs() == 1){
                    //single property, try to reuse existing target property
                    final PropertyDescriptor targetDesc = targetType.getDescriptor(name);
                    if(targetDesc != null){
                        targetCopy = targetComplex.getProperty(name);
                        if(targetCopy == null){
                            //create it
                            targetCopy = FeatureUtilities.defaultProperty(targetDesc);
                            targetComplex.getProperties().add(targetCopy);
                        }
                    }else{
                        //no match in target type, skip this property
                        continue;
                    }
                }else{
                    //create
                    final PropertyDescriptor targetDesc = targetType.getDescriptor(name);
                    if(targetDesc != null){
                        //create it
                        targetCopy = FeatureUtilities.defaultProperty(targetDesc);
                        targetComplex.getProperties().add(targetCopy);
                    }else{
                        //no match in target type, skip this property
                        continue;
                    }
                }

                copy(p,targetCopy,deep);
            }
        }else if(source instanceof Attribute && target instanceof Attribute){
            Object value = source.getValue();
            if(deep) value = duplicate(value);
            target.setValue(value);
        }

    }

    public static <T extends Property> T deepCopy(final T property){
        return copy(property,true,null);
    }

    public static <T extends Property> T deepCopy(final T property, String newId){
        return copy(property,true,null);
    }

    /**
     *
     * @param property : property to copy
     * @param deep : duplicate property value.
     * @param newId : replace current property id if newId is not null
     * @return copy of the property
     */
    public static <T extends Property> T copy(final T property, final boolean deep, final String newId){

        final Property copy;
        if(property instanceof ComplexAttribute){
            final ComplexAttribute ga = (ComplexAttribute) property;
            final String strId;
            if(newId == null){
                final Identifier id = ga.getIdentifier();
                strId = (id == null) ? null : id.getID().toString();
            }else{
                strId = newId;
            }


            final Collection<Property> properties = ga.getProperties();
            final Collection<Property> copies = new ArrayList<Property>();
            for(final Property prop : properties){
                copies.add(copy(prop,deep,null));
            }

            final AttributeDescriptor desc = ga.getDescriptor();
            if(desc != null){
                copy = FF.createComplexAttribute(copies, desc, strId);
            }else{
                //no descriptor, use the type
                copy = FF.createComplexAttribute(copies, ga.getType(), strId);
            }

        }else if(property instanceof Attribute){
            final Attribute ga = (Attribute) property;
            final String strId;
            if(newId == null){
                final Identifier id = ga.getIdentifier();
                strId = (id == null) ? null : id.getID().toString();
            }else{
                strId = newId;
            }

            final Object value = (deep) ? duplicate(property.getValue()) : property.getValue();
            copy = FF.createAttribute(value, ga.getDescriptor(),strId);
        }else{
            throw new IllegalArgumentException("Unexpected type : "+ property.getClass());
        }

        //copy user data
        copy.getUserData().putAll(property.getUserData());
        return (T)copy;
    }

    public static Object duplicate(final Object src) {

        if (src == null) {
            return null;
        }

        if(src instanceof Property){
            return copy((Property)src);
        }

        // The following are things I expect
        // Features will contain.
        if (src instanceof String || src instanceof Boolean || src instanceof Character || src instanceof Number) {
            return src;
        }

        if (src instanceof Date) {
            return new Date(((Date) src).getTime());
        }

        if (src instanceof URL || src instanceof URI) {
            return src; //immutable
        }

        if (src instanceof Object[]) {
            final Object[] array = (Object[]) src;
            final Object[] copy = new Object[array.length];

            for (int i = 0; i < array.length; i++) {
                copy[i] = duplicate(array[i]);
            }

            return copy;
        }

        if (src instanceof Geometry) {
            final Geometry geometry = (Geometry) src;
            return geometry.clone();
        }

        // We are now into diminishing returns
        // I don't expect Features to contain these often
        // (eveything is still nice and recursive)
        final Class type = src.getClass();

        if (type.isArray() && type.getComponentType().isPrimitive()) {
            final int length = Array.getLength(src);
            final Object copy = Array.newInstance(type.getComponentType(), length);
            System.arraycopy(src, 0, copy, 0, length);

            return copy;
        }

        if (type.isArray()) {
            final int length = Array.getLength(src);
            final Object copy = Array.newInstance(type.getComponentType(), length);

            for (int i = 0; i < length; i++) {
                Array.set(copy, i, duplicate(Array.get(src, i)));
            }

            return copy;
        }

        if (src instanceof List) {
            final List list = (List) src;
            final List copy = new ArrayList(list.size());

            for (final Iterator i = list.iterator(); i.hasNext();) {
                copy.add(duplicate(i.next()));
            }

            return Collections.unmodifiableList(copy);
        }

        if (src instanceof Map) {
            final Map map = (Map) src;
            final Map copy = new HashMap(map.size());

            for (final Iterator i = map.entrySet().iterator(); i.hasNext();) {
                final Map.Entry entry = (Map.Entry) i.next();
                copy.put(entry.getKey(), duplicate(entry.getValue()));
            }

            return Collections.unmodifiableMap(copy);
        }

        if (src instanceof GridCoverage) {
            return src; // inmutable
        }

        if(src instanceof org.geotoolkit.util.Cloneable){
            return ((org.geotoolkit.util.Cloneable)src).clone();
        }
        
        //can't find a solution to duplicate this object
        LOGGER.log(Level.FINEST, "Do not know how to deep copy {0}", type.getName());
        return src;
    }

    ////////////////////////////////////////////////////////////////////////////
    // TEMPLATE OPERATIONS /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public static Property defaultProperty(final PropertyDescriptor desc){
        return defaultProperty(desc, null);
    }

    public static Property defaultProperty(final PropertyDescriptor desc, final String id){
        final PropertyType type = desc.getType();

        if(type instanceof ComplexType){
            final AttributeDescriptor attDesc = (AttributeDescriptor) desc;
            final ComplexType ct = (ComplexType) type;

            final Collection<Property> props = new ArrayList<Property>();
            for(final PropertyDescriptor subDesc : ct.getDescriptors()){
                for(int i=0,n=subDesc.getMinOccurs();i<n;i++){
                    final Property prop = defaultProperty(subDesc);
                    if(prop != null){
                        props.add(prop);
                    }
                }
            }
            return FF.createComplexAttribute(props, attDesc, id);

        }else if(type instanceof AttributeType){
            final AttributeDescriptor attDesc = (AttributeDescriptor) desc;
            final Object value = defaultPropertyValue(desc);
            return FF.createAttribute(value, attDesc, id);

        }else if(type instanceof AssociationType){
            //can not create a default value for this
            return null;
        }

        throw new IllegalArgumentException("Unhandled type : " + type);
    }

    public static ComplexAttribute defaultProperty(final ComplexType type){
        return defaultProperty(type, "");
    }

    public static ComplexAttribute defaultProperty(final ComplexType type, final String id){

        ArgumentChecks.ensureNonNull("type", type);
        final Collection<Property> props = new ArrayList<Property>();
        for(final PropertyDescriptor subDesc : type.getDescriptors()){
            for(int i=0,n=subDesc.getMinOccurs();i<n;i++){
                final Property prop = defaultProperty(subDesc);
                if(prop != null){
                    props.add(prop);
                }
            }
        }
        return FF.createComplexAttribute(props, type, id);
    }

    public static SimpleFeature defaultFeature(final SimpleFeatureType type, final String id){
        return (SimpleFeature)defaultProperty(type, id);
    }

    public static Feature defaultFeature(final FeatureType type, final String id){
        return (Feature)defaultProperty(type, id);
    }

    /**
     * Provides a defautlValue for attributeType.
     *
     * <p>
     * Will return null if attributeType isNillable(), or attempt to use
     * Reflection, or attributeType.parse( null )
     * </p>
     *
     * @param attributeType
     * @return null for nillable attributeType, attempt at reflection
     * @throws IllegalAttributeException If value cannot be constructed for
     *         attribtueType
     */
    public static Object defaultPropertyValue(final PropertyDescriptor attributeType)
            throws IllegalAttributeException {

        if(attributeType instanceof AttributeDescriptor){
            final Object value = ((AttributeDescriptor)attributeType).getDefaultValue();

            if (value == null && !attributeType.isNillable()) {
                return null; // sometimes there is no valid default value :-(
                // throw new IllegalAttributeException("Got null default value for non-null type.");
            }
            return value;
        }else{
            return null;
        }
    }

    /**
     * Reset the property values.
     * @param candidate
     */
    public static void resetProperty(final Property candidate){
        final PropertyType type = candidate.getType();
        final PropertyDescriptor desc = candidate.getDescriptor();

        if(type instanceof ComplexType){
            final ComplexType ct = (ComplexType) type;
            final ComplexAttribute ca = (ComplexAttribute) candidate;
            final Collection<Property> props = ca.getProperties();
            props.clear();
            for(final PropertyDescriptor subDesc : ct.getDescriptors()){
                for(int i=0,n=subDesc.getMinOccurs();i<n;i++){
                    final Property prop = defaultProperty(subDesc);
                    if(prop != null){
                        props.add(prop);
                    }
                }
            }

        }else if(desc instanceof AttributeDescriptor){
            candidate.setValue( ((AttributeDescriptor)desc).getDefaultValue() );
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    // ENCAPSULATION OPERATIONS ////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Decorate a given property with a descriptor.
     * This can be used by features who encapsulate other features as properties.
     *
     * @param property
     * @param desc
     * @return Property
     */
    public static Property wrapProperty(final Property property, final PropertyDescriptor desc){
        if(property instanceof SimpleFeature){
            return new WrapProperty.SimpleFeature((SimpleFeature)property, (AttributeDescriptor)desc);
        }else if(property instanceof Feature){
            return new WrapProperty.Feature((Feature)property, (AttributeDescriptor)desc);
        }else if(property instanceof ComplexAttribute){
            return new WrapProperty.ComplexAttribute((ComplexAttribute)property, (AttributeDescriptor)desc);
        }else if(property instanceof GeometryAttribute){
            return new WrapProperty.GeometryAttribute((GeometryAttribute)property, (GeometryDescriptor)desc);
        }else if(property instanceof Attribute){
            return new WrapProperty.Attribute((Attribute)property, (AttributeDescriptor)desc);
        }else if(property instanceof Association){
            return new WrapProperty.Association((Association)property, (AssociationDescriptor)desc);
        }else{
            return new WrapProperty.Property(property, desc);
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    // PARAMETERS API MAPPING OPERATIONS ///////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Convert a ComplexAttribute in a parameter.
     *
     * @param source : attributeto convert
     * @param desc : parameter descriptor
     * @return ParameterValueGroup
     */
    public static ParameterValueGroup toParameter(final ComplexAttribute source, final ParameterDescriptorGroup desc) {

        ArgumentChecks.ensureNonNull("source", source);
        ArgumentChecks.ensureNonNull("desc", desc);
        final ParameterValueGroup target = desc.createValue();
        fill(source,target);
        return target;
    }

    /**
     * Convert a ParameterValueGroup in a feature.
     *
     * @param source : parameter to convert
     * @return ComplexAttribute
     */
    public static ComplexAttribute toFeature(final ParameterValueGroup source) {
        ArgumentChecks.ensureNonNull("source", source);
        return toFeature(source,null);
    }

    /**
     * Convert a ParameterValueGroup in a feature.
     *
     * @param source : parameter to convert
     * @param target : wanted type, may contain more or less parameters.
     * @return ComplexAttribute
     */
    public static ComplexAttribute toFeature(final ParameterValueGroup source, ComplexType targetType) {

        ArgumentChecks.ensureNonNull("source", source);
        if(targetType == null){
            targetType = (ComplexType)FeatureTypeUtilities.toPropertyType(source.getDescriptor());
        }
        final ComplexAttribute target = FeatureUtilities.defaultProperty(targetType);
        fill(source,target);
        return target;
    }


    /**
     * Convert a ComplexAttribute in a Map of values.
     *
     * @param source : property to convert
     * @return Map
     */
    public static Map<String,Object> toMap(final ComplexAttribute att) {

        ArgumentChecks.ensureNonNull("att", att);
        final Map<String,Object> map = new HashMap<String, Object>();
        for(final Property prop : att.getProperties()){
            map.put(prop.getName().getLocalPart(), prop.getValue());
        }
        return map;
    }

    /**
     * Convert a ParameterValueGroup in a Map of values.
     *
     * @param source : parameter to convert
     * @return Map
     *
     * @deprecated Use method {@link Parameters#toMap(org.opengis.parameter.ParameterValueGroup)} instead.
     */
    public static Map<String,Object> toMap(final ParameterValueGroup source) {
        ArgumentChecks.ensureNonNull("source", source);
        return toMap(toFeature(source));
    }

    /**
     * Transform a Map in a ParameterValueGroup.
     * A default parameter is first created and all key found in the map
     * that match the descriptor will be completed.
     *
     * @param params
     * @param desc
     * @return
     *
     * @deprecated Use method {@link Parameters#toParameter(java.util.Map, org.opengis.parameter.ParameterDescriptorGroup)} instead.
     */
    public static ParameterValueGroup toParameter(final Map<String, ?> params, final ParameterDescriptorGroup desc) {
        ArgumentChecks.ensureNonNull("params", params);
        ArgumentChecks.ensureNonNull("desc", desc);
        return toParameter(params, desc, true);
    }

    /**
     * Transform a Map in a ParameterValueGroup.
     * A default parameter is first created and all key found in the map
     * that match the descriptor will be completed.
     *
     * @param params
     * @param desc
     * @param checkMandatory : will return a parameter only if all mandatory values
     *      have been found in the map.
     * @return
     *
     * @deprecated Use method {@link Parameters#toParameter(java.util.Map, org.opengis.parameter.ParameterDescriptorGroup, boolean)} instead.
     */
    public static ParameterValueGroup toParameter(final Map<String, ?> params,
            final ParameterDescriptorGroup desc, final boolean checkMandatory) {

        ArgumentChecks.ensureNonNull("params", params);
        ArgumentChecks.ensureNonNull("desc", desc);
        if(checkMandatory){
            for(GeneralParameterDescriptor de : desc.descriptors()){
                if(de.getMinimumOccurs()>0 && !(params.containsKey(de.getName().getCode()))){
                    //a mandatory parameter is not present
                    return null;
                }
            }
        }

        final ParameterValueGroup parameter = desc.createValue();

        for(final Entry<String, ?> entry : params.entrySet()){

            final GeneralParameterDescriptor subdesc;
            try{
                subdesc = desc.descriptor(entry.getKey());
            }catch(ParameterNotFoundException ex){
                //do nothing, the map may contain other values for other uses
                continue;
            }

            if(!(subdesc instanceof ParameterDescriptor)){
                //we can not recreate value groups
                continue;
            }

            final ParameterDescriptor pd = (ParameterDescriptor) subdesc;

            final ParameterValue param;
            try{
                param = Parameters.getOrCreate(pd,parameter);
            }catch(ParameterNotFoundException ex){
                //do nothing, the map may contain other values for other uses
                continue;
            }

            Object val = entry.getValue();
            try {
                val = ObjectConverters.convert(val, pd.getValueClass());
                param.setValue(val);
            } catch (UnconvertibleObjectException e) {
                Logging.recoverableException(FeatureUtilities.class, "toParameter", e);
                // TODO - do we really want to ignore?
            }
        }

        return parameter;
    }

    /**
     * Build a {@link Property} from a {@link ParameterValue}.
     * @param parameter {@link ParameterValue}
     * @return a {@link Property}
     */
    public static Property toProperty (final ParameterValue parameter) {
        final ParameterDescriptor descriptor = parameter.getDescriptor();
        final Object value = parameter.getValue();

        final AttributeType at = (AttributeType) FeatureTypeUtilities.toPropertyType(descriptor);

        final AttributeDescriptorBuilder adb = new AttributeDescriptorBuilder();
        adb.setType(at);
        adb.setName(descriptor.getName().getCode());
        adb.setMinOccurs(descriptor.getMinimumOccurs());
        adb.setMaxOccurs(descriptor.getMaximumOccurs());
        adb.setDefaultValue(descriptor.getDefaultValue());
        final PropertyDescriptor adesc = adb.buildDescriptor();

        final Property property = defaultProperty(adesc);
        property.setValue(value);
        return property;
    }

    private static void fill(final ParameterValueGroup source, final ComplexAttribute target){

        final ParameterDescriptorGroup paramdesc = source.getDescriptor();

        for(final PropertyDescriptor desc : target.getType().getDescriptors()){

            if(desc.getType() instanceof ComplexType){

                try{
                    final List<ParameterValueGroup> groups = source.groups(desc.getName().getLocalPart());
                    if(groups != null){
                        for(ParameterValueGroup gr : groups){
                            final ComplexAttribute att = (ComplexAttribute) FeatureUtilities.defaultProperty(desc);
                            fill(gr,att);
                            target.getProperties().add(att);
                        }
                    }
                }catch(Exception ex){
                    //parameter might not exist of might be a group
                }

            }else if(desc.getType() instanceof AttributeType){
                final String code = desc.getName().getLocalPart();
                final GeneralParameterValue gpv = searchParameter(source, code);

                if(gpv instanceof ParameterValue){
                    Property prop = target.getProperty(code);
                    if(prop == null){
                        prop = FeatureUtilities.defaultProperty(desc);
                        target.getProperties().add(prop);
                    }
                    prop.setValue(((ParameterValue)gpv).getValue());
                }
            }

        }

    }

    private static void fill(final ComplexAttribute source, final ParameterValueGroup target){

        for(final GeneralParameterDescriptor gpd : target.getDescriptor().descriptors()){

            final Collection<Property> properties = source.getProperties(gpd.getName().getCode());

            if(gpd instanceof ParameterDescriptor){
                final ParameterDescriptor desc = (ParameterDescriptor) gpd;

                for(final Property prop : properties){
                    Parameters.getOrCreate(desc, target).setValue(prop.getValue());
                }
            }else if(gpd instanceof ParameterDescriptorGroup){
                final ParameterDescriptorGroup desc = (ParameterDescriptorGroup) gpd;

                for(final Property prop : properties){
                    ParameterValueGroup subGroup = null;
                    if (desc.getMaximumOccurs() != 1) {
                        subGroup = target.addGroup(desc.getName().getCode());
                    } else {
                        if (desc.getMinimumOccurs() == 1) {
                            subGroup = target.groups(desc.getName().getCode()).get(0);
                        }
                        if( subGroup == null) {
                            subGroup = target.addGroup(desc.getName().getCode());
                        }
                    }
                    fill((ComplexAttribute)prop,subGroup);
                }
            }
        }
    }

    /**
     * Equivalent to Parameters.getOrCreate but doesn't create the value if it does not exist.
     *
     * @param group
     * @param code
     * @return GeneralParameterValue
     */
    public static GeneralParameterValue searchParameter(final ParameterValueGroup group, final String code){
        ArgumentChecks.ensureNonNull("group", group);
        for(GeneralParameterValue param : group.values()){
            if(param instanceof ParameterValue){
                final ParameterValue pv = (ParameterValue) param;
                if(pv.getDescriptor().getName().getCode().equals(code)){
                    return pv;
                }
            }else if(param instanceof ParameterValueGroup){
                final ParameterValueGroup pvg = (ParameterValueGroup) param;
                if(pvg.getDescriptor().getName().getCode().equals(code)){
                    return pvg;
                }
            }
        }
        return null;
    }

}
