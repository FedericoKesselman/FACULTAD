package ar.edu.unlp.info.oo2.OO2_EJ14_PD;

import java.util.List;

public class PrendaCombinada extends Prenda{
	private List<Prenda> prendas;

	@Override
	public double getValor() {
		return this.prendas.stream()
				.mapToDouble(p -> p.getValor())
				.sum();
	}

	@Override
	public double getLiquidez() {
		return 0.5;
	}

	@Override
	public void agregarPrenda(Prenda prenda) {
		this.prendas.add(prenda);
	}

	@Override
	public List<Prenda> obtenerPrendas(Prenda prenda) {
		return this.prendas;
	}
}
