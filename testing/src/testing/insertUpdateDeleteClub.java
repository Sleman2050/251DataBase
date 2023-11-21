/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Abosl
 */
public class insertUpdateDeleteClub extends javax.swing.JFrame {

    /**
     * Creates new form insertClub
     */
    public insertUpdateDeleteClub() {
        initComponents();
        show_clubs();
    }

    public ArrayList<club> clubList() {
        ArrayList<club> clubList = new ArrayList<>();
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=KAU_Events_Clubs;user=sa;password=12345";
            Connection con = DriverManager.getConnection(url);

            String query1 = "SELECT * FROM clubBase";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            club clubO;
            while (rs.next()) {
                clubO = new club(rs.getInt("clubCode"), rs.getString("clubName"), rs.getString("clubDescription"), rs.getDate("clubFounded"));
                clubList.add(clubO);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return clubList;
    }

    public void show_clubs() {
        ArrayList<club> list = clubList();
        DefaultTableModel model = (DefaultTableModel) clubTableAUD.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getClubCode();
            row[1] = list.get(i).getClubName();
            row[2] = list.get(i).getClubDescription();
            row[3] = list.get(i).getClubFounded();

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clubID = new javax.swing.JLabel();
        clubName = new javax.swing.JLabel();
        club3 = new javax.swing.JLabel();
        clubCodefield = new javax.swing.JTextField();
        clubNameField = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        AddClub = new javax.swing.JButton();
        clubDate = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        updateClub = new javax.swing.JButton();
        DeleteClubBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clubTableAUD = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clubID.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        clubID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubID.setText("Club ID");
        clubID.setAutoscrolls(true);
        clubID.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        clubName.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        clubName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubName.setText("Club Name");

        club3.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        club3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        club3.setText("Club Description");

        clubCodefield.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        clubCodefield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        clubCodefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clubCodefieldActionPerformed(evt);
            }
        });

        clubNameField.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        clubNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField3.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        AddClub.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        AddClub.setText("Add");
        AddClub.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        AddClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClubActionPerformed(evt);
            }
        });

        clubDate.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        clubDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubDate.setText("Club Founded");

        updateClub.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        updateClub.setText("Update");
        updateClub.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        updateClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateClubActionPerformed(evt);
            }
        });

        DeleteClubBtn.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        DeleteClubBtn.setText("Delete");
        DeleteClubBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        DeleteClubBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClubBtnActionPerformed(evt);
            }
        });

        clubTableAUD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "clubID", "clubName", "clubDescription", "clubFounded"
            }
        ));
        clubTableAUD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clubTableAUDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clubTableAUD);

        jButton1.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clubID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(club3)
                            .addComponent(clubName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clubDate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clubNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clubCodefield, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddClub, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(updateClub, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(DeleteClubBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clubID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clubCodefield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clubName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clubNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(club3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clubDate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddClub)
                    .addComponent(updateClub)
                    .addComponent(DeleteClubBtn))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClubActionPerformed
        try {
            // Get the required inputs
            String clubCode = clubCodefield.getText();
            String clubName = clubNameField.getText();
            String clubDescription = jTextField3.getText();
            // Convert java.util.Date to java.sql.Date
            java.util.Date utilDate = jDateChooser2.getDate();
            java.sql.Date clubFounded = new java.sql.Date(utilDate.getTime()); // Assuming jDateChooser2 returns a java.util.Date

            // Create an instance of the Admin class
            Admin admin = new Admin();

            // Call the insertClub method
            boolean success = admin.insertClub(clubCode, clubName, clubDescription, clubFounded);

            if (success) {
                JOptionPane.showMessageDialog(null, "Club inserted successfully, thank you.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert club.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_AddClubActionPerformed

    private void clubCodefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clubCodefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clubCodefieldActionPerformed

    private void updateClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateClubActionPerformed
    try {
        // Assuming you have an instance of the Admin class
        Admin admin = new Admin();

        // Get the selected row value from the table
        int row = clubTableAUD.getSelectedRow();
        String value = (clubTableAUD.getModel().getValueAt(row, 0).toString());

        // Get the updated values from the form
        int newClubCode = Integer.parseInt(clubCodefield.getText());
        String clubName = clubNameField.getText();
        String clubDescription = jTextField3.getText();
        java.util.Date clubFounded = jDateChooser2.getDate();

        // Call the updateClub method
        boolean success = admin.updateClub(value, Integer.toString(newClubCode), clubName, clubDescription, clubFounded);

        if (success) {
            JOptionPane.showMessageDialog(null, "Club updated successfully, thank you.");
            // Refresh the table after updating
            DefaultTableModel model = (DefaultTableModel) clubTableAUD.getModel();
            model.setRowCount(0);
            show_clubs();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update club.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_updateClubActionPerformed

    private void DeleteClubBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClubBtnActionPerformed
            try {
        // Assuming you have an instance of the Admin class
        Admin admin = new Admin();

        // Get the selected row value from the table
        int row = clubTableAUD.getSelectedRow();
        String value = (clubTableAUD.getModel().getValueAt(row, 0).toString());

        // Call the deleteClub method
        boolean success = admin.deleteClub(value);

        if (success) {
            JOptionPane.showMessageDialog(null, "Club deleted successfully, thank you.");
            // Refresh the table after deletion
            DefaultTableModel model = (DefaultTableModel) clubTableAUD.getModel();
            model.setRowCount(0);
            show_clubs();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete club.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_DeleteClubBtnActionPerformed

    private void clubTableAUDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clubTableAUDMouseClicked

        int i = clubTableAUD.getSelectedRow();
        TableModel model = clubTableAUD.getModel();
        clubCodefield.setText(model.getValueAt(i, 0).toString());
        clubNameField.setText(model.getValueAt(i, 1).toString());
        jTextField3.setText(model.getValueAt(i, 2).toString());
        jDateChooser2.setDate((Date) model.getValueAt(i, 3));


    }//GEN-LAST:event_clubTableAUDMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        AdminFunctions field =new AdminFunctions();
     field.setVisible(true);
     setVisible(false);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(insertUpdateDeleteClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertUpdateDeleteClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertUpdateDeleteClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertUpdateDeleteClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insertUpdateDeleteClub().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClub;
    private javax.swing.JButton DeleteClubBtn;
    private javax.swing.JLabel club3;
    private javax.swing.JTextField clubCodefield;
    private javax.swing.JLabel clubDate;
    private javax.swing.JLabel clubID;
    private javax.swing.JLabel clubName;
    private javax.swing.JTextField clubNameField;
    private javax.swing.JTable clubTableAUD;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton updateClub;
    // End of variables declaration//GEN-END:variables
}
