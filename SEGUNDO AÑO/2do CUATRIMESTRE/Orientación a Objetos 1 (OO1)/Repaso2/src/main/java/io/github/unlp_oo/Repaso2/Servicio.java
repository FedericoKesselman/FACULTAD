package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;

public abstract class Servicio {
	private Mascota mascota;
	
	public Servicio (Mascota mascota) {
		this.mascota = mascota;
	}
}
