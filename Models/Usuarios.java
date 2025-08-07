/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontusanatorio.back.Models;

/**
 *
 * @author Esteban
 */
public class Usuarios {
    private int dni;
    private String nombres;
    private String apellido;
    private String email;
    private String username;
    private String contrasena;
    private String telefono;
    private int idRol;
    private Integer idEspecialidad = null;
    
    private Integer idPaciente = null;
    private Integer idMedico = null;

    public Usuarios() {}

    public Usuarios(int dni, String nombres, String apellido, String email, String username, String contrasena, String telefono, int idRol, Integer idEspecialidad) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.idRol = idRol;
        this.idEspecialidad = idEspecialidad;
    }

    // Getters y setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
    
    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
}
