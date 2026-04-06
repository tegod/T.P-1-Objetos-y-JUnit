package ej1_concursos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Participante participante = new Participante(41995847, "Diego",
                "Ibañez", "diegotetobias@gmail.com");
        Participante participante1 = new Participante(38541039, "Pedro",
                "Pascal", "pedroPascal@gmail.com");

       /* Inscripciones blockDeNotas = new InscripcionParticipantes("participantesAnotados.txt");
        Concurso concurso = new Concurso("Concurso pulseadas",
                LocalDate.now(), LocalDate.now().plusDays(3), blockDeNotas, new EnviarMail());
        concurso.insertarParticipante(participante, LocalDate.now().plusDays(1));
        concurso.insertarParticipante(participante1, LocalDate.now());*/


        Inscripciones baseDeDatos = new InscripcionParticipantesJDBC();
        Concurso concursoConBD = new Concurso("Concurso pulseadas",
                LocalDate.now(),LocalDate.now().plusDays(3), baseDeDatos, new EnviarMail());
        concursoConBD.insertarParticipante(participante, LocalDate.now().plusDays(1));

        //Ocurre un problema con enviar muchos mail por segundo, el Theard.sleep() deja "durmiendo" o pausado
        // x tiempo para intentar evitar esto. No es eficiente pero es un intento para solucionar en base
        // a la disponibilidad
        /*try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException("Error al esperar otro envio");
        }
        //(no funco)

        concursoConBD.insertarParticipante(participante1, LocalDate.now());*/
    }
}
