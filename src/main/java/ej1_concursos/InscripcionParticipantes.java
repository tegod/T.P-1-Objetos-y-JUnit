package ej1_concursos;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InscripcionParticipantes implements Inscripciones {
    private String ubicacionDeArchivo;

    public InscripcionParticipantes(String ubicacionDeArchivo) { this.ubicacionDeArchivo = ubicacionDeArchivo; }


    @Override
    public void anotarInscripcion(LocalDate fecha, int id_Participante, int id_Concurso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (FileWriter writer = new FileWriter(this.ubicacionDeArchivo, true)) {
            writer.write(fecha.format(formatter) + ", " + id_Participante + ", " + id_Concurso + "\n");
        }catch(IOException e){
            throw new RuntimeException("Error al anotar la inscripcion: " + e.getMessage());
        }
    }
}
