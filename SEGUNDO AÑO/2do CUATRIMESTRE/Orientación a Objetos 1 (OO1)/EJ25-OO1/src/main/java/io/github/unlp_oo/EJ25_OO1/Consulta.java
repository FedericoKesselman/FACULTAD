package io.github.unlp_oo.EJ25_OO1;
import java.time.LocalDate;

public abstract class Consulta extends Servicio{
	private Medico medico;
	
	public Consulta (Medico medico, LocalDate fecha, Mascota mascota) {
		super (fecha, mascota);
		this.medico = medico;
	}
	
	protected double honorariosMedico() {
		return this.medico.getHonorarios();
	}
	
	protected abstract double costoMaterialDescartable();
	
	protected double calcularDomingo() {
		if (this.getFecha().getDayOfWeek().getValue() == 7)
			return 200;
		return 0;
	}
	
	protected double costoConsulta() {
		return this.honorariosMedico() + this.costoMaterialDescartable() + this.calcularDomingo();
	}
	
	protected int antiguedadMedico() {
		return this.medico.antiguedad();
	}
}
