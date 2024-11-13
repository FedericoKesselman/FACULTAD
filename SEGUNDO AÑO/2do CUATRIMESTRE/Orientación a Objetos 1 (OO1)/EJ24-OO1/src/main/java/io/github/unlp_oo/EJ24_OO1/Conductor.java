package io.github.unlp_oo.EJ24_OO1;

import java.time.LocalDate;

public class Conductor extends Usuario{
	private Vehiculo vehiculo;

	public Conductor(String nombre, double saldo, Vehiculo vehiculo) {
		super(nombre, saldo);
		this.vehiculo = vehiculo;
	}

	@Override
	public double getComision(double monto) {
		if (vehiculo.esModerno())
			return monto * 0.01;
		else
			return monto * 0.1;
	}
	
	@Override
	public double getBonificacion() {
		return vehiculo.bonificacion();
	}
}
