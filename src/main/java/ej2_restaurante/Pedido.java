package ej2_restaurante;

import java.util.ArrayList;

public class Pedido {
    private static int contadorPedidos;
    private int nroPedido;
    private ArrayList<Bebida> bebidas;
    private ArrayList<PlatoPrincipal> platosPrincipales;
    private double costo;

    public Pedido() {
        this.nroPedido = contadorPedidos++;
        bebidas = new ArrayList<>();
        platosPrincipales = new ArrayList<>();
    }

    public double calcularCostoBebidas() {
        double costoTotal = 0.0;
        for (Bebida bebida : bebidas) {
            costoTotal += bebida.getCosto();
        }
        return costoTotal;
    }
    public double calcularCostoPlatosPrincipales() {
        double costoTotal = 0.0;
        for (PlatoPrincipal platoPrincipal : platosPrincipales) {
            costoTotal += platoPrincipal.getCosto();
        }
        return costoTotal;
    }

    public double calCularCostoPedido(Tarjeta tarjeta) {
        double costoBebida = calcularCostoBebidas();
        double costoPlatosPrincipales = calcularCostoPlatosPrincipales();

        double total = tarjeta.calcularMonto(costoBebida, costoPlatosPrincipales);

        return total;
    }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }
    public void agregarPlatoPrincipal(PlatoPrincipal platoPrincipal) {
        platosPrincipales.add(platoPrincipal);
    }
}
