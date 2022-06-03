package com.sofka.software.model;

public class Player extends Person{
    public void saveScore(int idPlayer, int score) {
        try {
            ps = con.crearConexion().prepareStatement(sql_update);
            ps.setInt(1, score);
            ps.setInt(2, idPlayer);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al guardar puntaje del jugador : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
    }

    public String queryNomePlayer(int idPlayer) {
        String namePlayer = "";
        try {
            ps = con.crearConexion().prepareStatement(sql_selectJug);
            ps.setInt(1, idPlayer);
            res = ps.executeQuery();
            while (res.next()) {
                namePlayer = res.getString("nombre");
            }
        } catch (Exception e) {
            System.err.println("Error al consultar nombre del jugador : " + e.getMessage());
        } finally {
            ps = null;
            con.close();
        }
        return namePlayer;
    }
}
