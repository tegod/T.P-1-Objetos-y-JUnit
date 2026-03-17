package ej1_concursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private LocalDate fechaInicInscripcion, fechaFinInscripcion;
    private List<Participante> participantes;

    public Concurso(String nombre, LocalDate fechaInicInscripcion, LocalDate fechaFinInscripcion) {
        this.nombre = nombre;
        this.fechaInicInscripcion = fechaInicInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.participantes = new ArrayList<>();
    }

    public void verificarFueraDeFecha(LocalDate fechaActual) {
        if (fechaActual.isAfter(fechaFinInscripcion) || fechaActual.isBefore(fechaInicInscripcion)) {
            throw new RuntimeException("Inscripcion fuera de fecha, no se pudo realizar");
        }
    }

    public void insertarParticipante(Participante participante, LocalDate fechaActual) {
        /* Esta linea debe de ser eliminada de forma temporal en pos de realizar los test
        LocalDate fechaActual =  LocalDate.now();
         */
        verificarFueraDeFecha(fechaActual);

        if (fechaActual.isEqual(fechaInicInscripcion)) {
            participante.sumarPuntos(10);
        }
        this.participantes.add(participante);
    }
}