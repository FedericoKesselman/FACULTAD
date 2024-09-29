package io.github.unlp_oo.Ej9_oo1;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro() {
		super();
	}
	
	public boolean puedeExtraer (double monto) {
		return this.getSaldo() >= monto + (0.02 * monto);
	}
	
	
	public void extraerSinControlar (double monto) { // Este metodo o el extraer sin controlar? 
		super.extraerSinControlar(monto * 0.98);
	}
	
	
	public void depositar (double monto) {
		super.depositar(monto * 0.98);
	}
}
