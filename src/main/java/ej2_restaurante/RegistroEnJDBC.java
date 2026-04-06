package ej2_restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroEnJDBC implements RegistroTotal {
    private String url = "jdbc:mysql://localhost:3306/ejercicios_objetos";
    private String user = "root";
    private String password = "12345678";


    @Override
    public void GuardarCuenta(double costoTotal) {
        String sql = "INSERT INTO registro_ventas (fecha, costoTotal) VALUES (?, ?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, dtf.format(now));
            stmt.setDouble(2, costoTotal);

            stmt.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException("Error al registrar una venta", e);
        }
    }
}
