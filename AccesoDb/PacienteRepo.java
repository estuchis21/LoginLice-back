package gestiontusanatorio.back.AccesoDb;

import gestiontusanatorio.back.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteRepo {

    public int obtenerIdObraSocialPaciente(int idPaciente) {
        int idObraSocial = 0;
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT TOP 1 id_obra_social FROM Turnos_asignados WHERE id_paciente = ? ORDER BY fecha_asignacion DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idObraSocial = rs.getInt("id_obra_social");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener obra social del paciente: " + e.getMessage());
        }

        return idObraSocial;
    }

}
