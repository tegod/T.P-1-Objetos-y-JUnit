package ej2_restaurante;

public class ComarcaPlus implements Tarjeta {
    @Override
    public double calcularMonto(double costoBebidas, double costoPlatosPrincipales) {
        return  (costoBebidas + costoPlatosPrincipales)*0.8;
    }
}
