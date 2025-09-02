package ar.edu.unlp.info.oo2.OO2_EJ18_PD;

import java.time.LocalDate;

public class Archivo implements FileManager{
	private String nombre;
	private String extension;
	private double tamano;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private int permisos;
	
	public Archivo(String nombre, String extension, double tamano, LocalDate fechaCreacion, LocalDate fechaModificacion,
			int permisos) {
		this.nombre = nombre;
		this.extension = extension;
		this.tamano = tamano;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.permisos = permisos;
	}
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String prettyPrint() {
		return this.getNombre();
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getExtension() {
		return this.extension;
	}

	@Override
	public double getTamano() {
		return this.tamano;
	}

	@Override
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}

	@Override
	public LocalDate getFechaModificacion() {
		return this.fechaModificacion;
	}

	@Override
	public int getPermisos() {
		return this.permisos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
