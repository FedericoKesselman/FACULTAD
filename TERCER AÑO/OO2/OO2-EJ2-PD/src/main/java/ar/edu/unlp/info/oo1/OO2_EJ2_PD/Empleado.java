package ar.edu.unlp.info.oo1.OO2_EJ2_PD;

public abstract class Empleado {
	
	public double sueldo() {
		return this.sueldoBasico() + this.adicional() - this.descuento();
	}
	
	public double descuento() {
		return this.sueldoBasico() * 0.13 + this.adicional() * 0.05;
	}
	
	protected abstract double sueldoBasico();
	protected abstract double adicional();
}
