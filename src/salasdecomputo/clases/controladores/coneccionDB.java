/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aser
 */
public class coneccionDB {
    
    public static Connection conectarDB(){
        try{
            String url = "jdbc:mysql://localhost:3306/salas_computo";
            String user = "root";
            String pasw = "";
            
            Connection con = DriverManager.getConnection(url, user, pasw);
            System.out.println("coneccion con la DB exitosa");
            
            return con;
                    
        }catch(SQLException e){
            System.out.println("errror en la coneccion de la DB");
            return null;
        }
    }
    
}
