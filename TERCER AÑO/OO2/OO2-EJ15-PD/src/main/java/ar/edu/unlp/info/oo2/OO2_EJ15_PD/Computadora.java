package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

import java.util.*;

public class Computadora {
	private List<Componente> componentes;
	
	public Computadora() {
		this.componentes = new LinkedList<>();
	}
	
	public double consumo() {
		return this.componentes.stream()
				.mapToDouble(c -> c.getConsumo())
				.sum();
	}
	
	public double precio() {
		return this.componentes.stream()
				.mapToDouble(c -> c.getPrecio())
				.sum();
	}
	
	public void setProcesador(Componente com) {
		this.componentes.add(com);
	}
	
	public void setMemoriaRAM(Componente com) {
		this.componentes.add(com);
	}	
	public void setDisco(Componente com) {
		this.componentes.add(com);
	}
	
	public void setTarjetaGrafica(Componente com) {
		this.componentes.add(com);
	}
	public void setGabinete(Componente com) {
		this.componentes.add(com);
	}
	protected void add(Componente com) {
		this.componentes.add(com);
	}
}
