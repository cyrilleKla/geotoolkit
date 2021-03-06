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

package org.geotoolkit.data.osm.client.v060;

import org.geotoolkit.data.osm.client.AbstractReadNodeWays;
import org.geotoolkit.data.osm.client.OpenStreetMapClient;

/**
 *
 * @author Johann Sorel (Geomatys)
 * @module pending
 */
public class ReadNodeWays060 extends AbstractReadNodeWays{

    public ReadNodeWays060(final OpenStreetMapClient server){
        super(server,"/api/0.6/node/");
    }

    @Override
    protected String getSubPath() {
        if(id <= 0){
            throw new IllegalArgumentException("id has not been defined");
        }
        return super.getSubPath() + id+"/ways";
    }

}
