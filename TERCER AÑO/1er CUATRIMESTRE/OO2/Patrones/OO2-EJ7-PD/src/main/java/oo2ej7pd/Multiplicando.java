package oo2ej7pd;

public class Multiplicando extends Operando{

    @Override
    public void setValor(double valor, Calculadora c) {
        c.setValorAcumulado(c.getValorAcumulado() * valor);
        c.setEstado(new Inicial());
        }
}
