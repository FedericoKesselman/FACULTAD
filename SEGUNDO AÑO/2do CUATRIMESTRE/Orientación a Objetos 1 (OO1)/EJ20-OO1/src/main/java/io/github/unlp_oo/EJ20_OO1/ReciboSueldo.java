package io.github.unlp_oo.EJ20_OO1;

import java.time.LocalDate;

public class ReciboSueldo {
	private String nombre;
	private String apellido;
	private int CUIL;
	private int antiguedad;
	private LocalDate fecha;
	private double monto;
	
	public ReciboSueldo(String nombre, String apellido, int CUIL, int antiguedad, LocalDate fecha, double monto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.antiguedad = antiguedad;
		this.fecha = fecha;
		this.monto = monto;
	}
	
}
