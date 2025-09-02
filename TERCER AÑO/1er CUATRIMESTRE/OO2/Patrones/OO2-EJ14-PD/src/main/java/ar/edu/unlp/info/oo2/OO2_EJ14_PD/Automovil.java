package ar.edu.unlp.info.oo2.OO2_EJ14_PD;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Automovil extends Prenda{
	private LocalDate modelo;
	private int kilometraje;
	private double costo0km;

	public Automovil(LocalDate modelo, int kilometraje, double costo0km) {
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.costo0km = costo0km;
	}

	@Override
	public double getValor() {
	    double factor = 1 - 0.10 * Period.between(modelo, LocalDate.now()).getYears();
	    return factor > 0 ? costo0km * factor : 0.0;
	}

	@Override
	public double getLiquidez() {
		return 0.7;
	}

	@Override
	public void agregarPrenda(Prenda prenda) {
	}

	@Override
	public List<Prenda> obtenerPrendas(Prenda prenda) {
		return null;
	}
}
