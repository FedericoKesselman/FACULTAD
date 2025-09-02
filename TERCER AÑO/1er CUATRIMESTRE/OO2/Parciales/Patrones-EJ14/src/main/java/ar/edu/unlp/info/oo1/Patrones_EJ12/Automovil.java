package ar.edu.unlp.info.oo1.Patrones_EJ12;

import java.time.LocalDate;

public class Automovil extends Bien{
	private int modelo;
	private int kilometraje;
	private double costoceroKm;
	
	public Automovil(int modelo, int kilometraje, double costoceroKm) {
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.costoceroKm = costoceroKm;
	}

	@Override
	public double getValor() {
		return costoceroKm * (0.1 * (LocalDate.now().getYear() - modelo));
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.7;
	}

	@Override
	public void add(Bien bien) {}

	@Override
	public void remove(Bien bien) {}
}
