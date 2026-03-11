package ej1_concursos;

public class Participante {
    private String nombre;
    private String apellido;
    private int puntuacion;

    public Participante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Participante(String nombre, String apellido, int puntuacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntuacion = puntuacion;
    }

    public void mostrarPuntos() {
        System.out.println("Puntos del/la participante: " + this.puntuacion);
    }

    public void sumarPuntos(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
