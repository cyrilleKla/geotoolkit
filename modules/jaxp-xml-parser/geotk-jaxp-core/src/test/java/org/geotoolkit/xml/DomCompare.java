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


package org.geotoolkit.xml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.sis.test.XMLComparator;
import org.xml.sax.SAXException;


/**
 *
 * @author Johann Sorel (Geomatys)
 * @module pending
 *
 * @deprecated Replaced by {@link org.apache.sis.test.Assert#assertXmlEquals(Object, Object, String[])}.
 */
@Deprecated
public class DomCompare {

    /**
     * convenient method to test xml comparison by ignoring irrevelant details
     * like formating, different attribute order, comments ...
     *
     * @param expected : the expected structure (File,Stream,Document)
     * @param result : the obtained result (File,Stream,Document)
     */
    public static void compare(final Object expected, final Object result)
            throws ParserConfigurationException, SAXException, IOException
    {
        final XMLComparator comparator = new XMLComparator(expected, result);
        comparator.compare();
    }
}
