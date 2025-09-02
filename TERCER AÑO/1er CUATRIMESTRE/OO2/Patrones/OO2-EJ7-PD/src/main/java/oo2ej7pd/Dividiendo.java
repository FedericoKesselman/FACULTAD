package oo2ej7pd;

public class Dividiendo extends Operando{
    @Override
    public void setValor(double valor, Calculadora c) {
        if (valor == 0) {
            c.setEstado(new Error());
        } else {
            c.setValorAcumulado(c.getValorAcumulado() / valor);
            c.setEstado(new Inicial());
        }
    }
}
