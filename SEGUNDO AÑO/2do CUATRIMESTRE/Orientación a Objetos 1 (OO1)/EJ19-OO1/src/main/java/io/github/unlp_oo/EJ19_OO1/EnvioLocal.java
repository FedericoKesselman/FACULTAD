package io.github.unlp_oo.EJ19_OO1;

import java.time.LocalDate;

public class EnvioLocal extends Envio {
	private boolean entregaRapida;
	
	public EnvioLocal (LocalDate fecha, String direccionOrigen, String direccionDestino, int peso, boolean entregaRapida) {
		super(fecha, direccionDestino, direccionDestino, peso);
		this.entregaRapida = entregaRapida;
	}
	
	
	public double calcularCosto() {
		if (!this.entregaRapida)
			return 1000;
		else
			return 1500;
	}
	
	
	/*
	 public double calcularCosto(CuadroTarifario cuadro) {
	 	return cuadroTarifario.getCostoEnvioLocal(this.entregaRapida);
	 }
	 */
}
