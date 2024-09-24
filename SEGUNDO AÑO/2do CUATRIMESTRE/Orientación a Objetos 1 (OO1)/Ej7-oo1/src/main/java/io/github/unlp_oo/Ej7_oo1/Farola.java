package io.github.unlp_oo.Ej7_oo1;
import java.util.*;

public class Farola {
	private boolean prendida;
	private List<Farola> vecinas;
	
	public Farola() {
		this.prendida = false;
		this.vecinas = new LinkedList<Farola>();
	}
	
	public boolean isOn() {
		return this.prendida;
	}
	
	public boolean isOff() {
		return !this.prendida;
	}
	
	
	public void pairWithNeighbor (Farola otraFarola) {
		if (!vecinas.contains(otraFarola)) {
			vecinas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	
	public List<Farola> getNeighbors() {
		return this.vecinas;
	}
	
	
	public void turnOn() {
		if (!prendida) {
			prendida = true;
			
			for (Farola F: this.vecinas) {
				F.turnOn();
			}
		}
	}
	
	
	public void turnOff() {
		if (prendida) {
			prendida = false;
			
			for (Farola F: this.vecinas) {
				F.turnOff();
			}
		}
	}
	
	
}
