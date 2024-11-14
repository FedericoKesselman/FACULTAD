package io.github.unlp_oo.EJ24_OO1;

public abstract class Usuario {
	private String nombre;
	private double saldo;
	
	public Usuario (String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	protected void cargarSaldo(double monto) {
		this.saldo += monto - this.getComision(monto);
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void procesar(double monto, Viaje v) {
		this.saldo -= monto - this.getBonificacion();
	}
	
	protected abstract double getComision(double monto);
	protected abstract double getBonificacion();
}
