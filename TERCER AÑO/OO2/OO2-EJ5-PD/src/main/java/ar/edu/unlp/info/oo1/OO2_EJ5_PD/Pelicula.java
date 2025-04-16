package ar.edu.unlp.info.oo1.OO2_EJ5_PD;

import java.time.LocalDate;
import java.util.*;

public class Pelicula {
	private String titulo;
	private LocalDate fechaEstreno;
	private List<Pelicula> similares;
	private double puntaje;
	
	public Pelicula(String titulo, LocalDate fechaEstreno, double puntaje) {
		this.titulo = titulo;
		this.fechaEstreno = fechaEstreno;
		this.puntaje = puntaje;
		this.similares = new LinkedList<>();
	}
	
	public void agregarSimilar(Pelicula pelicula) {
		if (!this.similares.contains(pelicula)) {
			this.similares.add(pelicula);
			
			pelicula.agregarSimilar(this); // simetria
		}
	}
	
	public List<Pelicula> getSimilares() {
		return this.similares;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public LocalDate getFechaEstreno() {
		return this.fechaEstreno;
	}

	public double getPuntaje() {
		return this.puntaje;
	}
}
