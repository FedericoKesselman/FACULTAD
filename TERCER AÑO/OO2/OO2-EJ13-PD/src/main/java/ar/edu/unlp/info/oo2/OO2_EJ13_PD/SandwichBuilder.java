package ar.edu.unlp.info.oo2.OO2_EJ13_PD;

public abstract class SandwichBuilder {
	private Sandwich sandwich;
	
	public void reset() {
		this.sandwich = new Sandwich();
	}
	
	public Sandwich getSandwich() {
		return this.sandwich;
	}
	
	public abstract void construirPan();
	public abstract void construirAderezo();
	public abstract void construirPrincipal();
	public abstract void construirAdicional();
}
