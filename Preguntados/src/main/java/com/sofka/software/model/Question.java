package com.sofka.software.model;

import com.sofka.software.conexion.base.datos.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class Question {
    private final String sql_selectPreg = "SELECT * FROM tbpregunta WHERE idcategoria = ?";
    private final String sql_selectNomPreg = "SELECT * FROM tbpregunta WHERE id = ?";
    private PreparedStatement ps;
    private Conexion con;
    private ResultSet res;

    public Question() {
        ps = null;
        con = new Conexion();
    }

    public int queryQuestionCat(int idCategory) {
        int idQuestion = 0;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        try {
            ps = con.crearConexion().prepareStatement(sql_selectPreg);
            ps.setInt(1, idCategory);
            res = ps.executeQuery();//ejecuta la consulta
            while (res.next()) {
                lista.add(res.getInt("id"));
            }
            idQuestion = lista.get(new Random().nextInt(lista.size()));

        } catch (Exception e) {
            System.err.println("Error al consulta ID de la pregunta : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return idQuestion;
    }

    public String queryQuestionTex(int idQuestion) {
        String namep = "";
        try {
            ps = con.crearConexion().prepareStatement(sql_selectNomPreg); //crea conexion y prepara la consulta
            ps.setInt(1, idQuestion);
            res = ps.executeQuery();
            while (res.next()) {
                namep = res.getString("descripcion");
            }

        } catch (Exception e) {
            System.err.println("Error al consultar la descripción de la pregunta : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return namep;
    }
}
