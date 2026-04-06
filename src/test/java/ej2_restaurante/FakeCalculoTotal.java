package ej2_restaurante;

public class FakeCalculoTotal implements RegistroTotal {
    public boolean totalFalso = false;

    @Override
    public void GuardarCuenta(double costoTotal) {
        this.totalFalso = true;
    }
}
