package ar.edu.unlp.info.oo1.OO2_EJ5_PD;

import java.time.LocalDate;
import java.util.*;

public class Pelicula {
	private String titulo;
	private Integer anioEstreno;
	private List<Pelicula> similares;
	private double puntaje;
	
	public Pelicula(String titulo, int anioEstreno, double puntaje) {
		this.titulo = titulo;
		this.anioEstreno = anioEstreno;
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

	public Integer getAnioEstreno() {
		return this.anioEstreno;
	}

	public double getPuntaje() {
		return this.puntaje;
	}
}
