/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

/**
 *
 * @author aser
 */
public class portatil {
    
    private int idComputador;
    private String especificaciones;
    private boolean disponible;

    public portatil(int idComputador, String especificaciones, boolean disponible) {
        this.idComputador = idComputador;
        this.especificaciones = especificaciones;
        this.disponible = disponible;
    }

    //inicio getter y setter
    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    //fin getter y setter    
    
}
