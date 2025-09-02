package ar.edu.unlp.info.oo2.OO2_EJ14_PD;
import java.util.*;

public abstract class Prenda {

	public abstract double getValor();
	public abstract double getLiquidez();
	public abstract void agregarPrenda(Prenda prenda);
	public abstract List<Prenda> obtenerPrendas(Prenda prenda);
	
	public double calcularValor() {
		return this.getValor() * this.getLiquidez();
	}
}
