/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

/**
 *
 * @author aser
 */
public class estudiante {
    
    private int id;
    private String nombre;
    private String contraseña;
    private boolean activo;
    private String carrera;

    public estudiante(int id, String nombre, String contraseña, boolean activo, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.activo = activo;
        this.carrera = carrera;
    }

    //inicio getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    //fin getter y setter

}
