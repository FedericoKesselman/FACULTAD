package io.github.unlp_oo.EJ25_OO1;
import java.time.LocalDate;

public abstract class Consulta extends Servicio{
	private Medico medico;
	
	public Consulta (Medico medico, LocalDate fecha, Mascota mascota) {
		super (fecha, mascota);
		this.medico = medico;
	}
	
	public double honorariosMedico() {
		return this.medico.getHonorarios();
	}
	
	public double calcularDomingo() {
		if (this.getFecha().getDayOfWeek().getValue() == 7)
			return 200;
		return 0;
	}
	
	public abstract double costoMaterialDescartable();
	
	public double costoConsulta() {
		return this.honorariosMedico() + this.calcularDomingo() + this.costoMaterialDescartable();
	}
	
	public Medico getMedico() {
		return this.medico;
	}
}
