package io.github.unlp_oo.Ej12_oo1;
import java.util.*;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion (List<Pieza> piezas) {
		this.piezas = piezas;
	}
	
	public double getVolumenDeMaterial (String nombreDeMaterial) {
		return piezas.stream()
				.filter(Pieza -> Pieza.getMaterial().equalsIgnoreCase(nombreDeMaterial))
				.mapToDouble(Pieza:: getVolumen)
				.sum();
	}
	
	public double superficieDeColor(String color) {
		return piezas.stream()
				.filter(Pieza -> Pieza.getColor().equalsIgnoreCase(color))
				.mapToDouble(Pieza:: getSuperficie)
				.sum();
	}
}
