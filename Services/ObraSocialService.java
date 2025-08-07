package gestiontusanatorio.back.Services;

import gestiontusanatorio.back.AccesoDb.ObrasSocialesRepo;
import gestiontusanatorio.back.Models.Obras_sociales;

import java.util.List;

public class ObraSocialService {

    private ObrasSocialesRepo repo = new ObrasSocialesRepo();

    public List<Obras_sociales> obtenerObrasSociales() {
        return repo.obtenerObrasSociales();
    }
}
