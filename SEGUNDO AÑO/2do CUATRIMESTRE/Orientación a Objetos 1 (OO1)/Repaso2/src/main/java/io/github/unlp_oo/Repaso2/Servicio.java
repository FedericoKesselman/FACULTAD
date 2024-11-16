package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;

public abstract class Servicio {
	private Mascota mascota;
	
	public Servicio (Mascota mascota) {
		this.mascota = mascota;
	}
	
	public Mascota getMascota() {
		return this.mascota;
	}
	
	public abstract double costoServicio();
	public abstract boolean cumpleFecha (LocalDate fecha);
	
	public double recaudadoEnFecha(LocalDate fecha) {
		if (this.cumpleFecha(fecha))
			return this.costoServicio();
		else 
			return 0;
	}
}
