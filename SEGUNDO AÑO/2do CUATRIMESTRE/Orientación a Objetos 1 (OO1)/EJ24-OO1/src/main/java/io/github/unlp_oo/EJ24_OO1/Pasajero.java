package io.github.unlp_oo.EJ24_OO1;

import java.util.*;

public class Pasajero extends Usuario {
	private List<Viaje> viajes;

	public Pasajero(String nombre, double saldo) {
		super(nombre, saldo);
		this.viajes = new LinkedList<>();
	}	

	@Override
	public double getComision(double monto) {
		if (viajes.stream().anyMatch(v -> v.menosDe30Dias())) {
	        return 0;
	    }
	    return monto * 0.10;
	}
	
	public void realizarViaje(Viaje v) {
		if (this.getSaldo() >= 0)
			v.agregarPasajero(this);
	}
	
	public double getBonificacion() {
		if (viajes.size() > 1)
			return 500;
		else 
			return 0;
	}
}
