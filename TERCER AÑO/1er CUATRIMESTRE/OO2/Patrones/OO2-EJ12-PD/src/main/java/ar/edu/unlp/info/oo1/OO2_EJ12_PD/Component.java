package ar.edu.unlp.info.oo1.OO2_EJ12_PD;

import java.time.LocalDate;
import java.util.*;

public abstract class Component {
	private String nombre;
	private LocalDate fechaCreacion;
	
	public Component(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fechaCreacion = fecha;
    }
	
	 public String getNombre() { 
		 return this.nombre;
	 }
	 public LocalDate getFechaCreacion() { 
		 return this.fechaCreacion; 
	 }
	 
	 public abstract double tamanoTotalOcupado();
	 public abstract Archivo archivoMasGrande();
	 public abstract Archivo archivoMasNuevo();
	 public abstract Component buscar(String nombre);
	 public abstract List<Component> buscarTodos(String nombre);
	 public abstract String listadoDeContenido(String pathActual);
}
