 package oo2ej7pd;

public class Inicial extends Operando{
	@Override
    public void mas(Calculadora c) {
        c.setEstado(new Sumando());
    }

    @Override
    public void menos(Calculadora c) {
        c.setEstado(new Restando());
    }

    @Override
    public void por(Calculadora c) {
        c.setEstado(new Multiplicando());
    }

    @Override
    public void dividido(Calculadora c) {
        c.setEstado(new Dividiendo());
    }

	@Override
	public void setValor(double unValor, Calculadora c) {
		c.setValorAcumulado(unValor);
	}

	@Override
	public String getResultado(Calculadora c) {
		return Double.toString(c.getValorAcumulado());
	}
}