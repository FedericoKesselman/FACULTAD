package io.github.unlp_oo.ParcialOO1;

public class Sede {
	private String nombre;
	private double precio;
	private int cantDias;
	
	public Sede(String nombre, double precio, int cantDias) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantDias = cantDias;
	}
	
	public double precioEstadia() {
		return this.precio * this.cantDias;
	}
	
	
}
