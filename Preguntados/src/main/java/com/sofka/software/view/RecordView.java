package com.sofka.software.view;
import java.util.ArrayList;
import java.util.List;

import com.sofka.software.model.Record;

public class RecordView extends javax.swing.JFrame {
    private Record h;
    List<List<String>> lista2 = new ArrayList<List<String>>();

    public RecordView() {
        initComponents();
        String cadena = "";
        h = new Record();
        lista2 = h.mostrarHistorial();
        for (int i = 0; i <= lista2.get(0).size() - 1; i++) {
            cadena += "Nombre : " + lista2.get(0).get(i) + " | Puntaje : " + lista2.get(1).get(i) + " | Estado : " + lista2.get(2).get(i) + "\n";
        }
        jtextHistorial.setText(cadena);
    }
    @SuppressWarnings("unchecked")
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        dispose();
    }//GEN-LAST:event_btnInicioActionPerformed
    @SuppressWarnings("unchecked")
    private void btnBorrHistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrHistActionPerformed
        h.deleteRecord();
        jtextHistorial.setText("");
    }//GEN-LAST:event_btnBorrHistActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrHist;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtextHistorial;

}
