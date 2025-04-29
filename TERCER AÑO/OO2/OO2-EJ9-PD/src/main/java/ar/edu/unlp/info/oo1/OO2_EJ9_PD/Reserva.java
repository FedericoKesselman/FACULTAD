package ar.edu.unlp.info.oo1.OO2_EJ9_PD;

import java.time.LocalDate;

public class Reserva {
	private int cantidadDias;
	private LocalDate fecha;
	private Usuario usuario;
	private AutoEnAlquiler auto;
	
	public Reserva(int cantidadDias, LocalDate fecha, Usuario usuario, AutoEnAlquiler auto) {
		this.cantidadDias = cantidadDias;
		this.fecha = fecha;
		this.usuario = usuario;
		this.auto = auto;
	}
	
	public double montoAPagar() {
		return this.auto.getPrecioPorDia() * this.cantidadDias;
	}
	
	public double montoAReembolsar() {
		return LocalDate.now().isBefore(this.fecha) ? this.auto.getPolitica().montoAReembolsar(this) : 0.0;
	}
	
	protected LocalDate getFecha() {
		return this.fecha;
	}
	
	/*
	El patrón utilizado es Strategy:
		- Bajo acomplamiento entre politicas: Automovil no necesita saber cómo calcular el reembolso
		- Alta Cohesión: Cada política encapsula su lógica
		- Extensibilidad: Fácil agregar una nueva política
		- Flexibilidad en tiempo de ejecución: Se puede cambiar de política en cualquier momento
	
	*/
}	
