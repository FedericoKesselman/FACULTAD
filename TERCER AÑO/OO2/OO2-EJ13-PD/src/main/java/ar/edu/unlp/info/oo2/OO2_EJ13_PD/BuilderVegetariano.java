package ar.edu.unlp.info.oo2.OO2_EJ13_PD;

public class BuilderVegetariano extends SandwichBuilder{
	
	@Override
	public void construirPan() {
		this.getSandwich().setPan("Con semillas");
		this.getSandwich().setPrecioPan(120);	
	}

	@Override
	public void construirAderezo() {
		this.getSandwich().setAderezo("Sin");
		this.getSandwich().setPrecioAderezo(0);
	}

	@Override
	public void construirPrincipal() {
		this.getSandwich().setPrincipal("Provoleta grillada");
		this.getSandwich().setPrecioPrincipal(200);
	}

	@Override
	public void construirAdicional() {
		this.getSandwich().setAdicional("Berenjenas");
		this.getSandwich().setPrecioAdicional(100);
	}
}
