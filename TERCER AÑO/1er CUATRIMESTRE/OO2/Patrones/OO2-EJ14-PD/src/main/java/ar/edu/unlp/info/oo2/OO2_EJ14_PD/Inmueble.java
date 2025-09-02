package ar.edu.unlp.info.oo2.OO2_EJ14_PD;

import java.util.List;

public class Inmueble extends Prenda{
	private String direccion;
	private double superficie;
	private double costom2;

	@Override
	public double getValor() {
		return this.superficie * this.costom2;
	}

	@Override
	public double getLiquidez() {
		return 0.2;
	}

	@Override
	public void agregarPrenda(Prenda prenda) {
	}

	@Override
	public List<Prenda> obtenerPrendas(Prenda prenda) {
		return null;
	}
}
