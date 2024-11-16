package io.github.unlp_oo.Repaso2;

import java.time.LocalDate;

public class ConsultaMedica extends ServicioMedico{
	public ConsultaMedica (Mascota mascota, LocalDate fecha, Medico medico) {
		super(mascota, fecha, medico);
	}
}
