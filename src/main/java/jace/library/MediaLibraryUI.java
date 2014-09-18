/*
 * Copyright (C) 2013 brobert.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package jace.library;

import jace.Emulator;
import jace.EmulatorUILogic;
import static jace.EmulatorUILogic.MEDIA_MANAGER_EDIT_DIALOG_NAME;
import static jace.EmulatorUILogic.MEDIA_MANAGER_DIALOG_NAME;
import jace.core.Utility;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/**
 *
 * @author brobert
 */
public class MediaLibraryUI extends javax.swing.JPanel {

    public static final String EMPTY_VALUE = "_EMPTY_";
    public static final String MISCELLANEOUS = "Misc.";

    /**
     * Creates new form MediaLibraryUI
     */
    public MediaLibraryUI() {
        initComponents();
        titlesList.setTransferHandler(new DiskTransferHandler());
        titlesList.setDragEnabled(true);
        titlesList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() > 1) {
                    ViewEditActionPerformed(null);
                }
            }
        });
        setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = null;
                    try {
                        droppedFiles = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    } catch (ClassCastException e) {
                        return;
                    }
                    boolean added = false;
                    for (File file : droppedFiles) {
                        MediaEntry entry = new MediaEntry();
                        entry.name = file.getName();
                        entry.source = file.toURI().toURL().toExternalForm();
                        entry.type = DiskType.determineType(file);
                        entry.description = "Added via drag-and-drop to media library";
                        if (null == MediaCache.getLocalLibrary().findLocalEntry(entry)) {
                            MediaCache.getLocalLibrary().add(entry);
                            added = true;
                        }
                    }
                    if (added) {
                        refreshUI();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace(System.err);
                    Utility.gripe("Could not add file to library: " + ex.getMessage());
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tocPane = new javax.swing.JScrollPane();
        tocTree = new javax.swing.JTree();
        orderToolbar = new javax.swing.JToolBar();
        orderByLabel = new javax.swing.JLabel();
        orderByCombo = new javax.swing.JComboBox();
        actionToolbar = new javax.swing.JToolBar();
        CreateNew = new javax.swing.JButton();
        ViewEdit = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        Favorite = new javax.swing.JButton();
        titlesScrollpane = new javax.swing.JScrollPane();
        titlesList = new javax.swing.JList();
        titleLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();

        tocTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                tocTreeValueChanged(evt);
            }
        });
        tocPane.setViewportView(tocTree);

        orderToolbar.setRollover(true);

        orderByLabel.setText("Order By:");
        orderToolbar.add(orderByLabel);

        orderByCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "Favorites", "Recently Used", "Category", "Source", "Keyword", "Author" }));
        orderByCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderByComboActionPerformed(evt);
            }
        });
        orderToolbar.add(orderByCombo);

        actionToolbar.setRollover(true);

        CreateNew.setText("Create");
        CreateNew.setFocusable(false);
        CreateNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreateNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewActionPerformed(evt);
            }
        });
        actionToolbar.add(CreateNew);

        ViewEdit.setText("View");
        ViewEdit.setFocusable(false);
        ViewEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ViewEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewEditActionPerformed(evt);
            }
        });
        actionToolbar.add(ViewEdit);

        Remove.setText("Remove");
        Remove.setFocusable(false);
        Remove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Remove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        actionToolbar.add(Remove);

        Favorite.setText("Favorite");
        Favorite.setFocusable(false);
        Favorite.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Favorite.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Favorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FavoriteActionPerformed(evt);
            }
        });
        actionToolbar.add(Favorite);

        titlesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Software titles listed here" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        titlesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        titlesList.setDragEnabled(true);
        titlesScrollpane.setViewportView(titlesList);

        titleLabel.setText("SoftwareTitle");

        descriptionLabel.setFont(descriptionLabel.getFont().deriveFont((descriptionLabel.getFont().getStyle() | java.awt.Font.ITALIC)));
        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        descriptionLabel.setText("Software Description Here");
        descriptionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tocPane))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actionToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titlesScrollpane))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actionToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titlesScrollpane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tocPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ViewEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewEditActionPerformed
        if (getSelectedEntry() == null) {
            return;
        }
        System.out.println(getSelectedEntry().name);
        Emulator.getFrame().registerModalDialog(
                MediaLibrary.getInstance().buildEditInstance(this, getSelectedEntry()),
                MEDIA_MANAGER_EDIT_DIALOG_NAME,
                MEDIA_MANAGER_DIALOG_NAME, true);
        Emulator.getFrame().showDialog(MEDIA_MANAGER_EDIT_DIALOG_NAME);
    }//GEN-LAST:event_ViewEditActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        MediaEntry selection = getSelectedEntry();
        if (selection == null) {
            return;
        }
        String message = "Are you sure you want to remove " + selection.name + " from the library?  This cannot be undone!";
        if (!EmulatorUILogic.confirm(message)) {
            return;
        }
        cache.remove(selection);
        refreshUI();
    }//GEN-LAST:event_RemoveActionPerformed

    private void CreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewActionPerformed
        Emulator.getFrame().registerModalDialog(
                MediaLibrary.getInstance().buildEditInstance(this, null),
                MEDIA_MANAGER_EDIT_DIALOG_NAME,
                MEDIA_MANAGER_DIALOG_NAME, true);
        Emulator.getFrame().showDialog(MEDIA_MANAGER_EDIT_DIALOG_NAME);
    }//GEN-LAST:event_CreateNewActionPerformed

    private void FavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FavoriteActionPerformed
        MediaEntry selection = getSelectedEntry();
        if (selection == null) {
            return;
        }
        selection.favorite = true;
        cache.update(selection);
    }//GEN-LAST:event_FavoriteActionPerformed

    private void orderByComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByComboActionPerformed
        updateTOCTree();
    }//GEN-LAST:event_orderByComboActionPerformed

    private void tocTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_tocTreeValueChanged
        titlesList.removeAll();
        TreeModel model = tocTree.getModel();
        if (!(model instanceof TocTreeModel)) {
            return;
        }
        TocTreeModel tocModel = (TocTreeModel) model;
        Set<Long> allEntries = tocModel.getEntries(evt.getPath().getLastPathComponent());
        if (allEntries == null) {
            return;
        }
        Vector v = new Vector();
        for (Long l : allEntries) {
            v.add(cache.mediaLookup.get(l));
        }
        titlesList.setListData(v);
    }//GEN-LAST:event_tocTreeValueChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CreateNew;
    public javax.swing.JButton Favorite;
    public javax.swing.JButton Remove;
    public javax.swing.JButton ViewEdit;
    public javax.swing.JToolBar actionToolbar;
    public javax.swing.JLabel descriptionLabel;
    public javax.swing.JComboBox orderByCombo;
    public javax.swing.JLabel orderByLabel;
    public javax.swing.JToolBar orderToolbar;
    public javax.swing.JLabel titleLabel;
    public javax.swing.JList titlesList;
    public javax.swing.JScrollPane titlesScrollpane;
    public javax.swing.JScrollPane tocPane;
    public javax.swing.JTree tocTree;
    // End of variables declaration//GEN-END:variables
    MediaCache cache;

    public void setCache(MediaCache libraryCache) {
        cache = libraryCache;
        updateTOCTree();
    }
    boolean localLibrary;

    public void setLocal(boolean b) {
        localLibrary = b;
    }

    public boolean isLocal() {
        return localLibrary;
    }

    private MediaEntry getSelectedEntry() {
        Object sel = titlesList.getSelectedValue();
        if (sel == null || !(sel instanceof MediaEntry)) {
            return null;
        }
        return (MediaEntry) sel;
    }

    public void refreshUI() {
        //TODO: Preserve selections in toc tree and media title list!
        updateTOCTree();
    }

    public static interface tocSortModel {

        public TreeModel buildModel(MediaCache cache);
    }

    public static enum tocOptions {

        Name("Name", new tocSortModel() {
            public TreeModel buildModel(MediaCache cache) {
                Set<String> names = cache.nameLookup.keySet();
                TocTreeModel model = new TocTreeModel();
                model.name = "All By Name";
                for (String name : names) {
                    if (name == null || name.length() == 0) {
                        name = EMPTY_VALUE;
                    }
                    String letter = name.toUpperCase().substring(0, 1);
                    model.addItems(letter, name, cache.nameLookup.get(name));
                }
                model.twoLevel = false;
                return model;
            }
        }),
        Favorites(
        "Favorites", new tocSortModel() {
            public TreeModel buildModel(MediaCache cache) {
                Set<String> names = cache.nameLookup.keySet();
                TocTreeModel model = new TocTreeModel();
                model.name = "Favorites By Name";
                for (String name : names) {
                    // Filter out only the favorites
                    Set<Long> entries = cache.nameLookup.get(name);
                    entries.retainAll(cache.favorites);
                    if (entries.isEmpty()) {
                        continue;
                    }
                    if (name == null || name.length() == 0) {
                        name = EMPTY_VALUE;
                    }
                    String letter = name.toUpperCase().substring(0, 1);
                    model.addItems(letter, name, entries);
                }
                model.twoLevel = false;
                return model;
            }
        }),
        Recently_Used("Recently Used", new tocSortModel() {
            public TreeModel buildModel(MediaCache cache) {
                TreeModel model = new DefaultTreeModel(null, true);
                return model;
            }
        }),
        Category("Category", new tocSortModel() {
            public TreeModel buildModel(MediaCache cache) {
                Set<String> names = cache.categoryLookup.keySet();
                TocTreeModel model = new TocTreeModel();
                model.name = "All By Category";
                for (String name : names) {
                    if (name == null || name.length() == 0) {
                        name = EMPTY_VALUE;
                    }
                    String[] categories = name.split(":|/");
                    String sub = (categories.length > 1 ? categories[1] : MISCELLANEOUS);
                    model.addItems(categories[0], sub, cache.nameLookup.get(name));
                }
                return model;
            }
        }),
        Source("Source", new tocSortModel() {
            public TreeModel buildModel(MediaCache cache) {
                TreeModel model = new DefaultTreeModel(null, true);
                return model;
            }
        }),
        Keyword("Keyword", new tocSortModel() {
            public TreeModel buildModel(MediaCache cache) {
                Set<String> names = cache.keywordLookup.keySet();
                TocTreeModel model = new TocTreeModel();
                model.name = "All By Keyword";
                for (String name : names) {
                    if (name == null || name.length() == 0) {
                        name = EMPTY_VALUE;
                    }
                    String letter = name.toUpperCase().substring(0, 1);
                    model.addItems(letter, name, cache.keywordLookup.get(name));
                }
                return model;
            }
        }),
        Author("Author", new tocSortModel() {
            public TreeModel buildModel(MediaCache cache) {
                TreeModel model = new DefaultTreeModel(null, true);
                return model;
            }
        });
        String alternate;
        public tocSortModel factory;

        tocOptions(String alt, tocSortModel modelFactory) {
            alternate = alt;
            factory = modelFactory;
        }

        public static tocOptions fromString(String str) {
            try {
                return tocOptions.valueOf(str);
            } catch (Throwable t) {
                for (tocOptions option : tocOptions.values()) {
                    if (option.alternate.equalsIgnoreCase(str)) {
                        return option;
                    }
                }
            }
            return null;
        }
    };

    private void updateTOCTree() {
        String order = String.valueOf(orderByCombo.getSelectedItem());
        tocOptions sortOption = tocOptions.fromString(order);
        tocTree.setModel(sortOption.factory.buildModel(cache));
    }
}