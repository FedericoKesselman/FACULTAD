package io.github.unlp_oo.Ej11_oo1;
import java.util.*;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor (String nombre) {
		this.nombre = nombre;
		this.inversiones = new LinkedList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarInversion(Inversion inversion) {
		this.inversiones.add(inversion);
	}
	
	public double valorInversiones() {
		double total = 0;
		
		for (Inversion i: inversiones)
			total += i.valorActual();
	
		return total;
	}
	
	
}
