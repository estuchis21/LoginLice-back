package gestiontusanatorio.back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=tuSanatorio;encrypt=true;trustServerCertificate=true";
    private static final String USER = "estuchis";
    private static final String PASSWORD = "F.1.atyUmika";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Conexión exitosa a SQL Server.");
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
