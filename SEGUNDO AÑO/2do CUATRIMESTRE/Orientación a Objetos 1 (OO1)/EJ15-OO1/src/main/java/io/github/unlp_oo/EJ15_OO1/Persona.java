package io.github.unlp_oo.EJ15_OO1;

import java.util.*;

public class Persona {
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;
	
	public Persona (String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		consumos = new LinkedList<Consumo> ();
	}
	
	public void agregarConsumo (Consumo consumo) {
		this.consumos.add(consumo);
	}
	
	public Factura emitirFactura (CuadroTarifario tarifa) {
		Consumo ultConsumo = consumos.get(consumos.size()-1);
		double montoFinal = ultConsumo.montoEnergiaAciva(tarifa.getKWh());
		double bonificacion = 0;
		
		if (ultConsumo.bonificacion())
			bonificacion = montoFinal * 0.1;
		
		return new Factura(this, bonificacion, montoFinal);
	}
}
