package io.github.unlp_oo.ParcialOO1;
import java.time.LocalDate;

public abstract class Evento {
	private String nombre;
	private LocalDate fecha;
	private String tema;
	private double precioI, precioR;
	
	public Evento(String nombre, LocalDate fecha, String tema, double precioI, double precioR) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.tema = tema;
		this.precioI = precioI;
		this.precioR = precioR;
	}
	
	public abstract double precioEvento(LocalDate fecha);
	
	protected double precioE() {
		return this.precioI + this.precioR;
	}
	
	protected double calcularPrecioFecha(LocalDate fecha, double monto) {
		if (this.fecha.equals(fecha))
			return monto * 0.2;
		else
			return 0;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
}
