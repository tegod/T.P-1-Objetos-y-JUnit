package ej2_restaurante;

public class Mastercard implements Tarjeta {
    @Override
    public double calcularMonto(double costoBebidas, double costoPlatosPrincipales) {
        costoPlatosPrincipales = costoPlatosPrincipales * 0.8;
        return costoBebidas + costoPlatosPrincipales;
    }
}
