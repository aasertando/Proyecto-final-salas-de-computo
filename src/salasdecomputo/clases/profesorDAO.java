/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;
import java.sql.*;
import salasdecomputo.clases.controladores.coneccionDB;

/**
 *
 * @author aser
 */
public class profesorDAO {
    
    //si regresa null los credenciales ingresados son invalidos
    public static profesor buscarProfesor(String usr, String pass){
        
        Connection con = coneccionDB.conectarDB();
        
        try{
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM profesor WHERE nombre = ? AND contraseña = ?");
            ps.setString(1, usr);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
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
            
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("errror\n------------------------------------");
            System.out.println(e);
        }
        return null;
    }
}
