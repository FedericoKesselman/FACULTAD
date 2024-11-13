package io.github.unlp_oo.EJ24_OO1;

import java.util.*;

public class Pasajero extends Usuario {
	private List<Viaje> viajes;

	public Pasajero(String nombre, double saldo) {
		super(nombre, saldo);
		this.viajes = new LinkedList<>();
	}

	@Override
	public void cargarSaldo(double saldo) {
		Viaje ultViaje = viajes.get(viajes.size()-1);
		
		if ((ultViaje != null) && (ultViaje.menosDe30Dias()))
			this.agregarSaldo(saldo);
		
		else 
			this.agregarSaldo(saldo * 0.9);
	}
	
	public void realizarViaje(Viaje v) {
		if (this.getSaldo() > 0) 
			v.agregarPasajero(this);
	}
	
	@Override
	public void procesar(double monto, Viaje v) {
		super.procesar(monto, v);
		this.viajes.add(v)
	}
	
	public double getBonificacion() {
		if (viajes.size() > 1)
			return 500;
		else 
			return 0;
	}
}
