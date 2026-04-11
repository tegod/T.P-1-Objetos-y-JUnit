package ej2_restaurante;

public class FakeCalculoTotal implements RegistroTotal {
    public boolean corroboracionFake = false;

    public double costoTotalFake;
    @Override
    public void guardarCuenta(double costoTotal) {
        this.corroboracionFake = true;
        this.costoTotalFake = costoTotal;
    }
}
