package io.github.unlp_oo.EJ24_OO1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vehiculo {
	private Conductor dueno;
	private String desc;
	private int capacidad;
	private int anio;
	private double valor;
	
	public Vehiculo(Conductor dueno, String desc, int capacidad, int anio, double valor) {
		this.dueno = dueno;
		this.desc = desc;
		this.capacidad = capacidad;
		this.anio = anio;
		this.valor = valor;
	}
	
	public boolean esModerno() {
		return LocalDate.now().getYear() - anio < 5;
	}
	
	public Conductor getDueno() {
		return this.dueno;
	}
	
	public boolean hayCapacidad(int cant) {
		return this.capacidad >= cant;
	}
	
	public double bonificacion() {
		return this.valor * 0.01;
	}
	
	
}
