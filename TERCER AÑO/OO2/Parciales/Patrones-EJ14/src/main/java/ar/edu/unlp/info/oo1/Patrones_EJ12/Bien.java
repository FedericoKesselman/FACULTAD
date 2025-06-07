package ar.edu.unlp.info.oo1.Patrones_EJ12;

public abstract class Bien {
	// TEMPLATE METHOD
	public double valorPrendario() {
		return this.getValor() * this.getCoeficienteLiquidez();
	}
	
	public abstract double getValor();
	public abstract double getCoeficienteLiquidez();
	
	public abstract void add(Bien bien);
	public abstract void remove(Bien bien);
}
