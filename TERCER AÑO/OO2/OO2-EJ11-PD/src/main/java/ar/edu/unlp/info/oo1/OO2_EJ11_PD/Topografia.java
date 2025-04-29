package ar.edu.unlp.info.oo1.OO2_EJ11_PD;
import java.util.*;

public abstract class Topografia {
	public abstract double proporcionAgua();
	
	public double proporcionTierra() {
		return 1 - this.proporcionAgua();
	}
	
	public List<Topografia> getComponentes() {
		List<Topografia> lista = new LinkedList<>();
		lista.add(this);
        return lista;
    }
	
	// ---
	public boolean isEquals(Topografia topografia) {
		return this.getComponentes().equals(topografia.getComponentes()); // comparación estructural
	}
	
	@Override // del equals de java
	public boolean equals(Object objeto) {
		return this.isEquals((Topografia)objeto); 
	}
}
