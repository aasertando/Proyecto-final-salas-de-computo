/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

/**
 *
 * @author aser
 */
public class profesor {
    
    private int id;
    private String nombre;
    private String contraseña;
    private boolean activo;
    private String departamento;
    private int horaInicio;
    private int horaFin;

    public profesor(int id, String nombre, String contraseña, boolean activo, String departamento, int horaInicio, int horaFin) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.activo = activo;
        this.departamento = departamento;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }
    //fin getter y setter
}
