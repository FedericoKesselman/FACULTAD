package io.github.unlp_oo.Ej11_oo1;
import java.time.LocalDate;


public class PlazoFijo implements Inversion {
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo (LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	
	public double valorActual() {
		int cantDias = this.fechaDeConstitucion.until(LocalDate.now()).getDays();

		return this.montoDepositado * Math.pow(1 + this.porcentajeDeInteresDiario, cantDias);
		// Aplicar interes compuesto
	}
	
	
}
