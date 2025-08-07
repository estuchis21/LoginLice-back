package gestiontusanatorio.back.AccesoDb;

import gestiontusanatorio.back.ConnectionDB;
import gestiontusanatorio.back.Models.TurnosAsignados;
import gestiontusanatorio.back.Models.TurnosDisponibles;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TurnosRepository {

    // Método para obtener solo turnos disponibles que NO estén asignados
    public List<TurnosDisponibles> obtenerTodosLosTurnosDisponibles() {
        List<TurnosDisponibles> lista = new ArrayList<>();
        String sql = "SELECT id_turno, id_medico, id_rango, fecha_turno FROM Turnos_disponibles ORDER BY fecha_turno ASC";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idTurno = rs.getInt("id_turno"); // nombre correcto de la columna
                int idMedico = rs.getInt("id_medico");
                int idRango = rs.getInt("id_rango");
                Date fechaTurno = rs.getDate("fecha_turno");

                TurnosDisponibles turno = new TurnosDisponibles(idTurno, idMedico, idRango, fechaTurno.toLocalDate());
                lista.add(turno);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener turnos disponibles no asignados: " + e.getMessage());
        }

        return lista;
    }


    // Nuevo método para validar si un turno está asignado (más simple)
    public boolean estaTurnoAsignado(int idTurno) {
        String sql = "SELECT 1 FROM Turnos_asignados WHERE id_turno = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idTurno);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Si hay registro, está asignado
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar si turno está asignado: " + e.getMessage());
        }
        return false;
    }

    // Método corregido para asignar turno
    public boolean asignarTurno(int id_turno_disponible, int id_paciente, int id_obra_social) {
        if (id_turno_disponible == 0 || id_paciente == 0 || id_obra_social == 0) {
            System.err.println("Faltan datos obligatorios para asignar el turno");
            return false;
        }

        // Validar si ya está asignado
        if (estaTurnoAsignado(id_turno_disponible)) {
            System.err.println("El turno ya está asignado: id_turno " + id_turno_disponible);
            return false;
        }

        // Validar si el turno está disponible
        if (!obtenerTurnoDisponiblePorId(id_turno_disponible)) {
            System.err.println("El turno no está disponible: id_turno " + id_turno_disponible);
            return false;
        }

        String sql = "{CALL AsignarTurno(?, ?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id_turno_disponible);
            cs.setInt(2, id_paciente);
            cs.setInt(3, id_obra_social);

            cs.execute(); // Ejecuta el stored procedure

            System.out.println("Turno asignado correctamente: id_turno " + id_turno_disponible);
            return true;

        } catch (SQLException e) {
            System.err.println("Error al asignar turno: " + e.getMessage());
        }

        return false;
    }

    // Este método queda igual para validar turno disponible
    public boolean obtenerTurnoDisponiblePorId(int idTurno) {
        String sql = "{CALL TurnoDisponibleCheck(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, idTurno);
            try (ResultSet rs = cs.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar turno disponible: " + e.getMessage());
        }

        return false;
    }
    
    public List<TurnosAsignados> obtenerTurnosPorPaciente(int idPaciente) {
        List<TurnosAsignados> lista = new ArrayList<>();
        String sql = "SELECT id_turno, id_paciente, id_obra_social, fecha_asignacion FROM Turnos_asignados WHERE id_paciente = ? ORDER BY fecha_asignacion DESC";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPaciente);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idTurno = rs.getInt("id_turno");
                    int idPac = rs.getInt("id_paciente");
                    int idObra = rs.getInt("id_obra_social");

                    Timestamp timestamp = rs.getTimestamp("fecha_asignacion");
                    String fechaAsignacionStr = "";
                    if (timestamp != null) {
                        fechaAsignacionStr = timestamp.toLocalDateTime().format(formatter);
                    }

                    TurnosAsignados turno = new TurnosAsignados(idTurno, idPac, idObra, fechaAsignacionStr);
                    lista.add(turno);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener turnos asignados: " + e.getMessage());
        }

        return lista;
    }
    
}
