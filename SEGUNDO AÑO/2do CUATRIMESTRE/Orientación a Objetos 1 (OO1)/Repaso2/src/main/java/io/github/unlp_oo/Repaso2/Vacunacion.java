package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;

public class Vacunacion extends ServicioMedico{
	private String nombreV;
	private double costo;
	
	public Vacunacion (Mascota mascota, LocalDate fecha, Medico medico, String nombreV, double costo) {
		super(mascota, fecha, medico);
		this.nombreV = nombreV;
		this.costo = costo;
	}
	
	protected double costoMaterialDescartable() {
		return 500;
	}
	
	public double costoServicio() {
		return this.costoServicioMedico() + this.costo;
	}
}
