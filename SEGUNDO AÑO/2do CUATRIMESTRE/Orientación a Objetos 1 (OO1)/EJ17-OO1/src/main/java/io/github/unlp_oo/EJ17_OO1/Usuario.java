package io.github.unlp_oo.EJ17_OO1;
import java.time.LocalDate;
import java.util.*;

public class Usuario {
	private String nombre;
	private String direccion;
	private int DNI;
	private List<Propiedad> propiedades;
	
	public Usuario (String nombre, String direccion, int DNI) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.DNI = DNI;
		this.propiedades = new LinkedList<Propiedad>();
	}
	
	public void agregarPropiedad (Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
	    return propiedades.stream()
	        
	}

}
