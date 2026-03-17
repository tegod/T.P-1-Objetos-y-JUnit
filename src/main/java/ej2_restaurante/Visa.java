package ej2_restaurante;

public class Visa implements Tarjeta{
    @Override
    public double calcularMonto(double costoBebidas, double costoPlatosPrincipales) {
        costoBebidas = costoBebidas * 0.7;
        return costoBebidas + costoPlatosPrincipales;
    }
}
