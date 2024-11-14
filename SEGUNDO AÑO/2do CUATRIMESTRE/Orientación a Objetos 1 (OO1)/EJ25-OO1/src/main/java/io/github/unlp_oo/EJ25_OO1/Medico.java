package io.github.unlp_oo.EJ25_OO1;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Medico {
	private String nombre;
	private LocalDate fechaIngreso;
	private double honorarios;
	
	public Medico (String nombre, LocalDate fechaIngreso, double honorarios) {
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.honorarios = honorarios;
	}
	
	public double getHonorarios() {
		return this.honorarios;
	}
	
	public int antiguedad() {
		return (int) ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
	}
}
