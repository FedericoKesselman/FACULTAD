package io.github.unlp_oo.Test_EJ9;

public abstract class Cuenta {
	private double saldo;
	
	public Cuenta() {
		this.saldo = 0;
	}
	
	
	public double getSaldo() {
		return this.saldo;
	}
	
	
	public void depositar(double monto) {
		this.saldo += monto;
	}
	
	
	protected void extraerSinControlar (double monto) {
		this.saldo -= monto;
	}
	
	
	public boolean extraer(double monto) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		
		return false;
	}
	
	
	public boolean transferirACuenta (double monto, Cuenta cuentaDestino) {
		if (this.extraer(monto)) {
			cuentaDestino.depositar(monto);
			return true;
		}
		
		return false;
	}
	
	protected abstract boolean puedeExtraer (double monto);
	
	/* 
	 a) Se llama cuenta con ganchos xq los metodos de CajaDeAhorro y CuentaCorriente estan "conectados" con Cuenta. Si se cambia el comportamiento 
	 	de Cuenta, tambien se cambia el comportamiento de las otras clases.
	  
	 b) This es el objeto que ejecuta el metodo. La busqueda comienza en dicho objeto, y si no lo encuentra en su clase, continua en su superclase y 
	 	asi sucesivamente.
	 	
	 c) Tienen visibilidad protegido para que unicamente puedan ser ejecutadas desde aquellos objetos que pertenecen a la misma "familia" (clases heredadas) 
	 	Intermedio entre publico y privado.
	  
	 d) Si, se puede. El metodo transferirACuenta() acepta transferencias a cualquier metodo que sea "Cuenta". En este caso CajaDeAhorro y CuentaCorriente 
	 	son Cuenta.
	 	
	 e) Las clases abstractas no pueden ser implementadas. Los metodos abstractos DEBEN ser implementados en las subclases de la misma.
	 */
	
	
}
