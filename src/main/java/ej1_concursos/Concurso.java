package ej1_concursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private final int id_concurso;
    private final String nombre;
    private LocalDate fechaInicInscripcion, fechaFinInscripcion;
    private List<Participante> participantes;
    private Inscripciones inscripciones;
    private static int contadorID;
    private Notificar notificar;

    public Concurso(String nombre, LocalDate fechaInicInscripcion, LocalDate fechaFinInscripcion, Inscripciones inscripciones, Notificar notificar) {
        this.id_concurso = contadorID++;
        this.nombre = nombre;
        this.fechaInicInscripcion = fechaInicInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.participantes = new ArrayList<>();
        this.inscripciones = inscripciones;
        this.notificar = notificar;
    }

    public void verificarFueraDeFecha(LocalDate fechaActual) {
        if (fechaActual.isAfter(fechaFinInscripcion) || fechaActual.isBefore(fechaInicInscripcion)) {
            throw new RuntimeException("Inscripcion fuera de fecha, no se pudo realizar");
        }
    }

    //consultar con el profe como se puede mejorar esta seccion.
    public void insertarParticipante(Participante participante, LocalDate fechaActual) {
        /* Esta linea debe de ser eliminada de forma temporal en pos de realizar los test
        LocalDate fechaActual =  LocalDate.now();
         */
        verificarFueraDeFecha(fechaActual);

        if (fechaActual.isEqual(fechaInicInscripcion)) {
            participante.sumarPuntos(10);
        }

        //acceso a la base aca?
        this.inscripciones.anotarInscripcion(fechaActual, participante.obtenerDniDeParticipante(),
                this.id_concurso);
        notificarInscripcion(participante.pasarEmail());
    }

    public void notificarInscripcion(String contacto) {
        this.notificar.enviarMail(contacto, "Inscripcion a " + this.nombre,
                "Participante inscripto correctamente al ¿" + this.nombre);
    }
}