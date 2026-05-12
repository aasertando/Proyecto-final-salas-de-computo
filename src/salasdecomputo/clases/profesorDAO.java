/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

import java.sql.*;
import java.util.ArrayList;
import salasdecomputo.clases.controladores.coneccionDB;

/**
 *
 * @author aser
 */
public class profesorDAO {

    //si regresa null los credenciales ingresados son invalidos
    public static profesor buscarProfesor(String usr, String pass) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM profesor WHERE nombre = ? AND contraseña = ?");
            ps.setString(1, usr);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("idProfesor");
                String nombre = rs.getString("nombre");
                String contraseña = rs.getString("contraseña");
                boolean activo = rs.getBoolean("activo");
                String departamento = rs.getString("departamento");
                int horaInicio = rs.getInt("horaInicio");
                int horaFin = rs.getInt("horaFin");

                profesor p = new profesor(id, nombre, contraseña, activo, departamento, horaInicio, horaFin);
                return p;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errror\n------------------------------------");
            System.out.println(e);
        }
        return null;
    }

    public static boolean ingresarProfesor(String nombre, String contraseña, String departamento, int horaInicio, int horaFin) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO profesor (nombre, contraseña, activo, departamento, horaInicio, horaFin) VALUES (?, ?, true, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, contraseña);
            ps.setString(3, departamento);
            ps.setInt(4, horaInicio);
            ps.setInt(5, horaFin);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }

    }

    public static boolean eliminarProfesor(int id) {
        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("DELETE  FROM profesor WHERE idProfesor = ?");
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

    public static ArrayList<profesor> obtenerProfesores() {

        ArrayList<profesor> lista = new ArrayList<>();

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM profesor");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idProfesor");
                String nombre = rs.getString("nombre");
                String contraseña = rs.getString("contraseña");
                boolean activo = rs.getBoolean("activo");
                String departamento = rs.getString("departamento");
                int horaInicio = rs.getInt("horaInicio");
                int horaFin = rs.getInt("horaFin");

                profesor p = new profesor(id, nombre, contraseña, activo, departamento, horaInicio, horaFin);

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