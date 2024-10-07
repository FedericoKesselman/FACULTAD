package io.github.unlp_oo.Ej13_oo1;

public class Archivo {
	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public int tamano() {
		return this.nombre.length();
	}
}
