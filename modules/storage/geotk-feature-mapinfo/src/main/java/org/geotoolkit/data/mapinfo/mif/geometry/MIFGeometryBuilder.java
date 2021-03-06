/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2013, Geomatys
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
package org.geotoolkit.data.mapinfo.mif.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.apache.sis.storage.DataStoreException;
import org.geotoolkit.feature.type.DefaultName;
import org.geotoolkit.feature.FeatureTypeBuilder;
import org.geotoolkit.feature.type.DefaultAttributeType;
import org.geotoolkit.feature.Feature;
import org.geotoolkit.feature.type.AttributeDescriptor;
import org.geotoolkit.feature.type.AttributeType;
import org.geotoolkit.feature.type.FeatureType;
import org.geotoolkit.feature.type.Name;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import org.apache.sis.util.ArgumentChecks;

/**
 * Used for {@link org.geotoolkit.data.mapinfo.mif.MIFUtils.GeometryType}, to allow us pass a method for building geometry as
 * enum attribute.
 *
 * @author Alexis Manin (Geomatys)
 *         Date : 25/02/13
 */
public abstract class MIFGeometryBuilder {

    protected final static Logger LOGGER = Logger.getLogger(MIFGeometryBuilder.class.getName());
    protected final static GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel());


    protected static final AttributeType STRING_TYPE =
            new DefaultAttributeType(new DefaultName("TEXT"), String.class, false, false, null, null, null);
    /**
     * Parse an input file to build a JTS Geometry with its data.
     *
     *
     * @param scanner the Scanner to use for geometry parsing (should be placed on the beginning of the geometry).
     * @param toFill The feature to put geometry data. It cannot be null, and should have been built with feature type
     *               given by {@link MIFGeometryBuilder#buildType(org.opengis.referencing.crs.CoordinateReferenceSystem, org.opengis.feature.type.FeatureType)}.
     * @param toApply
     */
    public abstract void buildGeometry(Scanner scanner, Feature toFill, MathTransform toApply) throws DataStoreException;

    /**
     * Build a feature type which represents a MIF geometry.
     *
     *
     *
     * @param crs The CRS to put in feature type. If null, no CRS will be pass to the feature type.
     * @param parent
     * @return A {@link org.geotoolkit.feature.FeatureType} which describe a geometry (as MIF defines it).
     */
    public FeatureType buildType(CoordinateReferenceSystem crs, FeatureType parent) {
        FeatureTypeBuilder builder = new FeatureTypeBuilder();

        // As parent's attributes are not shared, we must copy them to the new feature type.
        if(parent != null) {
            builder.copy(parent);
            builder.setSuperType(parent);
            for(AttributeDescriptor desc : getAttributes()) {
                if(parent.getDescriptor(desc.getName()) == null) {
                    builder.add(desc);
                }
            }
        }

        builder.setName(getName());
        builder.add(getName(), getGeometryBinding(), crs);

        return builder.buildFeatureType();
    }

    /**
     * Build a MIF geometry from the current Geotk feature.
     *
     * For the moment, MIF style generation is not managed. However, base implementation in {@link MIFGeometryBuilder}
     * only process base verification on the input feature (valid geometry type).
     *
     * @param geometry The feature to read for MIF geometry building.
     * @return A String which is the representation of the MIF geometry.
     * @throws DataStoreException If an error occur while reading feature.
     */
    public String toMIFSyntax(Feature geometry) throws DataStoreException {
        ArgumentChecks.ensureNonNull("Source geometry", geometry);
        if(geometry.getDefaultGeometryProperty() == null) {
            throw new DataStoreException("Input feature does not contain any geometry.");
        } else {
            final Object valueObj = geometry.getDefaultGeometryProperty().getValue();
            boolean geomMatch = false;
            Class geomCls = null;
            if(valueObj !=null){
                geomCls = valueObj.getClass();
                for(Class possibleBinding : getPossibleBindings()) {
                    if (geomCls.equals(possibleBinding)) {
                        geomMatch = true;
                        break;
                    }
                }
            }
            if(!geomMatch) {
                throw new DataStoreException("Input feature does not contain the right geometry type.\nExpected : "
                        +getGeometryBinding()+"\nFound : "+geomCls);
            }
        }
        return new String();
    }

    /**
     * @return the default java class used to store the MIF geometry.
     */
    public abstract Class getGeometryBinding();

    /**
     * @return all possible geometry class we can use to represent our geometry.
     */
    public abstract Class[] getPossibleBindings();

    /**
     * The name of the geometry, as MIF defines it.
     * @return
     */
    public abstract Name getName();

    protected abstract List<AttributeDescriptor> getAttributes();

}
