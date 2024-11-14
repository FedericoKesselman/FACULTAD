package io.github.unlp_oo.EJ25_OO1;
import java.time.LocalDate;


public class Vacunacion extends Consulta{
	private String nombre;
	private double costoV;
	
	public Vacunacion (String nombre, double costoV, Medico medico, LocalDate fecha, Mascota mascota) {
		super(medico, fecha, mascota);
		this.nombre = nombre;
		this.costoV = costoV;
	}
	
	public double costoMaterialDescartable() {
		return 500;
	}
	
	@Override
	public double costoServicio() {
		return this.costoConsulta() + this.costoV;
	}
}
