package com.sofka.software.conexion.base.datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexion {
    Logger log =Logger.getLogger(Conexion.class.getName());
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/concurso1";
    String driver = "com.mysql.cj.jdbc.Driver";
    String usuario = "root";
    String clave = "";

    public Connection crearConexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return conn;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            log.info("Error al cerrar la BD");
        }
    }
}
