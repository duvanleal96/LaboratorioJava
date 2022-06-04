package com.sofka.software.view;

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
        initComponents();

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        validar = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtf_pregunta = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jRadio2 = new javax.swing.JRadioButton();
        jRadio1 = new javax.swing.JRadioButton();
        jRadio4 = new javax.swing.JRadioButton();
        jRadio3 = new javax.swing.JRadioButton();
        btnRetirar = new javax.swing.JButton();
        jtfCategoria = new javax.swing.JTextField();
        jtfNivel = new javax.swing.JTextField();
        jtfPuntaje = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Concurso Preguntados");

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("CATEGORIA");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("NIVEL");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("PUNTAJE");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("NOMBRE");

        jtfNombre.setBackground(new java.awt.Color(240, 240, 240));
        jtfNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfNombre.setEnabled(false);
        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });

        jtf_pregunta.setEditable(false);
        jtf_pregunta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtf_pregunta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtf_pregunta.setEnabled(false);
        jtf_pregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_preguntaActionPerformed(evt);
            }
        });

        btnEnviar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 0, 51));
        btnEnviar.setText("ENVIAR");
        btnEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        validar.add(jRadio2);
        jRadio2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        validar.add(jRadio1);
        jRadio1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        validar.add(jRadio4);
        jRadio4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        validar.add(jRadio3);
        jRadio3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        btnRetirar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRetirar.setForeground(new java.awt.Color(255, 51, 51));
        btnRetirar.setText("RETIRARSE");
        btnRetirar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        jtfCategoria.setBackground(new java.awt.Color(240, 240, 240));
        jtfCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfCategoria.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfCategoria.setEnabled(false);
        jtfCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCategoriaActionPerformed(evt);
            }
        });

        jtfNivel.setBackground(new java.awt.Color(240, 240, 240));
        jtfNivel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfNivel.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfNivel.setEnabled(false);
        jtfNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNivelActionPerformed(evt);
            }
        });

        jtfPuntaje.setBackground(new java.awt.Color(240, 240, 240));
        jtfPuntaje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfPuntaje.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfPuntaje.setEnabled(false);
        jtfPuntaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPuntajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtfPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addComponent(jLabel2))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jtfNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jtfCategoria)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadio3)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jRadio1)
                                                                .addGap(215, 215, 215)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jRadio2)
                                                                        .addComponent(jRadio4)))))
                                        .addComponent(jtf_pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel5))
                                                .addGap(5, 5, 5))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jtfNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jtf_pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadio1)
                                        .addComponent(jRadio2))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadio3)
                                        .addComponent(jRadio4))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnRetirar)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        if (puntAcum == 0) {
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
    // End of variables declaration//
}
