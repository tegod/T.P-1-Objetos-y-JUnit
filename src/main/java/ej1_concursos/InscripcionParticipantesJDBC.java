package ej1_concursos;

import ej2_restaurante.RegistroTotal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InscripcionParticipantesJDBC implements Inscripciones {
    private String url = "jdbc:mysql://localhost:3306/ejercicios_objetos";
    private String user = "root";
    private String password = "12345678";

    @Override
    public void anotarInscripcion(LocalDate date, int id_Participante, int id_Concurso) {
        String sql = "INSERT INTO inscripciones (fecha, DNI, id_concurso) VALUES (?, ?, ?)";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, formatter.format(date));
            stmt.setInt(2, id_Participante);
            stmt.setInt(3, id_Concurso);

            stmt.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException("Error al registrar un participante", e);
        }
    }
}
