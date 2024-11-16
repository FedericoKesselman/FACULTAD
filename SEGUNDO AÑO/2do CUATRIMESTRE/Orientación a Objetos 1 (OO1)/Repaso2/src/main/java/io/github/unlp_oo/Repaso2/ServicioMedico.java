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
}
