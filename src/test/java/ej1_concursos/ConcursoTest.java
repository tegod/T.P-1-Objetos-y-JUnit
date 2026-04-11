package ej1_concursos;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ConcursoTest {
    private Concurso concurso;
    private Participante participante;
    private FakeInscripcion participantesAnotados;
    private FakeMail mail;

    @BeforeEach
    public void setUp() {
        /* Linea para la creacion e insercion de participantes en un archivo de texto real
        Instant participantesAnotados = new InscripcionParticipantes("participantesAnotados.txt");
         */
        // aca se hace la creacion del fake
        participantesAnotados = new FakeInscripcion();
        mail = new FakeMail();
        concurso = new Concurso("Concurso pulseadas",
                LocalDate.now(),LocalDate.now().plusDays(3), participantesAnotados, mail);
        participante = new Participante(41995847,"Diego",
                "Ibañez", "diegotetobias@gmail.com");
    }

    @Test
    public void testInscripcionExitosa() {
        concurso.insertarParticipante(participante, LocalDate.now().plusDays(1));
        assertEquals(0, participante.devolverPuntuacion());
        // asserTrue corrobora si el valor devuelto es nulo o valido, concatenar en caso de que sean vinculantes.
        assertTrue(participantesAnotados.guardadoFalso);
        assertEquals(LocalDate.now().plusDays(1), participantesAnotados.fechaFake);
        assertEquals(41995847, participantesAnotados.id_ParticipanteFake);
        assertEquals(0, participantesAnotados.id_ConcursoFake);
    }

    @Test
    public void testInscripcionEnPrimerDia() {
        concurso.insertarParticipante(participante, LocalDate.now());
        assertEquals(10, participante.devolverPuntuacion());
        System.out.println(participante.devolverPuntuacion());
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