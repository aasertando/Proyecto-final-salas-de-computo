/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

import salasdecomputo.clases.controladores.coneccionDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author aser
 */
public class prestamoDAO {

    // Registrar que un estudiante presta un portátil
    public static boolean prestarPortatil(int idEstudiante, int idPortatil, int horaInicio, int horaFin) {

        Connection con = coneccionDB.conectarDB();

        try {

            // Primero verificamos que el portátil esté disponible
//            PreparedStatement psValidar = con.prepareStatement("SELECT disponible FROM portatiles WHERE idPortatil = ?");
//            psValidar.setInt(1, idPortatil);
//            ResultSet rs = psValidar.executeQuery();
//
//            if (rs.next()) {
//                boolean disponible = rs.getBoolean("disponible");
//                if (!disponible) {
//                    JOptionPane.showMessageDialog(null, "El portátil no está disponible");
//                    return false;
//                }
//            }
            // Registramos el préstamo
            PreparedStatement ps = con.prepareStatement("INSERT INTO prestamos (idUsuario, idRecurso, tipo, horaInicio, horaFin, estado) VALUES (?, ?, 'portatil', ?, ?, 'activo')");
            ps.setInt(1, idEstudiante);
            ps.setInt(2, idPortatil);
            ps.setInt(3, horaInicio);
            ps.setInt(4, horaFin);
            ps.executeUpdate();

            // Marcamos el portátil como no disponible
            PreparedStatement psActualizar = con.prepareStatement("UPDATE portatiles SET disponible = false WHERE idPortatil = ?");
            psActualizar.setInt(1, idPortatil);
            psActualizar.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    // Devolver un portátil (cambia estado del préstamo y libera el portátil)
    public static boolean devolverPortatil(int idPrestamo) {

        Connection con = coneccionDB.conectarDB();

        try {

            // Primero obtenemos el idRecurso (idPortatil) del préstamo
            PreparedStatement psObtener = con.prepareStatement("SELECT idRecurso FROM prestamos WHERE idPrestamo = ?");
            psObtener.setInt(1, idPrestamo);
            ResultSet rs = psObtener.executeQuery();

            if (rs.next()) {
                int idPortatil = rs.getInt("idRecurso");

                // Cambiamos el estado del préstamo a "devuelto"
                PreparedStatement ps = con.prepareStatement("UPDATE prestamos SET estado = 'devuelto' WHERE idPrestamo = ?");
                ps.setInt(1, idPrestamo);
                ps.executeUpdate();

                // Liberamos el portátil
                PreparedStatement psLiberar = con.prepareStatement("UPDATE portatiles SET disponible = true WHERE idPortatil = ?");
                psLiberar.setInt(1, idPortatil);
                psLiberar.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    // Obtener todos los préstamos activos de portátiles para mostrar en la JTable
    public static ArrayList<prestamo> obtenerPrestamosPortatiles() {

        ArrayList<prestamo> lista = new ArrayList<>();

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM prestamos WHERE tipo = 'portatil' AND estado = 'activo'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPrestamo = rs.getInt("idPrestamo");
                int idUsuario = rs.getInt("idUsuario");
                int idRecurso = rs.getInt("idRecurso");
                String tipo = rs.getString("tipo");
                int horaInicio = rs.getInt("horaInicio");
                int horaFin = rs.getInt("horaFin");
                String estado = rs.getString("estado");

                prestamo p = new prestamo(idPrestamo, idUsuario, idRecurso, tipo, horaInicio, horaFin, estado);
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
        }

        return lista;
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

    public static ArrayList<prestamo> obtenerPrestamosPortatilesEstudiante(int idEstudiante) {

        ArrayList<prestamo> lista = new ArrayList<>();

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM prestamos WHERE tipo = 'portatil' AND estado = 'activo' AND idUsuario = ?");
            ps.setInt(1, idEstudiante);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPrestamo = rs.getInt("idPrestamo");
                int idUsuario = rs.getInt("idUsuario");
                int idRecurso = rs.getInt("idRecurso");
                String tipo = rs.getString("tipo");
                int horaInicio = rs.getInt("horaInicio");
                int horaFin = rs.getInt("horaFin");
                String estado = rs.getString("estado");

                prestamo p = new prestamo(idPrestamo, idUsuario, idRecurso, tipo, horaInicio, horaFin, estado);
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
        }

        return lista;
    }

    public static boolean prestarSala(int idProfesor, int idSala, int horaInicio, int horaFin) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO prestamos (idUsuario, idRecurso, tipo, horaInicio, horaFin, estado) VALUES (?, ?, 'sala', ?, ?, 'activo')");
            ps.setInt(1, idProfesor);
            ps.setInt(2, idSala);
            ps.setInt(3, horaInicio);
            ps.setInt(4, horaFin);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    public static boolean devolverSala(int idPrestamo) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE prestamos SET estado = 'devuelto' WHERE idPrestamo = ?");
            ps.setInt(1, idPrestamo);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    public static ArrayList<prestamo> obtenerPrestamosSalasProfesor(int idProfesor) {

        ArrayList<prestamo> lista = new ArrayList<>();

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM prestamos WHERE tipo = 'sala' AND estado = 'activo' AND idUsuario = ?");
            ps.setInt(1, idProfesor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPrestamo = rs.getInt("idPrestamo");
                int idUsuario = rs.getInt("idUsuario");
                int idRecurso = rs.getInt("idRecurso");
                String tipo = rs.getString("tipo");
                int horaInicio = rs.getInt("horaInicio");
                int horaFin = rs.getInt("horaFin");
                String estado = rs.getString("estado");

                prestamo p = new prestamo(idPrestamo, idUsuario, idRecurso, tipo, horaInicio, horaFin, estado);
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
