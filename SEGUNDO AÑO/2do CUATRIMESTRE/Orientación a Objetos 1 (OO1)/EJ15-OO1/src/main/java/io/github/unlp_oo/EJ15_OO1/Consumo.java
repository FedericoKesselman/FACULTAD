package io.github.unlp_oo.EJ15_OO1;


public class Consumo {
	private double energiaActiva;
	private double energiaReactiva;
	
	public Consumo (double energiaActiva, double energiaReactiva) {
		this.energiaActiva = energiaActiva;
		this.energiaReactiva = energiaReactiva;
	}
	
	
	public double montoEnergiaAciva (double costo) {
		return this.energiaActiva * costo;
	}
	
	public boolean bonificacion() {
		double energia = Math.pow (this.energiaActiva, 2) + Math.pow(this.energiaReactiva, 2);
		double fpe = (this.energiaActiva) / Math.sqrt(energia);
		
		return fpe > 0.8;
	}
}
