/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontusanatorio.back.Models;

import java.time.LocalDate;

/**
 *
 * @author Esteban
 */
public class TurnosAsignados {
    private int idTurno;
    private int idPaciente;
    private int idObraSocial;
    private String fechaAsignacion;  // guardamos como String formateado

    public TurnosAsignados(int idTurno, int idPaciente, int idObraSocial, String fechaAsignacion) {
        this.idTurno = idTurno;
        this.idPaciente = idPaciente;
        this.idObraSocial = idObraSocial;
        this.fechaAsignacion = fechaAsignacion;
    }

    // getters y setters

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }
    
    

    // otros getters/setters

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }
}
