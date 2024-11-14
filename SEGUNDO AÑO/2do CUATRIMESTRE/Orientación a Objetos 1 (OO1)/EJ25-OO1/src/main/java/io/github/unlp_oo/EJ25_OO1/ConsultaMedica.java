package io.github.unlp_oo.EJ25_OO1;
import java.time.LocalDate;

public class ConsultaMedica extends Consulta{
	public ConsultaMedica (Medico medico, LocalDate fecha, Mascota mascota) {
		super (medico, fecha, mascota);
	}
	
	public double costoMaterialDescartable() {
		return 300;
	}
	
	@Override
	public double costoServicio() {
		return this.costoConsulta() + this.antiguedadMedico() * 100;
	}
}
