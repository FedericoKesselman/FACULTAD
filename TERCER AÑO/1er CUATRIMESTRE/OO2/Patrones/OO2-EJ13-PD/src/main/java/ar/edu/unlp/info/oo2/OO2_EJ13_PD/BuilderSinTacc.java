package ar.edu.unlp.info.oo2.OO2_EJ13_PD;

public class BuilderSinTacc extends SandwichBuilder{
	@Override
	public void construirPan() {
		this.getSandwich().setPan("Chipa");
		this.getSandwich().setPrecioPan(150);
	}

	@Override
	public void construirAderezo() {
		this.getSandwich().setAderezo("Salsa tartara");
		this.getSandwich().setPrecioAderezo(18);
	}

	@Override
	public void construirPrincipal() {
		this.getSandwich().setPrincipal("Carne de pollo");
		this.getSandwich().setPrecioPrincipal(250);
	}

	@Override
	public void construirAdicional() {
		this.getSandwich().setAdicional("Verduras grilladas");
		this.getSandwich().setPrecioAdicional(200);
	}
}
