package ar.edu.unlp.info.oo1.Patrones_EJ12;

import java.util.LinkedList;
import java.util.List;

public class PrendaCombinada extends Bien{
	private List<Bien> bienes;
	
	public PrendaCombinada() {
		this.bienes = new LinkedList<>();
	}

	@Override
	public double getValor() {
		return this.bienes.stream()
				.mapToDouble(b -> b.getValor())
				.sum();
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.5;
	}

	@Override
	public void add(Bien bien) {
		this.bienes.add(bien);
	}

	@Override
	public void remove(Bien bien) {
		this.bienes.remove(bien);
	}
}
