/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Koneksi;

/**
 *
 * @author Mr.Al
 */
public class ViewCariBarang extends javax.swing.JFrame {

    Koneksi cn = new Koneksi();

    /**
     * Creates new form ViewCariBarang
     */
    public ViewCariBarang() {
        initComponents();
        dataTabel();
        setLocationRelativeTo(null);
    }

    private void dataTabel() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Cari Barang");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Caari Barang  :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextFieldCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCariActionPerformed(evt);
            }
        });
        jTextFieldCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCariKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 270, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCariKeyPressed
        // TODO add your handling code here:
        cn.koneksiDatabase();
        String nama = jTextFieldCari.getText();

        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("ID BARANG");
        tabel.addColumn("NAMA BARANG");
        tabel.addColumn("JENIS BARANG");
        tabel.addColumn("JUMLAH BARANG");

        jTable1.setModel(tabel);

        try {
            Koneksi cn = new Koneksi();
            cn.koneksiDatabase();
            String data = "select * from tbl_barang where nama like '%" + nama + "%'";
            ResultSet res = cn.state.executeQuery(data);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("nama"),
                    res.getString("jenis"),
                    res.getString("jumlah")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Harap Masukan Data");
        }
    }//GEN-LAST:event_jTextFieldCariKeyPressed

    private void jTextFieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCariActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCariBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCari;
    // End of variables declaration//GEN-END:variables
}
