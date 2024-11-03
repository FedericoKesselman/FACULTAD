package io.github.unlp_oo.EJ19_OO1;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio {
	private int km;
	
	public EnvioInterurbano (LocalDate fecha, String direccionOrigen, String direccionDestino, int peso, int km) {
		super(fecha, direccionDestino, direccionDestino, peso);
		this.km = km;
	}
	
	public double calcularCosto() {
		if (this.km < 100)
			return 20 * this.getPeso();
		
		if (this.km < 500)
			return 25 * this.getPeso();
		
		return 30 * this.getPeso();
	}
	
	
	/*
	 public double calcularCosto(CuadroTarifario cuadro) {
	 	return cuadroTarifario.getCostoEnvioInterurbano(this.km, this.getPeso());
	 }
	 */
}
