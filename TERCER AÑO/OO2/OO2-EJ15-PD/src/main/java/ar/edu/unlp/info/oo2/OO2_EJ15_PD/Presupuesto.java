package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

import java.time.LocalDate;

public class Presupuesto {
	private Director director;
	private String nombreCliente;
	private LocalDate fecha;
	
	public Presupuesto(ComputadoraBuilder builder, String nombreCliente) {
		this.director = new Director(builder);
		this.fecha = LocalDate.now();
		this.nombreCliente = nombreCliente;
	}

	public Computadora getComputadora() {
		return this.director.build();
	}
}
