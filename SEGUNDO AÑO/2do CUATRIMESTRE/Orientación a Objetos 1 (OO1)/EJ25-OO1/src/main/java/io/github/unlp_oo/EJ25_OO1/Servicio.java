package io.github.unlp_oo.EJ25_OO1;
import java.time.LocalDate;

public abstract class Servicio {
	private Mascota mascota;
	private LocalDate fecha;
	
	public Servicio (LocalDate fecha, Mascota mascota) {
		this.fecha = fecha;
		this.mascota = mascota;
	}
	
	public abstract double costoServicio();
	
	public Mascota getMascota() {
		return this.mascota;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public boolean coincideFecha(LocalDate fecha) {
		return this.fecha.equals(fecha);
	}
	
	public double calcularCostoEnFecha (LocalDate fecha) {
		if (this.coincideFecha(fecha))
			return this.costoServicio();
		return 0;
	}
}
