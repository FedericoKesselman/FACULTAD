package io.github.unlp_oo.EJ20_OO1;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato{
	private double valorPorHora;
	private int cantHoras;
	private LocalDate fechaFin;
	
	
	public ContratoPorHoras(LocalDate fechaInicio, double valorPorHora, int cantHoras, LocalDate fechaFin) {
		super(fechaInicio);
		this.valorPorHora = valorPorHora;
		this.cantHoras = cantHoras;
		this.fechaFin = fechaFin;
	}


	public boolean isActivo() {
		return this.fechaFin.isAfter(LocalDate.now());
	}
	
	
	public double montoBasico (Empleado e) {
		return valorPorHora * cantHoras;
	}
	
	public int duracion() {
		return (int) ChronoUnit.YEARS.between(fechaFin, getFechaInicio());
	}
	
}
