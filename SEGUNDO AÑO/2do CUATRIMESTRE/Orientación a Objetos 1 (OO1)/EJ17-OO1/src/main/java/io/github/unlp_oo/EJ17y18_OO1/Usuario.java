package io.github.unlp_oo.EJ17y18_OO1;
import java.time.LocalDate;
import java.util.*;

import Ej14b.DateLapse;

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
	
	
	public double calcularIngresos(DateLapse periodo) {
		return propiedades.stream()
				.mapToDouble(propiedad -> propiedad.precioReservasEnPeriodo(periodo))
				.sum() * 0.75;
    }
}
