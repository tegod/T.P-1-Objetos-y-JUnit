package ej1_concursos;

public class Participante {
    private String nombre;
    private String apellido;
    private int puntuacion;

    public Participante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void mostrarPuntos() {
        System.out.println("Puntos del/la participante: " + getPuntuacion());
    }

    public void sumarPuntos(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
