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
    
    private String id;
    private String descripcion;
    private int salaPerteneciente;

    public computador(String id, String descripcion, int salaPerteneciente) {
        this.id = id;
        this.descripcion = descripcion;
        this.salaPerteneciente = salaPerteneciente;
    }

    //inicio getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSalaPerteneciente() {
        return salaPerteneciente;
    }

    public void setSalaPerteneciente(int salaPerteneciente) {
        this.salaPerteneciente = salaPerteneciente;
    }
    //fin getter y setter
    
}
