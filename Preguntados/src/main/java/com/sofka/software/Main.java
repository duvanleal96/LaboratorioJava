package com.sofka.software;

import com.sofka.software.interfazconexion.Conexion;
import com.sofka.software.model.Prueba;

import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.crearConexion();
        Prueba p = new Prueba();
        p.consultarDatos(con);

    }
}