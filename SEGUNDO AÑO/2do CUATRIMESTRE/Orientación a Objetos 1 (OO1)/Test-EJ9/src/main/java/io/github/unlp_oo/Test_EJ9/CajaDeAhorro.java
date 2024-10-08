package io.github.unlp_oo.Test_EJ9;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro() {
		super();
	}
	
	public boolean puedeExtraer (double monto) {
		return this.getSaldo() >= monto + (0.02 * monto);
	}
	
	
	public boolean extraer (double monto) { 
		return super.extraer(monto * 0.98);
	}
	
	
	public void depositar (double monto) {
		super.depositar(monto * 0.98);
	}
}
