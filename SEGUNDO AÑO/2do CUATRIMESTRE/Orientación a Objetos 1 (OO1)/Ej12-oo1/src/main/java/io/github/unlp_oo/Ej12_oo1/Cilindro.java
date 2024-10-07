package io.github.unlp_oo.Ej12_oo1;

public class Cilindro extends Pieza {
	private int radio;
	private int altura;
	
	public Cilindro (String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}
	
	public double getVolumen() {
		return Math.PI * (radio * radio) * altura;
	}
	
	public double getSuperficie() {
		return (2 * Math.PI * radio * altura) + (2 * Math.PI * (radio * radio));
	}
}
