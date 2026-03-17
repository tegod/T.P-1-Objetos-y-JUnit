package ej2_restaurante;

import java.time.LocalDate;

public class PlatoPrincipal {
    private String nombre;
    private double costo;

    public PlatoPrincipal(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }
}
