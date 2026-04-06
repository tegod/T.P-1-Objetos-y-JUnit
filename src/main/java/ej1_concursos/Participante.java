package ej1_concursos;

public class Participante {
    private int DNI;
    private String nombre;
    private String apellido;
    private String email;
    private int puntuacion;

    public Participante(int DNI, String nombre, String apellido, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public int devolverPuntuacion() {
        return puntuacion;
    }

    public String pasarEmail() {
        return email;
    }

    /*public void mostrarPuntos() {
        System.out.println("Puntos del/la participante: " + devolverPuntuacion());
    }*/

    public int obtenerDniDeParticipante() {
        return DNI;
    }

    public void sumarPuntos(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
