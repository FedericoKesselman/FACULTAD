package io.github.unlp_oo.EJ23_OO1;

public abstract class Persona {
	private String nombre;
	private String direccion;
	
	public Persona (String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
}
