package com.sofka.software.model;

import java.sql.PreparedStatement;
import com.sofka.software.conexion.base.datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Category {

    private final String sql_select = "SELECT * FROM tbcategoria ";
    private final String sql_selectCat = "SELECT * FROM tbcategoria WHERE id = ?";
    private PreparedStatement ps;
    private Conexion con;
    private ResultSet res;


    public Category() {
        ps = null;
        con = new Conexion();
    }

    public ArrayList<Integer> queryData() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        try {
            ps = con.crearConexion().prepareStatement(sql_select);
            res = ps.executeQuery();
            while (res.next()) {
                lista.add(res.getInt("id"));
            }

        } catch (Exception e) {
            System.err.println("Error al consultar el ID de categoria : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return lista;
    }

    public String queryCategory(int id) {
        String name = "";
        try {
            ps = con.crearConexion().prepareStatement(sql_selectCat);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while (res.next()) {
                name = res.getString("nombre");
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el nombre de la categoria : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }

        return name;
    }

    public String queryLevel(int id) {
        String level = "";
        try {
            ps = con.crearConexion().prepareStatement(sql_selectCat);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while (res.next()) {
                level = res.getString("nivel");
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el nivel de la categoria : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }

        return level;
    }
}
