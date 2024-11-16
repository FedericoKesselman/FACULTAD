package io.github.unlp_oo.ParcialOO1;
import java.time.LocalDate;
import java.time.Period;

public class Entrada {
	private Evento evento;
	private double precioPagado;
	private LocalDate fechaCompra;
	private boolean seguro;
	
	public Entrada(Evento evento, double precioPagado, LocalDate fechaCompra, boolean seguro) {
		this.evento = evento;
		this.precioPagado = precioPagado;
		this.fechaCompra = fechaCompra;
		this.seguro = seguro;
	}
	
	public int diasHasta() {
		return Period.between(LocalDate.now(), evento.getFecha()).getDays();
	}
	
	private double montoDias() {
		int dias = diasHasta();
		if (dias >= 30)
			return this.precioPagado * 0.5;
		else
			return 0;
	}
	
	public double montoDevolucion() {
		double monto = this.montoDias();
		if (this.seguro)
			return monto + monto * 0.15;
		else
			return monto;
	}
	
	public double precio() {
		return this.precioPagado;
	}
	
	public LocalDate fecha() {
		return this.fechaCompra;
	}
}
