/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2007 - 2008, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2008 - 2011, Johann Sorel
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
package org.geotoolkit.gui.swing.contexttree.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.ref.WeakReference;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.geotoolkit.gui.swing.contexttree.AbstractTreePopupItem;
import org.geotoolkit.font.FontAwesomeIcons;
import org.geotoolkit.font.IconBuilder;
import org.geotoolkit.gui.swing.resource.MessageBundle;
import org.geotoolkit.map.MapItem;

/**
 * delete item for JContextTree
 *
 * @author Johann Sorel (Puzzle-GIS)
 * @module pending
 */
public class DeleteItem extends AbstractTreePopupItem{

    private WeakReference<TreePath> itemRef;

    /**
     * delete item for jcontexttree
     */
    public DeleteItem(){
        super( MessageBundle.getString("contexttreetable_delete") );
        init();
    }

    private void init(){
        setIcon(IconBuilder.createIcon(FontAwesomeIcons.ICON_TRASH_O, 16, FontAwesomeIcons.DEFAULT_COLOR) );
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(itemRef == null) return;

                TreePath path = itemRef.get();
                if(path == null) return;

                final DefaultMutableTreeNode parent = (DefaultMutableTreeNode) path.getParentPath().getLastPathComponent();
                final DefaultMutableTreeNode candidate = (DefaultMutableTreeNode) path.getLastPathComponent();
                ((MapItem)parent.getUserObject()).items().remove(candidate.getUserObject());
            }
        }
        );
    }

    @Override
    public boolean isValid(final TreePath[] selection) {
        boolean valid = uniqueAndType(selection,MapItem.class);
        if(valid){
            //check it's not the root mapcontext
            for (int nodeCount = 0 ; nodeCount < selection.length ; nodeCount++) {
                final DefaultMutableTreeNode node = (DefaultMutableTreeNode) selection[nodeCount].getLastPathComponent();
                if (node.isRoot()) {
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }

    @Override
    public Component getComponent(final TreePath[] selection) {
        itemRef = new WeakReference<TreePath>(selection[0]);
        return this;
    }

}
