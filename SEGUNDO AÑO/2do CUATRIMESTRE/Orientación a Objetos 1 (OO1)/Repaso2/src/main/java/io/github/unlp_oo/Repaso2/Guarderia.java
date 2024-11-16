package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;
import Ej14b.DateLapse;

public class Guarderia extends Servicio{
	private DateLapse periodo;
	
	public Guarderia (Mascota mascota, LocalDate fechaI, int cantDias) {
		super(mascota);
		this.periodo = new DateLapse(fechaI, cantDias);
	}
}
