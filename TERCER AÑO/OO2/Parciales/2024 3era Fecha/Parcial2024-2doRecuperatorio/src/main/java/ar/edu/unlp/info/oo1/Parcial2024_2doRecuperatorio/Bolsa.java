package ar.edu.unlp.info.oo1.Parcial2024_2doRecuperatorio;

import java.util.*;

public class Bolsa extends Item{
	private List<Item> elementos;
	private int capacidad;
	private int espacioOcupado;

	public Bolsa(String nombre, int capacidad) {
		super(1, nombre);
		this.elementos = new LinkedList<>();
		this.capacidad = capacidad;
		this.espacioOcupado = 0;
	}

	@Override
	public Item buscarItem(String nombre) {
		if (this.getNombre().equals(nombre))
			return this;
		else
			return this.elementos.stream()
				.map(e -> e.buscarItem(nombre))
				.filter(Objects::nonNull)
				.findFirst()
				.orElse(null);
	}

	@Override
	public int espacioMaximo() {
	    int maxInterno = this.elementos.stream()
	        .mapToInt(Item::espacioMaximo) // recursivo
	        .max()
	        .orElse(0);

	    return Math.max(this.capacidad(), maxInterno);
	}


	@Override
	public int capacidadDisponible() {
		return this.elementos.stream()
				.mapToInt(e -> e.capacidadDisponible())
				.sum() + this.capacidad() - this.espacioOcupado;
	}

	@Override
	protected boolean puedeGuardar(int tamano) {
		return this.capacidad() >= tamano;
	}

	@Override
	public boolean guardarObjeto(Item objeto) {
	    if (this.add(objeto))
	    	return true;

	    return this.elementos.stream()
	        .map(e -> e.guardarObjeto(objeto))
	        .findFirst()
	        .orElse(false);
	}
	
	public int capacidad() {
		return this.capacidad - this.espacioOcupado;
	}
	
	public boolean add(Item item) {
		if (this.puedeGuardar(item.getEspacioOcupado())) {
			this.elementos.add(item);
			this.espacioOcupado += item.getEspacioOcupado();
			return true;
		}
		return false;
	}
}
