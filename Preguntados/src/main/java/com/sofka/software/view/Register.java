package com.sofka.software.view;
import com.sofka.software.model.Player;
import com.sofka.software.model.Record;

import javax.swing.JOptionPane;


public class Register extends javax.swing.JFrame {

    private Player jug;

    public Register() {
        initComponents();
        jug = new Player();
        setVisible(true);
    }

    private void jbt_jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_jugarActionPerformed
        String nombre = jtf_nombre.getText();
        if (nombre.isEmpty()) {//devuelve un true si el valor es 0 o null 
                JOptionPane.showMessageDialog(null, "digite un nombre porfavor!!");
                }else{
        jug.insertData(nombre);
        Play jug = new Play(nombre, 0);
        jug.setVisible(true);
        jtf_nombre.setText("");
        }
        


    }//GEN-LAST:event_jbt_jugarActionPerformed
    @SuppressWarnings("unchecked")
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        RecordView h = new RecordView();
        h.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void jtf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nombreActionPerformed

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed
      Intruction ins = new Intruction();
      ins.setVisible(true);
    }//GEN-LAST:event_btnInstruccionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbt_jugar;
    private javax.swing.JTextField jtf_nombre;
    // End of variables declaration//GEN-END:variables
}
