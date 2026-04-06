package ej1_concursos;

import java.time.LocalDate;

public interface Inscripciones {

    void anotarInscripcion(LocalDate date, int id_Participante, int id_Concurso);
}
