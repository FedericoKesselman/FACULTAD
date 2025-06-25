package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private GeneradorEstrategia estrategia = new EstrategiaUltimo();
	
	public SortedSet<String> getLineas() {
		return lineas;
	}

	public String obtenerNumeroLibre() {
		String linea = this.estrategia.obtenerNumeroLibre(this.lineas);
		this.lineas.remove(linea);
		return linea;
	}
	
	public boolean agregarNumeroTelefono(String str) {
		if (!this.existeLinea(str)) {
			this.lineas.add(str);
			return true;
		}
		else 
			return false;
	}
	
	protected boolean existeLinea(String linea) {
		return this.lineas.contains(linea);
	}

	public void cambiarTipoGenerador(String valor) {
		switch (valor) {
		case "ultimo": this.estrategia = new EstrategiaUltimo();
		case "primero": this.estrategia = new EstrategiaPrimero();
		case "random": this.estrategia = new EstrategiaRandom();
		}
	}
}
