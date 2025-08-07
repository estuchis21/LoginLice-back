package gestiontusanatorio.back.Models;


import java.time.LocalDate;

public class TurnosDisponibles {
    private int idTurno;
    private int idMedico;
    private int idRango;
    private LocalDate fechaTurno;

    public TurnosDisponibles(int idTurno, int idMedico, int idRango, LocalDate fechaTurno) {
        this.idTurno = idTurno;
        this.idMedico = idMedico;
        this.idRango = idRango;
        this.fechaTurno = fechaTurno;
    }

    // Getters y setters

    public int getIdTurno() { return idTurno; }
    public int getIdMedico() { return idMedico; }
    public int getIdRango() { return idRango; }
    public LocalDate getFechaTurno() { return fechaTurno; }

    @Override
    public String toString() {
        return "Turno ID: " + idTurno + ", Médico ID: " + idMedico + ", Rango ID: " + idRango + ", Fecha: " + fechaTurno;
    }
}
