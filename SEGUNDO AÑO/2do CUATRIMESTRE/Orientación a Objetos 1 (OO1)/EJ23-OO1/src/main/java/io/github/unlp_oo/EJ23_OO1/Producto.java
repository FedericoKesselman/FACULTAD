package io.github.unlp_oo.EJ23_OO1;

public class Producto {
	private String nombre;
	private String categoria;
	private double precio;
	private int cantDisponible;
	
	public Producto (String nombre, String categoria, double precio, int cantDisponible) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
	}
	
	public boolean disponibilidad (int cant) {
		return cantDisponible >= cant;
	}
	
	public void descontarStock(int cant) {
		this.cantDisponible -= cant;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public double getPrecio() {
		return this.precio;
	}
}
