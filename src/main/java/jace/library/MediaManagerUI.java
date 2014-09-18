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

/**
 *
 * @author brobert
 */
public class MediaManagerUI extends javax.swing.JPanel {

    /**
     * Creates new form MediaManagerUI
     */
    public MediaManagerUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Libraries = new javax.swing.JTabbedPane();
        mediaLibraryUI2 = new jace.library.MediaLibraryUI();
        mediaLibraryUI3 = new jace.library.MediaLibraryUI();
        addLibraryTab = new javax.swing.JPanel();
        libraryPathField = new javax.swing.JTextField();
        librarySourceLabel = new javax.swing.JLabel();
        libraryAddInstructionsLabel = new javax.swing.JLabel();
        addLibraryButton = new javax.swing.JButton();
        Drives = new javax.swing.JPanel();

        Libraries.addTab("Local", mediaLibraryUI2);
        Libraries.addTab("Virtual II", mediaLibraryUI3);

        libraryPathField.setText("jTextField1");
        libraryPathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryPathFieldActionPerformed(evt);
            }
        });

        librarySourceLabel.setText("Source");

        libraryAddInstructionsLabel.setText("<html><p>Either type in the URL or path to the source, or drag it from another window (file manager or web browser) -- The source should be the path to the XML catalog, not just the path to the main website.</p>");

        addLibraryButton.setText("Add");
        addLibraryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLibraryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addLibraryTabLayout = new javax.swing.GroupLayout(addLibraryTab);
        addLibraryTab.setLayout(addLibraryTabLayout);
        addLibraryTabLayout.setHorizontalGroup(
            addLibraryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLibraryTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addLibraryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(libraryAddInstructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(addLibraryTabLayout.createSequentialGroup()
                        .addComponent(librarySourceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(libraryPathField, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLibraryButton)))
                .addContainerGap())
        );
        addLibraryTabLayout.setVerticalGroup(
            addLibraryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLibraryTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(libraryAddInstructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addLibraryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libraryPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(librarySourceLabel)
                    .addComponent(addLibraryButton))
                .addContainerGap(269, Short.MAX_VALUE))
        );

        Libraries.addTab("Add New Library", addLibraryTab);

        Drives.setMinimumSize(new java.awt.Dimension(100, 430));
        java.awt.GridBagLayout DrivesLayout = new java.awt.GridBagLayout();
        DrivesLayout.columnWidths = new int[] {1};
        DrivesLayout.rowHeights = new int[] {10};
        Drives.setLayout(DrivesLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Libraries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Drives, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Libraries, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Drives, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void libraryPathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libraryPathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libraryPathFieldActionPerformed

    private void addLibraryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLibraryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addLibraryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Drives;
    public javax.swing.JTabbedPane Libraries;
    public javax.swing.JButton addLibraryButton;
    public javax.swing.JPanel addLibraryTab;
    public javax.swing.JLabel libraryAddInstructionsLabel;
    public javax.swing.JTextField libraryPathField;
    public javax.swing.JLabel librarySourceLabel;
    public jace.library.MediaLibraryUI mediaLibraryUI2;
    public jace.library.MediaLibraryUI mediaLibraryUI3;
    // End of variables declaration//GEN-END:variables
}