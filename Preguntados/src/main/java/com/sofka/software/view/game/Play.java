package com.sofka.software.view.game;

import com.sofka.software.model.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Play extends javax.swing.JFrame {

    /**
     * Creates new form
     */
    private Register reg;
    private Category cat;
    private Question preg;
    private Response resp;
    private Record his;
    private Player jug;
    private String valorNombre = "";
    private int valorPunt = 0;
    private String nombre;
    private ResultSet res;
    private int puntaje = 0;
    String nombreCat = "";
    String nombreNiv = "";
    String nombrePreg = "";
    int idPregunta = 0;
    int nivel = 0;
    ArrayList<Integer> lista = new ArrayList<Integer>();
    Map<Integer, String> dicRes = new HashMap<Integer, String>();
    ArrayList<String> listaDes = new ArrayList<String>();

    public Play(String nombre, int puntaje) {
       // initComponents();
       
        cat = new Category();
        preg = new Question();
        resp = new Response();
        his = new Record();
        jug = new Player();
        this.valorNombre = nombre;
        this.valorPunt = puntaje;
        jtfPuntaje.setText(String.valueOf(this.valorPunt));
        jtfNombre.setText(this.valorNombre);
        lista = cat.queryData();
        nivel = nivel + 1;
        subirNivel(nivel);

    }

    public void subirNivel(int i) {
        nombreCat = cat.queryCategory(i);
        jtfCategoria.setText(nombreCat);
        nombreNiv = cat.queryLevel(i);
        jtfNivel.setText(nombreNiv);
        idPregunta = preg.queryQuestionCat(i);
        nombrePreg = preg.queryQuestionTex(idPregunta);
        jtf_pregunta.setText(nombrePreg);
        dicRes = resp.consultarIdRespuesta(idPregunta);
        Set<Integer> keys = dicRes.keySet();
        int cont = 0;
        for (Integer key : keys) {
            if (cont == 0) {
                jRadio1.setText(dicRes.get(key));
            } else {
                if (cont == 1) {
                    jRadio2.setText(dicRes.get(key));
                } else {
                    if (cont == 2) {
                        jRadio3.setText(dicRes.get(key));
                    } else {
                        jRadio4.setText(dicRes.get(key));
                    }
                }

            }
            cont++;
        }
    }
    private void jtf_preguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_preguntaActionPerformed
       
    }//GEN-LAST:event_jtf_preguntaActionPerformed

    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed

    }//GEN-LAST:event_jtfNombreActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        boolean respuesta;
        int puntAcum = 0;
        int idjugador = 0;
        resp = new Response();
        if (jRadio1.isSelected()) {
            puntAcum = resp.validarRespuesta(dicRes, jRadio1.getText());
        } else if (jRadio2.isSelected()) {
            puntAcum = resp.validarRespuesta(dicRes, jRadio2.getText());
        } else if (jRadio3.isSelected()) {
            puntAcum = resp.validarRespuesta(dicRes, jRadio3.getText());
        } else {
            puntAcum = resp.validarRespuesta(dicRes, jRadio4.getText());
        }

        if (puntAcum == 0) {// si el acumulado es 0 finaliza el juego 
            dispose();
        } else {
            puntaje = puntaje + puntAcum;
            jtfPuntaje.setText(String.valueOf(puntaje));

            nivel = nivel + 1;
            if (nivel <= 5) {
                subirNivel(nivel);
            }

            if (nivel > 5) {
                idjugador = jug.queryPlayer();
                JOptionPane.showMessageDialog(null, "Felicidades!! completaste el juego");
                his.insertRecord(idjugador, puntaje, "Ganó");
                dispose();
            }

        }


    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        int idjugador = 0;
        int resp = JOptionPane.showConfirmDialog(null, "Está seguro de retirarse?, El juego finalizará y ganarás el acumulado actual", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        switch (resp) {
            case 0:
                idjugador = jug.queryPlayer();
                jug.saveScore(idjugador, puntaje);
                his.insertRecord(idjugador, puntaje, "Retiro");
                JOptionPane.showMessageDialog(null, "Su puntaje acumulado fue de : " + puntaje);
                dispose();
                break;
        }


    }//GEN-LAST:event_btnRetirarActionPerformed

    private void jtfCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCategoriaActionPerformed

    private void jtfNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNivelActionPerformed

    private void jtfPuntajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPuntajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPuntajeActionPerformed

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
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Play("", 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadio1;
    private javax.swing.JRadioButton jRadio2;
    private javax.swing.JRadioButton jRadio3;
    private javax.swing.JRadioButton jRadio4;
    private javax.swing.JTextField jtfCategoria;
    private javax.swing.JTextField jtfNivel;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPuntaje;
    private javax.swing.JTextField jtf_pregunta;
    private javax.swing.ButtonGroup validar;
    // End of variables declaration//GEN-END:variables
}
