package ar.edu.unlp.info.oo1.Patrones_EJ12;

public class Inmueble extends Bien{
	private String direccion;
	private Double superficie;
	private double costoM;
	
	public Inmueble(String direccion, Double superficie, double costoM) {
		this.direccion = direccion;
		this.superficie = superficie;
		this.costoM = costoM;
	}

	@Override
	public double getValor() {
		return this.superficie * this.costoM;
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.2;
	}

	@Override
	public void add(Bien bien) {}

	@Override
	public void remove(Bien bien) {}
}
