package ej1_concursos;

public class FakeMail implements Notificar {


    @Override
    public void enviarMail(String destino, String asunto, String mensaje) {
        System.out.println("Intentando enviar un mai a" + destino);
    }
}
