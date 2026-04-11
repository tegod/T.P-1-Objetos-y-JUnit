package ej2_restaurante;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroEnTexto implements RegistroTotal {
    private String ubicacionDeArchivo;

    public RegistroEnTexto(String ubicacionDeArchivo) {this.ubicacionDeArchivo = ubicacionDeArchivo; }

    @Override
    public void guardarCuenta(double costoTotal) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        try (FileWriter Writer = new FileWriter(this.ubicacionDeArchivo, true)) {
            Writer.write(now.format(dtf) + "||" + costoTotal + "\n");
        }catch(IOException e) {
            throw  new RuntimeException(e);
        }
    }
}
