package io.github.unlp_oo.Repaso;

public class Producto {
	private String nombre, categoria;
	private double precio;
	private int stock;
	
	public Producto (String nombre, String categoria, double precio, int stock) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}
	
	public boolean hayStock (int cant) {
		return this.stock >= cant;
	}
	
	public void descontarStock(int cant) {
		this.stock -= cant;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public double getPrecio() {
		return this.precio;
	}
}
