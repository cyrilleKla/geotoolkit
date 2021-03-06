/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2012, Geomatys
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
package org.geotoolkit.osmtms;

import org.geotoolkit.coverage.*;
import org.apache.sis.storage.DataStoreException;
import org.geotoolkit.feature.type.Name;

/**
 * Open Street Map Tile Map Server.
 * 
 * @author Johann Sorel (Geomatys)
 * @module pending
 */
public class OSMTMSCoverageReference extends AbstractPyramidalCoverageReference {

    OSMTMSCoverageReference(OSMTileMapClient server, Name name){
        super(server,name,0);
    }

    @Override
    public PyramidSet getPyramidSet() throws DataStoreException {
        return ((OSMTileMapClient)store).getPyramidSet();
    }

}
