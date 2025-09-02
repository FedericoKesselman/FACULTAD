package ar.edu.unlp.info.oo1.OO2_EJ5_PD;

import java.util.*;
import java.util.stream.Collectors;

public class Decodificador {
	private List<Pelicula> grilla;
	private List<Pelicula> reproducidas;
	private Strategy estrategia;
	
	public Decodificador() {
		this.grilla = new LinkedList<>();
		this.reproducidas = new LinkedList<>();
		this.estrategia = new StrategyNovedad(); // por defecto la primera
	}
	
	public Decodificador(List<Pelicula> grilla, List<Pelicula> reproducidas) {
		this.grilla = grilla;
		this.reproducidas = reproducidas;
		this.estrategia = new StrategyNovedad(); // por defecto la primera
	}
	
	// Mejor devolver lista que string, mas facil extender comportamiento
	public List<Pelicula> sugerirPeliculas() {
		return this.estrategia.sugerirPeliculas(this);
	}
	
	public List<Pelicula> getPeliculasNoReproducidas() {
		return this.grilla.stream()
			.filter(pelicula -> !this.reproducidas.contains(pelicula))
			.collect(Collectors.toList());
	}
	
	public void setEstrategia(Strategy estrategia) {
		this.estrategia = estrategia;
	}

	public void agregarPelicula(Pelicula pelicula) {
		this.grilla.add(pelicula);
	}

	public void reproducir(Pelicula pelicula) {
		if (!this.reproducidas.contains(pelicula))
			this.reproducidas.add(pelicula);
	}

	public List<Pelicula> getGrilla() {
		return this.grilla;
	}
	
	/*
	 Se utilizó el patrón Strategy. Porque el comportamiento del decodificador al sugerir 
	 películas varía dinámicamente según un criterio configurado por el usuario, y debe
	 poder cambiarse en tiempo de ejecución.
	 */
}
