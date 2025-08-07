/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontusanatorio.back.Services;

/**
 *
 * @author Esteban
 */

import gestiontusanatorio.back.Models.Medico;
import gestiontusanatorio.back.AccesoDb.MedicoRepository;

import java.util.List;

public class MedicoService {

    private MedicoRepository medicoRepo = new MedicoRepository();

    public List<Medico> obtenerMedicos() {
        return medicoRepo.obtenerMedicos();
    }
}
