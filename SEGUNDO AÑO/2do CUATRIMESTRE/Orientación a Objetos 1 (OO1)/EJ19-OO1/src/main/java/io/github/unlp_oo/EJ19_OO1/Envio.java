package io.github.unlp_oo.EJ19_OO1;
import java.time.LocalDate;

public abstract class Envio {
	private LocalDate fecha;
	private String direccionOrigen;
	private String direccionDestino;
	private int peso;

	public Envio(LocalDate fecha, String direccionOrigen, String direccionDestino, int peso) {
		this.fecha = fecha;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.peso = peso;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public abstract double calcularCosto();
	// public abstract double calcularCosto(CuadroTarifario cuadro); En caso de manejar los costos directamente en el cuadro

}
