package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;

public abstract class ServicioMedico extends Servicio{
	private Medico medico;
	private LocalDate fecha;
	
	public ServicioMedico (Mascota mascota, LocalDate fecha, Medico medico) {
		super(mascota);
		this.medico = medico;
		this.fecha = fecha;
	}
	
	protected double costoServicioMedico() {
		return this.medico.getHonorarios() + this.calcularDomingo() + this.costoMaterialDescartable();
	}
	
	private double calcularDomingo() {
		if (this.fecha.getDayOfWeek().getValue() == 7)
			return 200;
		else 
			return 0;
	}
	
	protected abstract double costoMaterialDescartable();
	
	protected Medico getMedico() {
		return this.medico;
	}
	
	public boolean cumpleFecha(LocalDate fecha) {
		return this.fecha.equals(fecha);
	}
}
