package io.github.unlp_oo.EJ19_OO1;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {
	private String pais;
	
	public EnvioInternacional (LocalDate fecha, String direccionOrigen, String direccionDestino, int peso, String pais) {
		super(fecha, direccionDestino, direccionDestino, peso);
		this.pais = pais;
	}
	
	public double calcularCosto() {
		if (this.getPeso() <= 1000)
			return 5000 + 10 * this.getPeso();
		
		return 5000 + 12 * this.getPeso();
	}
}
