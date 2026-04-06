package ej2_restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {
    private Pedido pedido;
    private Bebida bebida;
    private PlatoPrincipal platoPrincipal;
    private Tarjeta tarjeta;
    private FakeCalculoTotal calculoTotal;

    @BeforeEach
    public void setUp() {
        calculoTotal = new FakeCalculoTotal();
        pedido = new Pedido(calculoTotal);
        bebida = new Bebida("coca",25);
        pedido.agregarBebida(bebida);
        bebida = new Bebida("agua",15);
        pedido.agregarBebida(bebida);
        platoPrincipal = new PlatoPrincipal("osobuco", 30);
        pedido.agregarPlatoPrincipal(platoPrincipal);
        platoPrincipal = new PlatoPrincipal("fideos", 20);
        pedido.agregarPlatoPrincipal(platoPrincipal);
    }

    @Test
    public void testPagoConVisa() {
        tarjeta = new Visa();
        assertEquals(78, pedido.calcularCostoPedido(tarjeta));
    }
    @Test
    public void testPagoConMastercard() {
        tarjeta = new Mastercard();
        assertEquals(80, pedido.calcularCostoPedido(tarjeta));
    }
    @Test
    public void testPagoConComarcaPlus() {
        tarjeta = new ComarcaPlus();
        assertEquals(72, pedido.calcularCostoPedido(tarjeta));
    }
}
