package io.github.unlp_oo.EJ24_OO1;

import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class Viaje {
	private String origen;
	private String destino;
	private double costo;
	private LocalDate fecha;
	private Vehiculo vehiculo;
	private List<Usuario> pasajeros;
	
	public Viaje(String origen, String destino, double costo, Vehiculo vehiculo, LocalDate fecha) {
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
		this.fecha = fecha;
		this.vehiculo = vehiculo;
		this.pasajeros = new LinkedList<>();
		this.pasajeros.add(vehiculo.getDueno());
	}
	
	public boolean menosDe30Dias() {
		return ChronoUnit.DAYS.between(this.fecha, LocalDate.now()) <= 30;
	}
	
	public boolean sePuedeAgregar() {
		return vehiculo.hayCapacidad(pasajeros.size() + 1) && ChronoUnit.DAYS.between(this.fecha, LocalDate.now()) >= 2;
	}
	
	
	public void agregarPasajero(Pasajero p) {
		if (this.sePuedeAgregar()) 
			pasajeros.add(p);
	}
	
	public void procesarViaje() {
		double pasaje = costo / pasajeros.size();
		pasajeros.stream()
			.forEach(p -> p.procesar(pasaje, this));
	}
	
}
