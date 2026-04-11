package ej2_restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorPedidos;
    private int nroPedido;
    private List<Bebida> bebidas;
    private List<PlatoPrincipal> platosPrincipales;
    //private List<Consumibles> consumibles;
    private double costo;
    private RegistroTotal registroTotal;

    public Pedido(RegistroTotal registroTotal) {
        this.registroTotal = registroTotal;
        this.nroPedido = contadorPedidos++;
        bebidas = new ArrayList<>();
        platosPrincipales = new ArrayList<>();
    }

    public double calcularCostoBebidas() {
        /*double costoTotal = 0.0;
        for (Consumibles bebida : bebidas) {
            costoTotal += bebida.sumarBebida();
        }
        return costoTotal;*/

        double costoTotal = 0.0;
        for (Bebida bebida : bebidas) {
            costoTotal += bebida.getCosto();
        }
        return costoTotal;
    }
    public double calcularCostoPlatosPrincipales() {
        /*double costoTotal = 0.0;
        for (Consumibles platoPrincipal : platosPrincipales) {
            costoTotal += platoPrincipal.sumarPlato();
        }
        return costoTotal;*/

        double costoTotal = 0.0;
        for (PlatoPrincipal platoPrincipal : platosPrincipales) {
            costoTotal += platoPrincipal.getCosto();
        }
        return costoTotal;
    }

    public double calcularCostoPedido(Tarjeta tarjeta) {
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

    public void guardarDatos(double costoTotal) {
        registroTotal.guardarCuenta(costoTotal);
    }
}
