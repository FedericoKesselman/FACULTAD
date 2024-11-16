package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;

public class Medico {
	private String nombre;
	private LocalDate fechaI;
	private double honorarios;
	
	public Medico (String nombre, LocalDate fechaI, double honorarios) {
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.honorarios = honorarios;
	}
	
	public double getHonorarios() {
		return this.honorarios;
	}
	
	public int antiguedad() {
		return LocalDate.now().getYear() - this.fechaI.getYear();
	}
}
