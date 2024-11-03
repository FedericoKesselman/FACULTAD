package io.github.unlp_oo.EJ19_OO1;

import java.time.LocalDate;

public class PersonaFisica extends Cliente{
	private int DNI;

	public PersonaFisica (String nombre, String direccion, int DNI) {
		super(nombre, direccion);
		this.DNI = DNI;
	}

	public double calcularMontoTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		return super.calcularMontoTotal(fechaInicio, fechaFin) * 0.9;
	}
}
