package ej1_concursos;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EnviarMail implements Notificar {

    @Override
    public void enviarMail(String destino, String asunto, String mensaje) {
        String to = destino; //para
        String from = "jakartafrom@example.com"; //desde

        String host = "sandbox.smtp.mailtrap.io";
        String port = "465";
        String userName = "6e09acbb432309";
        String passWord = "6ee004628b87cd";

        //configuracion de detalles
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, passWord);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
