package gestiontusanatorio.back.Services;

import gestiontusanatorio.back.AccesoDb.ObrasSocialesRepo;
import gestiontusanatorio.back.AccesoDb.TurnosRepository;
import gestiontusanatorio.back.Models.Obras_sociales;
import gestiontusanatorio.back.Models.TurnosAsignados;
import gestiontusanatorio.back.Models.TurnosDisponibles;
import java.util.List;

public class TurnosService {

    private TurnosRepository turnosRepo = new TurnosRepository();
    private ObrasSocialesRepo obrasSociales = new ObrasSocialesRepo();

    public List<TurnosDisponibles> obtenerTurnosDisponiblesNoAsignados() {
        return turnosRepo.obtenerTodosLosTurnosDisponibles();
    }

    public boolean asignarTurno(int idTurnoDisponible, int idPaciente, int idObraSocial) {
        return turnosRepo.asignarTurno(idTurnoDisponible, idPaciente, idObraSocial);
    }

    public boolean estaTurnoAsignado(int idTurno) {
        return turnosRepo.estaTurnoAsignado(idTurno);
    }
    
    public boolean turnoDisponiblePorId(int idTurno) {
        return turnosRepo.obtenerTurnoDisponiblePorId(idTurno);
    }

    public List<Obras_sociales> getObrasSociales() {
        return obrasSociales.obtenerObrasSociales();
    }
    
    public List<TurnosAsignados> getTurnosPorPaciente(int idPaciente) {
        return turnosRepo.obtenerTurnosPorPaciente(idPaciente);
    }
}

