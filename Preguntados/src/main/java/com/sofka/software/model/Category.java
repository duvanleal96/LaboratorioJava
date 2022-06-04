package com.sofka.software.model;

import java.sql.PreparedStatement;
import com.sofka.software.conexion.base.datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * clase categoria , implementa las consulras
 */

public class Category {
    Logger log = Logger.getLogger("log");
    private final String sqlSelect = "SELECT * FROM tbcategoria ";
    private final String sqlSelectCat = "SELECT * FROM tbcategoria WHERE id = ?";
    private PreparedStatement ps;
    private final Conexion con;
    private ResultSet res;


    public Category() {
        ps = null;
        con = new Conexion();
    }

    public ArrayList<Integer> queryData() {
        ArrayList<Integer> lista = new ArrayList<>();
        try {
            ps = con.crearConexion().prepareStatement(sqlSelect);
            res = ps.executeQuery();
            while (res.next()) {
                lista.add(res.getInt("id"));
            }

        } catch (Exception e) {
            log.info("Error al consultar el ID de categoria : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return lista;
    }

    /**
     * consultar categoria , llama a la consulta de categoria de la BD y la almacena en
     * la variable nombre
     * @return name
     */
    public String queryCategory(int id) {
        String name = "";
        try {
            ps = con.crearConexion().prepareStatement(sqlSelectCat);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while (res.next()) {
                name = res.getString("nombre");
            }
        } catch (Exception e) {
            log.info("Error al consultar el nombre de la categoria : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }

        return name;
    }

    /**
     * metodo consultar nivel , consulta en nivel en la BD y verifica el estado del nivel actial
     * @return level
     */

    public String queryLevel(int id) {
        String level = "";
        try {
            ps = con.crearConexion().prepareStatement(sqlSelectCat);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while (res.next()) {
                level = res.getString("nivel");
            }
        } catch (Exception e) {
            log.info("Error al consultar el nivel de la categoria : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }

        return level;
    }
}
