/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontusanatorio.back.Services;
import gestiontusanatorio.LoginLice.back.Models.Usuarios;
import gestiontusanatorio.back.AccesoDb.UsuarioRepository;

/**
 *
 * @author Esteban
 */
public class UsuarioService {
    
     private UsuarioRepository userRepo = new UsuarioRepository();
    
    public void registro(Usuarios users){
        try{
            userRepo.registrar(users);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }  
    }
    public void login(String username, String password){
        
        try{
            userRepo.loguearse(username, password);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        } 
        
    }
    
}
