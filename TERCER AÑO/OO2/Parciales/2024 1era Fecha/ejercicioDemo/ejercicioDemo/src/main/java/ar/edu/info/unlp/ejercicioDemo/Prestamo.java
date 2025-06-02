package ar.edu.info.unlp.ejercicioDemo;

public abstract class Prestamo {
	private double monto;
	private int cantCuotas;
	private int cantCuotasPagadas;
	private double montoPagado;
	private Cliente cliente;
	private EstadoPrestamo estado;
	
	public Prestamo(double monto, int cantCuotas, Cliente cliente) {
		this.monto = monto;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
		this.cantCuotasPagadas = 0;
		this.montoPagado = 0;
		
		if ( this.valorCuota() > cliente.getSalario()*0.3)
			this.estado = new Rechazada();
		else
			this.estado = new Aceptada();
	}
	
	// TEMPLATE METHOD
	public double valorCuota() {
		return (this.monto/this.cantCuotas) * (1 + getInteres());
	}
	protected abstract double getInteres();
	
	public void pagarCuota() {
		this.estado.pagarCuota(this);
	}
	
	public double montoCancelacion() {
		return this.estado.montoCancelacion(this);
	}
	
	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}
	
	// TEMPLATE METHOD
	protected double calcularMontoCancelacion() {
		return this.getMontoRestante() + this.montoAdministrativo() + this.montoSellado();
	}
	
	protected  double montoAdministrativo() {
		return this.getMontoRestante() * 0.1;
	}
	
	protected abstract double montoSellado();
	
	public void incrementarCuotasPagadas() {
		this.cantCuotasPagadas++;
	}
	
	public void increcrementarMontoPagado() {
		this.montoPagado += this.valorCuota();
	}
	
	public double getMontoPagado() {
		return this.montoPagado;
	}
	
	public double getMontoRestante() {
		return (cantCuotas-cantCuotasPagadas) * this.valorCuota();
	}
}
