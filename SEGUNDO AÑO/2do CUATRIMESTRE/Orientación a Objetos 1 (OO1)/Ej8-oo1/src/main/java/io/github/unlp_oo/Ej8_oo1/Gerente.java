package io.github.unlp_oo.Ej8_oo1;

public class Gerente extends EmpleadoJerarquico{
	
	public Gerente (String nombre) {
		super(nombre);
	}
	
	public double aportes() {
		return this.montoBasico() * 0.05d;
	}
	
	public double montoBasico() {
		return 57000;
	}
}
