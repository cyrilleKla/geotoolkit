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
package org.geotoolkit.filter.binding;

import java.util.Collection;
import java.util.regex.Pattern;
import static org.geotoolkit.filter.binding.AttributeBinding.stripPrefix;
import org.opengis.feature.Feature;
import org.opengis.feature.Property;

/**
 *
 * @author Johann Sorel (Geomatys)
 */
public class ComplexAttributeBinding extends AbstractBinding<Feature>{
    private static final Pattern ID_PATTERN       = Pattern.compile("@(\\w+:)?id");
    private static final Pattern PROPERTY_PATTERN = Pattern.compile("(\\w+:)?(.+)");

    public ComplexAttributeBinding() {
        super(Feature.class, 20);
    }
    
    @Override
    public boolean support(String xpath) {
        return !xpath.startsWith("/") &&
               !xpath.startsWith("*") &&
               (PROPERTY_PATTERN.matcher(xpath).matches() || ID_PATTERN.matcher(xpath).matches());
    }

    @Override
    public <T> T get(Feature candidate, String xpath, Class<T> target) throws IllegalArgumentException {
        if(candidate==null) return null;
        xpath = stripPrefix(xpath);
        if(candidate instanceof Feature && ID_PATTERN.matcher(xpath).matches()){
            return (T) ((Feature)candidate).getIdentifier().getID();
        }

        if(target != null){
            if(Property.class.isAssignableFrom(target)){
                final Property prop = candidate.getProperty(xpath);
                return (T) prop;
            }else if(Collection.class.isAssignableFrom(target)){
                final Collection<Property> props = candidate.getProperties(xpath);
                return (T) props;
            }
        }

        final Property prop = candidate.getProperty(xpath);
        if(prop == null){
            return null;
        }else if(prop instanceof DefaultAssociation){
            return (T) ((DefaultAssociation)prop).getLink();
        }else{
            return (T) prop.getValue();
        }
    }

    @Override
    public void set(Feature candidate, String xpath, Object value) throws IllegalArgumentException {
        xpath = stripPrefix(xpath);
        candidate.getProperty(xpath).setValue(value);
    }

}
