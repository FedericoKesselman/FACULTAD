package ar.edu.info.unlp.ejercicio2;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public double getPeso() {
		return peso;
	}

	public double getPrecioPorKilo() {
		return precioPorKilo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public double getPrecio() {
		return this.precioPorKilo * this.peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
		
}
