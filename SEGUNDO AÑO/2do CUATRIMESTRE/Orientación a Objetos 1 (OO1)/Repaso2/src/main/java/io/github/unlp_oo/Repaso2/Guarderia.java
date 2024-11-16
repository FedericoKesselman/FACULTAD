package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;
import Ej14b.DateLapse;

public class Guarderia extends Servicio{
	private DateLapse periodo;
	
	public Guarderia (Mascota mascota, LocalDate fechaI, int cantDias) {
		super(mascota);
		this.periodo = new DateLapse(fechaI, cantDias);
	}
	
	public double costoServicio() {
		double costo = periodo.sizeInDays() * 500;
		
		if (this.getMascota().utilizo5servicios())
			return costo * 0.9;
		else
			return costo;
	}
	
	public boolean cumpleFecha(LocalDate fecha) {
		return this.periodo.includesDate(fecha);
	}
}
