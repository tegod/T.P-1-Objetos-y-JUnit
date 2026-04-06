package ej1_concursos;

import java.time.LocalDate;

public class FakeInscripcion implements Inscripciones{
    public boolean guardadoFalso = false;

    @Override
    public void anotarInscripcion(LocalDate date, int id_Participante, int id_Concurso) {
        // corrobora que se haya accedido al metodo devolviendo true
        this.guardadoFalso = true;
    }

}
