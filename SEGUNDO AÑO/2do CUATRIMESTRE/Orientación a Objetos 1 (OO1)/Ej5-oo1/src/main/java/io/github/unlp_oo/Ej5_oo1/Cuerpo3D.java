package io.github.unlp_oo.Ej5_oo1;

public class Cuerpo3D {
	private Object caraBasal;
	private double altura;
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal (Object caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public double getVolumen() {
		return caraBasal.getArea() * altura;
	}
	
	public double getSuperficieExterior() {
		return (2 * caraBasal.getArea()) + caraBasal.getPerimetro() * this.altura;
	}
}
