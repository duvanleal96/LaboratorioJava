package com.sofka.software.model;

import com.sofka.software.conexion.base.datos.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Record {
    private final String sql_insert = "INSERT INTO tbhistorial  (idjugador,puntaje,estado) values (?,?,?)";
    private final String sql_select = "SELECT * FROM tbhistorial";
    private final String sql_delete = "DELETE FROM tbhistorial  ";
    private PreparedStatement ps;
    private Conexion con;
    private ResultSet res;
    private Player jug;

    public Record() {
        ps = null;
        con = new Conexion();

    }

    public void insertRecord(int idPlayer, int score, String condition) {
        try {
            ps = con.crearConexion().prepareStatement(sql_insert);
            ps.setInt(1, idPlayer);
            ps.setInt(2, score);
            ps.setString(3, condition);
            int res = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al guardar los datos del jugador : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
    }

    public List<List<String>> mostrarHistorial() {
        jug = new Player();
        String nombre;
        List<List<String>> lista2 = new ArrayList<List<String>>();
        for (int i = 0; i <= 2; i++) {
            lista2.add(new ArrayList<String>());

        }
        try {
            ps = con.crearConexion().prepareStatement(sql_select);
            res = ps.executeQuery();
            while (res.next()) {
                nombre = jug.queryNomePlayer(res.getInt("idjugador"));
                lista2.get(0).add(nombre);
                lista2.get(1).add(String.valueOf(res.getInt("puntaje")));
                lista2.get(2).add(res.getString("estado"));

            }
        } catch (Exception e) {
            System.err.println("Error al mostrar los datos del historial : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return lista2;
    }
    public void deleteRecord(){
        try {
            ps = con.crearConexion().prepareStatement(sql_delete);
            int res = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar el historial : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
    }
}
