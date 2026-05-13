/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

import salasdecomputo.clases.controladores.coneccionDB;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author aser
 */
public class estudianteDAO {

    //si regresa null los credenciales ingresados son invalidos
    public static estudiante buscarEstudiante(String usr, String pass) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT *  FROM estudiantes WHERE nombre = ? AND contraseña = ?");
            ps.setString(1, usr);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("idEstudiante");
                String nombre = rs.getString("nombre");
                String contraseña = rs.getString("contraseña");
                boolean activo = rs.getBoolean("activo");
                String carrera = rs.getString("carrera");

                estudiante e = new estudiante(id, nombre, contraseña, activo, carrera);
                return e;

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errror\n------------------------------------");
            System.out.println(e);
        }

        //si no se encontró
        return null;
    }

    public static boolean ingresarEstudiante(String nombre, String contraseña, String carrera) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO estudiantes (nombre, contraseña, activo, carrera) VALUES (?, ?, true, ?)");
            ps.setString(1, nombre);
            ps.setString(2, contraseña);
            ps.setString(3, carrera);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }

    }

    public static boolean eliminarEstudiante(int id) {
        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("DELETE  FROM estudiantes WHERE idEstudiante = ?");
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

    public static ArrayList<estudiante> obtenerEstudiantes(){
        
        ArrayList<estudiante> lista = new ArrayList<>();
        
        Connection con = coneccionDB.conectarDB();
        
        try{
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM estudiantes");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("idEstudiante");
                String nombre = rs.getString("nombre");
                String contraseña = rs.getString("contraseña");
                boolean activo = rs.getBoolean("activo");
                String carrera = rs.getString("carrera");
                
                estudiante e = new estudiante(id, nombre, contraseña, activo, carrera);
                
                lista.add(e);
                
            }
            
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
        }
        return lista;
    }
    
    public static boolean actualizarEstudiante(int id, String nombre, String contraseña, boolean activo, String carrera){
        
        Connection con = coneccionDB.conectarDB();
        
        try{
            
            PreparedStatement ps = con.prepareStatement("UPDATE estudiantes SET nombre = ?, contraseña = ?, activo = ?, carrera = ? WHERE idEstudiante = ?");
            
            ps.setString(1, nombre);
            ps.setString(2, contraseña);
            ps.setBoolean(3, activo);
            ps.setString(4, carrera);
            ps.setInt(5, id);
            
            ps.executeUpdate();
            
            return true;
            
        }catch(SQLException e){
            System.out.println("error");
            System.out.println(e);
            return false;
        }
        
    }
    
    
    
    
}
