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
public class salaDAO {
    
    public static boolean ingresarSala(String nombre, int capacidad) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO salas (nombre, capacidad) VALUES (?, ?)");
            ps.setString(1, nombre);
            ps.setInt(2, capacidad);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }

    }

    public static boolean eliminarSala(int id) {
        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("DELETE  FROM salas WHERE idSala= ?");
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

    public static ArrayList<sala> obtenerSalas(){
        
        ArrayList<sala> lista = new ArrayList<>();
        
        Connection con = coneccionDB.conectarDB();
        
        try{
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM salas");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("idSala");
                String nombre = rs.getString("nombre");
                int capacidad = rs.getInt("capacidad");
                
                sala s = new sala(id, nombre, capacidad);
                
                lista.add(s);
                
            }
            
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
        }
        return lista;
    }
    
    public static boolean actualizarSala(int id, String nombre, int capacidad){
        
        Connection con = coneccionDB.conectarDB();
        
        try{
            
            PreparedStatement ps = con.prepareStatement("UPDATE salas SET nombre = ?, capacidad = ? WHERE idSala = ?");
            
            ps.setString(1, nombre);
            ps.setInt(2, capacidad);
            ps.setInt(3, id);

            ps.executeUpdate();
            
            return true;
            
        }catch(SQLException e){
            System.out.println("error");
            System.out.println(e);
            return false;
        }
        
    }
    
}
