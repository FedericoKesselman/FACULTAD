package io.github.unlp_oo.Ej5_oo1;

public class Cuadrado implements Figura{
	private double lado;
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public double getPerimetro() {
		return this.lado * 4;
	}
	
	public double getArea() {
		return lado * lado;
	}

}
