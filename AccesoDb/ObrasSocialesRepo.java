package gestiontusanatorio.back.AccesoDb;

import gestiontusanatorio.back.ConnectionDB;
import gestiontusanatorio.back.Models.Obras_sociales;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObrasSocialesRepo {

    // Método correcto para obtener todas las obras sociales
    public List<Obras_sociales> obtenerObrasSociales() {
        List<Obras_sociales> lista = new ArrayList<>();

        String sql = "SELECT id_obra_social, obra_social FROM Obras_sociales ORDER BY obra_social";

        try (java.sql.Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_obra_social");
                String nombre = rs.getString("obra_social");
                lista.add(new Obras_sociales(id, nombre));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener obras sociales: " + e.getMessage());
        }

        return lista;
    }
}
