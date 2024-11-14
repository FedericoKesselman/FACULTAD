package io.github.unlp_oo.EJ25_OO1;

import java.time.LocalDate;
import Ej14b.DateLapse;

public class Guarderia extends Servicio{
	private DateLapse dias;
	
	public Guarderia (LocalDate fecha, Mascota mascota, int cantDias) {
		super(fecha, mascota);
		this.dias = new DateLapse (fecha, cantDias);
	}
	
	public double costoServicio() {
		double costoDias = this.dias.sizeInDays() * 500;
		
		if (this.getMascota().tiene5Servicios())
			return costoDias * 0.9;
		else 
			return costoDias;
	}
	
	@Override
	public boolean coincideFecha(LocalDate fecha) {
		return this.dias.includesDate(fecha);
	}
}
