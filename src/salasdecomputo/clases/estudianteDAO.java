/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;
import salasdecomputo.clases.controladores.coneccionDB;
import java.sql.*;

/**
 *
 * @author aser
 */
public class estudianteDAO {
    
    //si regresa null los credenciales ingresados son invalidos
    public static estudiante  buscarEstudiante(String usr, String pass){
        

        Connection con = coneccionDB.conectarDB();
        
        try{

            PreparedStatement ps = con.prepareStatement("SELECT *  FROM estudiante WHERE usuario = ? AND contraseña = ?");
            ps.setString(1, usr);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
            
                int id = rs.getInt("idEstudiante");
                String nombre = rs.getString("nombre");
                String contraseña = rs.getString("contraseña");
                boolean activo = rs.getBoolean("activo");
                String carrera = rs.getString("carrera");
                
                estudiante e = new estudiante(id, nombre, contraseña, activo, carrera);
                return e;
                
        }
            
            } catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("errror\n------------------------------------");
                System.out.println(e);
            }
        
        //si no se encontró
        return null;
    }
}
