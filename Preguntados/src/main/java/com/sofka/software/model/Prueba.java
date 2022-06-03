package com.sofka.software.model;

import com.sofka.software.conexion.base.datos.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Prueba {
    private PreparedStatement ps=null;
    private ResultSet res;
    private final String sql_consult = "SELECT * FROM tbjugador WHERE id=(SELECT max(id) FROM tbjugador)";
    public void consultarDatos(Conexion con){
        try {
        ps = con.crearConexion().prepareStatement(sql_consult);
        res = ps.executeQuery();
        System.out.println(res);
            while (res.next()) {
                System.out.println(res.getInt("id"));
                System.out.println(res.getString("nombre"));
                System.out.println(res.getInt("puntajeTotal"));
            }
        }catch (Exception e) {
            System.err.println("Error al guardar los datos del jugador : " + e.getMessage());
        }
    }
}
