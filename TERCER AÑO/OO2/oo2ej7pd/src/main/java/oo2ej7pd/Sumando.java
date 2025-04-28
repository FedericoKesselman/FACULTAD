package oo2ej7pd;

public class Sumando extends Operando{

    @Override
    public void setValor(double unValor, Calculadora c) {
        c.setValorAcumulado(unValor + c.getValorAcumulado());
        c.setEstado(new Inicial());
    }
}
