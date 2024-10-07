package io.github.unlp_oo.Ej12_oo1;

public abstract class Pieza {
	private String material;
	private String color;
	
	public Pieza (String material, String color) {
		this.material = material;
		this.color = color;
	}
	
	public abstract double getVolumen();
	public abstract double getSuperficie();
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
	
}
