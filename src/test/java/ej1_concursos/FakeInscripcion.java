package ej1_concursos;

import java.time.LocalDate;

public class FakeInscripcion implements Inscripciones{
    public boolean guardadoFalso = false;

    public LocalDate fechaFake;
    public int id_ParticipanteFake;
    public int id_ConcursoFake;

    @Override
    public void anotarInscripcion(LocalDate date, int id_Participante, int id_Concurso) {
        // corrobora que se haya accedido al metodo devolviendo true
        this.guardadoFalso = true;

        this.fechaFake = date;
        this.id_ParticipanteFake = id_Participante;
        this.id_ConcursoFake = id_Concurso;
    }
//verificar/assert a cada uno de los parametros utilizados.
}
