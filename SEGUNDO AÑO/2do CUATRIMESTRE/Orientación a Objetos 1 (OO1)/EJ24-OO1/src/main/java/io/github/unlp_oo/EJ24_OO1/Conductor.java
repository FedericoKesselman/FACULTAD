package io.github.unlp_oo.EJ24_OO1;

import java.time.LocalDate;

public class Conductor extends Usuario{
	private Vehiculo vehiculo;

	public Conductor(String nombre, double saldo, Vehiculo vehiculo) {
		super(nombre, saldo);
		this.vehiculo = vehiculo;
	}

	@Override
	public void cargarSaldo(double saldo) {
		if (vehiculo.esModerno())
			this.agregarSaldo(saldo * 0.99);
		else 
			this.agregarSaldo(saldo * 0.9);
	}
	
	@Override
	public double getBonificacion() {
		return vehiculo.bonificacion();
	}
}
