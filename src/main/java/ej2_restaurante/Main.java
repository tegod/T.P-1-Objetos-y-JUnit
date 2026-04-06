package ej2_restaurante;

public class Main {
    public static void main(String[] args) {
        var bebida = new Bebida("coca",25);
        var bebida1 = new Bebida("agua",15);
        var platoPrincipal = new PlatoPrincipal("osobuco", 30);
        var platoPrincipal1 = new PlatoPrincipal("fideos", 20);
        Tarjeta tarjeta = new Mastercard();

     /*   RegistroEnTexto registroEnTextoMesaX = new RegistroEnTexto("CuentaMesa1.txt");
        Pedido pedido = new Pedido(registroEnTextoMesaX);
        pedido.agregarBebida(bebida);
        pedido.agregarBebida(bebida1);
        pedido.agregarPlatoPrincipal(platoPrincipal);
        pedido.agregarPlatoPrincipal(platoPrincipal1);
        pedido.calcularCostoPedido(tarjeta);*/


        RegistroEnJDBC registroEnBaseDeDatos = new  RegistroEnJDBC();
        Pedido pedidoEnBaseDeDatos = new Pedido(registroEnBaseDeDatos);
        pedidoEnBaseDeDatos.agregarBebida(bebida);
        pedidoEnBaseDeDatos.agregarBebida(bebida1);
        pedidoEnBaseDeDatos.agregarPlatoPrincipal(platoPrincipal);
        pedidoEnBaseDeDatos.agregarPlatoPrincipal(platoPrincipal1);
        var total = pedidoEnBaseDeDatos.calcularCostoPedido(tarjeta);
        pedidoEnBaseDeDatos.guardarDatos(total);
    }
}
