package gestiontusanatorio.back.AccesoDb;

import gestiontusanatorio.back.ConnectionDB;
import gestiontusanatorio.back.Models.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {

    public List<Medico> obtenerMedicos() {
        List<Medico> medicos = new ArrayList<>();

        String sql = "SELECT m.id_medico, u.nombres, u.apellido " +
             "FROM Medicos m " +
             "JOIN Usuarios u ON m.id_usuario = u.id_usuario";


        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idMedico = rs.getInt("id_medico");
                String nombreCompleto = rs.getString("nombres") + " " + rs.getString("apellido");

                medicos.add(new Medico(idMedico, nombreCompleto));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener médicos: " + e.getMessage());
        }

        return medicos;
    }
}
