package io.github.unlp_oo.EJ20_OO1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPlanta extends Contrato{
	private double sueldo;
	private double montoConyuge;
	private double montoHijos;
	
	public ContratoPlanta(LocalDate fechaInicio, double sueldo, double montoConyuge, double montoHijos) {
		super(fechaInicio);
		this.sueldo = sueldo;
		this.montoConyuge = montoConyuge;
		this.montoHijos = montoHijos;
	}
	
	public boolean isActivo() {
		return true;
	}
	
	
	public double montoBasico(Empleado e) {
		double sueldo = this.sueldo;
		if (e.isConyuge()) sueldo += this.montoConyuge;
		if (e.isHijos()) sueldo += this.montoHijos;
		return sueldo;
	}
	
	
	public int duracion() {
		return (int) ChronoUnit.YEARS.between(getFechaInicio(), LocalDate.now());
	}
	
}
