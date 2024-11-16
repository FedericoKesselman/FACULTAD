package io.github.unlp_oo.ParcialOO1;

import java.time.LocalDate;

public class EventoVirtual extends Evento{
	private double precioEnvio;
	
	public EventoVirtual(String nombre, LocalDate fecha, String tema, double precioI, double precioR, double precioEnvio) {
		super(nombre, fecha, tema, precioI, precioR);
		this.precioEnvio = precioEnvio;
	}

	public double precioEvento (LocalDate fecha) { 
		double precio = this.precioE() + this.precioEnvio;
		return precio + this.calcularPrecioFecha(fecha, precio);
	}
	
}
