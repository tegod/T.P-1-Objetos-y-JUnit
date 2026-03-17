package ej1_concursos;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ConcursoTest {
    private Concurso concurso;
    private Participante participante;

    @BeforeEach
    public void setUp() {
        concurso = new Concurso("Concurso pulseadas", LocalDate.now(),LocalDate.now().plusDays(3));
        participante = new Participante("Diego", "Ibañez");
    }

    @Test
    public void testInscripcionExitosa() {
        concurso.insertarParticipante(participante, LocalDate.now().plusDays(1));
        assertEquals(0, participante.getPuntuacion());
    }

    @Test
    public void testInscripcionEnPrimerDia() {
        concurso.insertarParticipante(participante, LocalDate.now());
        assertEquals(10, participante.getPuntuacion());
        participante.mostrarPuntos();
    }

    @Test
    public void testInscripcionFallidaDespues() {
        Exception falloInscripcion = assertThrows(RuntimeException.class, () -> {
            concurso.insertarParticipante(participante, LocalDate.now().plusDays(5));
        });
        assertEquals("Inscripcion fuera de fecha, no se pudo realizar",falloInscripcion.getMessage());
    }

    @Test
    public void testInscripcionFallidaAntes() {
        Exception falloInscripcion = assertThrows(RuntimeException.class, () -> {
            concurso.insertarParticipante(participante, LocalDate.now().plusDays(-2));
        });
        assertEquals("Inscripcion fuera de fecha, no se pudo realizar",falloInscripcion.getMessage());
    }
}