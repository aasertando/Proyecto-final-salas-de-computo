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
public class computadorDAO {
    
    //si regresa null los credenciales ingresados son invalidos
    public static boolean ingresarComputador(String especificaciones, String salaPerteneciente) {

        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO computador (especificaciones, salaPerteneciente) VALUES (?, ?)");
            ps.setString(1, especificaciones);
            ps.setString(2, salaPerteneciente);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
            return false;
        }

    }

    public static boolean eliminarComputador(int id) {
        Connection con = coneccionDB.conectarDB();

        try {

            PreparedStatement ps = con.prepareStatement("DELETE  FROM computador WHERE idComputador= ?");
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

    public static ArrayList<computador> obtenerComputadores(){
        
        ArrayList<computador> lista = new ArrayList<>();
        
        Connection con = coneccionDB.conectarDB();
        
        try{
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM computador");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int idComputador = rs.getInt("idComputador");
                String especificaciones = rs.getString("especificaciones");
                int salaPerteneciente = rs.getInt("salaPerteneciente");
                
                computador c = new computador(idComputador, especificaciones, salaPerteneciente);
                
                lista.add(c);
                
            }
            
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("ERROR");
            System.out.println(e.getErrorCode());
        }
        return lista;
    }
    
    public static boolean actualizarComputador(int id, String especificaciones, int salaPerteneciente){
        
        Connection con = coneccionDB.conectarDB();
        
        try{
            
            PreparedStatement ps = con.prepareStatement("UPDATE computador SET especificaciones= ?, salaPerteneciente = ? WHERE idComputador = ?");
            
            ps.setString(1, especificaciones);
            ps.setInt(2, salaPerteneciente);
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
