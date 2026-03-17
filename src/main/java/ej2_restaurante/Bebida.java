package ej2_restaurante;

import java.time.LocalDate;

public class Bebida implements Consumibles{
    private String nombre;
    private double costo;

    public Bebida(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }
    public double getCosto() {
        return costo;
    }
}
