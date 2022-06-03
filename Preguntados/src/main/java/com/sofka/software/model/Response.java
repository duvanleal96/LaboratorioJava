package com.sofka.software.model;

import com.sofka.software.conexion.base.datos.Conexion;


import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Response {
    private final String sql_selectRes = "SELECT * FROM tbrespuesta WHERE idpregunta = ?";
    private final String sql_selectDesRes = "SELECT * FROM tbrespuesta WHERE id = ?";
    private final String sql_selectPuntaje = "SELECT * FROM tbrespuesta r INNER JOIN tbpregunta p ON r.idpregunta=p.id INNER JOIN tbcategoria c ON p.idcategoria= c.id WHERE r.id= ?";
    private PreparedStatement ps;
    private Conexion con;
    private ResultSet res;
    private Player jug;
    private Record his;

    public Response() {
        ps = null;
        con = new Conexion();
    }

    public Map<Integer, String> consultarIdRespuesta(int idPregunta) {
        Map<Integer, String> dic = new HashMap<Integer, String>();
        try {
            ps = con.crearConexion().prepareStatement(sql_selectRes); //crea conexion y prepara la consulta
            ps.setInt(1, idPregunta);
            res = ps.executeQuery();//ejecuta la consulta
            while (res.next()) {
                dic.put(res.getInt("id"), res.getString("descripcion"));
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el ID de la respuesta : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return dic;
    }

    public int validarRespuesta(Map<Integer, String> dicRes, String check) {
        int result = 0;
        int score = 0;
        jug = new Player();
        his = new Record();
        int idPlayer = 0;
        try {
            Set<Integer> keys = dicRes.keySet();

            for (Integer key : keys) {

                if (dicRes.get(key) == check) {
                    ps = con.crearConexion().prepareStatement(sql_selectDesRes);
                    ps.setInt(1, key);
                    res = ps.executeQuery();
                    while (res.next()) {
                        result = res.getInt("validacion");

                        if (result == 1) {
                            score = obtenerPuntaje(key);
                            JOptionPane.showMessageDialog(null, "Respuesta correcta!! pasaste al siguiente nivel..");
                            break;
                        } else {
                            idPlayer = jug.queryPlayer();
                            his.insertRecord(idPlayer, 0, "Eliminado");
                            JOptionPane.showMessageDialog(null, "Respuesta incorrecta!! Haz sido eliminado");
                            score = 0;
                        }
                    }
                }

            }

        } catch (Exception e) {
            System.err.println("Error al validar la respuesta : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return score;
    }

    public int obtenerPuntaje(int id) {
        int score = 0;
        try {
            ps = con.crearConexion().prepareStatement(sql_selectPuntaje); //crea conexion y prepara la consulta
            ps.setInt(1, id);//valores a los campos
            res = ps.executeQuery();//ejecuta la consulta
            while (res.next()) {
                score = res.getInt("puntaje");
            }
        } catch (Exception e) {
            System.err.println("Error al obtener puntaje de la respuesta : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return score;
    }
}
