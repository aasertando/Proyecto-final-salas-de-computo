/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salasdecomputo.clases.controladores;
import salasdecomputo.clases.controladores.coneccionDB;
import salasdecomputo.vistas.vistaLogin;
import salasdecomputo.vistas.vistaPrograma;

/**
 *
 * @author aser
 */
public class SalasDeComputo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        vistaLogin ventana = new vistaLogin();
        ventana.setVisible(true);
        
//        coneccionDB claseDB = new coneccionDB();
//        claseDB.conectarDB();
//        
        coneccionDB.conectarDB();
        
    }
    
}
