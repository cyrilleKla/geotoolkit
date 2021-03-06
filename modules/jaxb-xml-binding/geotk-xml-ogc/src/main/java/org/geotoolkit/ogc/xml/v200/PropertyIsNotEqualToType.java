/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2008 - 2009, Geomatys
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
package org.geotoolkit.ogc.xml.v200;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.opengis.filter.PropertyIsNotEqualTo;

/**
 *
 * @author Guilhem Legal
 * @module pending
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyIsNotEqualTo")
public class PropertyIsNotEqualToType  extends BinaryComparisonOpType implements PropertyIsNotEqualTo {

    /**
     * Empty constructor used by JAXB
     */
    public PropertyIsNotEqualToType() {
        
    }
    
    /**
     * Build a new Binary comparison operator
     */
    public PropertyIsNotEqualToType(final LiteralType literal, final String propertyName, final Boolean matchCase) {
        super(literal, propertyName, matchCase);
    }
    
    public PropertyIsNotEqualToType(final PropertyIsNotEqualToType that) {
        super(that);
    }
}
