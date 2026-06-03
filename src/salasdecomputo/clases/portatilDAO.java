/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import salasdecomputo.clases.controladores.coneccionDB;

/**
 *
 * @author aser
 */
public class portatilDAO {

    //si regresa null los credenciales ingresados son invalidos
    public static boolean ingresarPortatil(String especificaciones) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO portatiles (especificaciones, disponible) VALUES (?, true)");
            ps.setString(1, especificaciones);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }

    }

    public static boolean eliminarPortatil(int id) {
        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("DELETE  FROM portatiles WHERE idPortatil= ?");
            ps.setInt(1, id);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    public static ArrayList<portatil> obtenerPortatiles() {

        ArrayList<portatil> lista = new ArrayList<>();

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM portatiles");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPortatil = rs.getInt("idPortatil");
                String especificaciones = rs.getString("especificaciones");
                boolean disponible = rs.getBoolean("disponible");

                portatil po = new portatil(idPortatil, especificaciones, disponible);

                lista.add(po);

            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
        }
        return lista;
    }

    public static boolean actualizarPortatil(int id, String especificaciones, boolean disponible) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE portatiles SET especificaciones= ?, disponible = ? WHERE idPortatil = ?");

            ps.setString(1, especificaciones);
            ps.setBoolean(2, disponible);
            ps.setInt(3, id);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e);
            return false;
        }

    }

    public static ArrayList<portatil> obtenerPortatilesDisponibles() {

        ArrayList<portatil> lista = new ArrayList<>();

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM portatiles WHERE disponible = true");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idPortatil");
                String especificaciones = rs.getString("especificaciones");
                boolean disponible = rs.getBoolean("disponible");

                portatil p = new portatil(id, especificaciones, disponible);
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
        }

        return lista;
    }

}
