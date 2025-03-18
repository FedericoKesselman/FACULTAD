package io.github.unlp_oo.ParcialOO1;
import java.util.*;

import java.time.LocalDate;

public class EventoPresencial extends Evento{
	private List<Sede> sedes;
	
	public EventoPresencial(String nombre, LocalDate fecha, String tema, double precioI, double precioR) {
		super(nombre, fecha, tema, precioI, precioR);
		this.sedes = new LinkedList<>();
	}
	
	private double precioEstadias() {
		return this.sedes.stream()
				.mapToDouble(s -> s.precioEstadia())
				.sum();
	}
	
	public double precioEvento (LocalDate fecha) { 
		double precio = this.precioE() + this.precioEstadias();
		return precio + this.calcularPrecioFecha(fecha, precio);
	}

}
