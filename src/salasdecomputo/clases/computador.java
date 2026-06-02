/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

/**
 *
 * @author aser
 */
public class computador {
    
    private int id;
    private String especificaciones;
    private int salaPerteneciente;

    public computador(int id, String especificaciones, int salaPerteneciente) {
        this.id = id;
        this.especificaciones = especificaciones;
        this.salaPerteneciente = salaPerteneciente;
    }

    //inicio getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public int getSalaPerteneciente() {
        return salaPerteneciente;
    }

    public void setSalaPerteneciente(int salaPerteneciente) {
        this.salaPerteneciente = salaPerteneciente;
    }
    //fin getter y setter
    
}
