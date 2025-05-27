package ar.edu.unlp.info.oo2.OO2_EJ13_PD;

public class SubteWay {
	private SandwichBuilder builder;
	
	public SubteWay (SandwichBuilder builder) {
		this.builder = builder;
	}
	
	public Sandwich construirSandwich() {
		this.builder.reset();
		this.builder.construirPan();
		this.builder.construirAderezo();
		this.builder.construirPrincipal();
		this.builder.construirAdicional();
		return this.builder.getSandwich();
	}
	
	public void setBuilder(SandwichBuilder builder) {
		this.builder = builder;
	}
}
