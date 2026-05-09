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
    private String marca;
    private boolean disponible;

    public computador(String id, String marca, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.disponible = disponible;
    }
    
    //inicio getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    //fin getter y setter
}
