package com.sofka.software.model;

import com.sofka.software.conexion.base.datos.Conexion;
import com.sofka.software.interfazconexion.InterfacePerson;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class Person implements InterfacePerson {
      Logger log = Logger.getLogger("log");
      protected final String sql_insert = "INSERT INTO tbjugador (nombre,puntajeTotal) values (?,?)";
      protected final String sql_consult = "SELECT * FROM tbjugador WHERE id=(SELECT max(id) FROM tbjugador)";
      protected final String sql_update = "UPDATE tbjugador SET puntajeTotal=? WHERE id=?";
      protected final String sql_selectJug = "SELECT * FROM tbjugador WHERE id = ?";
      protected PreparedStatement ps;
      protected Conexion con;
      protected ResultSet res;

      public Person() {
            ps = null;
            con = new Conexion();

      }

      public int insertData(String nombre) {
            try {
                  ps = con.crearConexion().prepareStatement(sql_insert);
                  ps.setString(1, nombre);
                  ps.setInt(2, 0);
                  int resu = ps.executeUpdate();

                  if (resu > 0) {
                        JOptionPane.showMessageDialog(null, "El juego empezará !!");
                  }
            } catch (Exception e) {
                  log.info("Error al guardar los datos del jugador : " + e.getMessage());
            } finally {
                  ps = null;
                  con.close();
            }
            return 0;
      }

      /**
       * metodo consultar jugador , obtiene la consulta del id de jugador en la BD y la guarda en la una variable
       * @return idPlayer
       */
      public int queryPlayer() {
            int idPlayer = 0;
            try {
                  ps = con.crearConexion().prepareStatement(sql_consult);
                  res = ps.executeQuery();
                  while (res.next()) {
                        idPlayer = res.getInt("id");
                  }
            } catch (Exception e) {
                  log.info("Error al consultar id del jugador : " + e.getMessage());
            } finally {
                  ps = null;
                  con.close();
            }
            return idPlayer;
      }
}
