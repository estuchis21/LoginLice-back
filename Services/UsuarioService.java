package gestiontusanatorio.back.Services;

import gestiontusanatorio.back.Models.Usuarios;
import gestiontusanatorio.back.AccesoDb.UsuarioRepository;

/**
 *
 * @author Esteban
 */
public class UsuarioService {

    private UsuarioRepository userRepo = new UsuarioRepository();

    public boolean registro(Usuarios users) {
        try {
            return userRepo.registrar(users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Usuarios login(String username, String password) {
        try {
            return userRepo.loguearse(username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
