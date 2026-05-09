/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salasdecomputo.clases;

/**
 *
 * @author aser
 */
public class prestamo {
    
    private int idPrestamo;
    private int idUsuario;
    private int idRecurso;
    private String tipo;
    private int horaInicio;
    private int horafin;
    private String estado;

    public prestamo(int idPrestamo, int idUsuario, int idRecurso, String tipo, int horaInicio, int horafin, String estado) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idRecurso = idRecurso;
        this.tipo = tipo;
        this.horaInicio = horaInicio;
        this.horafin = horafin;
        this.estado = estado;
    }

    //inicio getter y setter
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHorafin() {
        return horafin;
    }

    public void setHorafin(int horafin) {
        this.horafin = horafin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //fin getter y setter
}
