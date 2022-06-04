package com.sofka.software.model;

import com.sofka.software.conexion.base.datos.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Question {
    Logger log = Logger.getLogger("log");
    private PreparedStatement ps;
    private final Conexion con;
    private ResultSet res;

    public Question() {
        ps = null;
        con = new Conexion();
    }

    public int queryQuestionCat(int idCategory) {
        int idQuestion = 0;
        ArrayList<Integer> lista = new ArrayList<>();
        try {
            String sqlSelectPreg = "SELECT * FROM tbpregunta WHERE idcategoria = ?";
            ps = con.crearConexion().prepareStatement(sqlSelectPreg);
            ps.setInt(1, idCategory);
            res = ps.executeQuery();//ejecuta la consulta
            while (res.next()) {
                lista.add(res.getInt("id"));
            }
            idQuestion = lista.get(new Random().nextInt(lista.size()));

        } catch (Exception e) {
            log.info("Error al consulta ID de la pregunta : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return idQuestion;
    }

    public String queryQuestionTex(int idQuestion) {
        String namep = "";
        try {
            String sqlSelectNomPreg = "SELECT * FROM tbpregunta WHERE id = ?";
            ps = con.crearConexion().prepareStatement(sqlSelectNomPreg); //crea conexion y prepara la consulta
            ps.setInt(1, idQuestion);
            res = ps.executeQuery();
            while (res.next()) {
                namep = res.getString("descripcion");
            }

        } catch (Exception e) {
            log.info("Error al consultar la descripción de la pregunta : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return namep;
    }
}
