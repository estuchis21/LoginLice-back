package gestiontusanatorio.back.AccesoDb;

import gestiontusanatorio.back.ConnectionDB;
import gestiontusanatorio.LoginLice.back.Models.Usuarios;

import java.sql.*;

public class UsuarioRepository {
   
    public boolean existeUsuarioPorUsername(int dni, String username, String email) {
        String sql = "{call EXISTENTE(?, ?, ?)}"; // Stored Procedure que verifica existencia
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, dni);
            cs.setString(2, username);
            cs.setString(3, email);

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1); // SP devuelve COUNT(*)
                return count > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de usuario: " + e.getMessage());
        }
        return false;
    }

    public boolean registrar(Usuarios user) {
        // Validaciones básicas
        if (user.getDni() == 0 ||
            user.getNombres() == null || user.getNombres().isEmpty() ||
            user.getApellido() == null || user.getApellido().isEmpty() ||
            user.getEmail() == null || user.getEmail().isEmpty() ||
            user.getUsername() == null || user.getUsername().isEmpty() ||
            user.getContrasena() == null || user.getContrasena().isEmpty() ||
            user.getTelefono() == null || user.getTelefono().isEmpty() ||
            user.getIdRol() == 0) {
            System.err.println("Faltan datos obligatorios para el registro.");
            return false;
        }

        // Validar especialidad solo para médicos (idRol == 2)
        if (user.getIdRol() == 2 && (user.getIdEspecialidad() == null || user.getIdEspecialidad() == 0)) {
            System.err.println("Debe seleccionar una especialidad para médicos.");
            return false;
        }

        // Verificar si el usuario ya existe
        if (existeUsuarioPorUsername(user.getDni(), user.getUsername(), user.getEmail())) {
            System.err.println("El usuario ya existe");
            return false;
        }

        // Ejecutar el stored procedure
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call insertarUsuario(?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {

            stmt.setInt(1, user.getDni());
            stmt.setString(2, user.getNombres());
            stmt.setString(3, user.getApellido());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getUsername());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getContrasena());
            stmt.setInt(8, user.getIdRol());

            if (user.getIdRol() == 2) {
                stmt.setInt(9, user.getIdEspecialidad());
            } else {
                stmt.setNull(9, Types.INTEGER);
            }

            stmt.execute();

            System.out.println("Usuario registrado exitosamente.");
            return true;

        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean loguearse(String username, String contrasena) {
        String sql = "{call getUserByUsername(?)}";

        if (username.isBlank() || contrasena.isBlank()) {
            System.out.println("No pueden haber datos vacíos.");
            return false;
        }

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, username);
            try (ResultSet rs = cs.executeQuery()) {

                if (!rs.next()) {
                    System.out.println("No existe un usuario con ese nombre.");
                    return false;
                }

                String storedPassword = rs.getString("contrasena");

                if (storedPassword.equals(contrasena)) {
                    System.out.println("Login exitoso.");
                    return true;
                } else {
                    System.out.println("Contraseña incorrecta.");
                    return false;
                }
            }

        } catch (Exception e) {
            System.out.println("Error al loguear: " + e.getMessage());
            return false;
        }
    }

}
