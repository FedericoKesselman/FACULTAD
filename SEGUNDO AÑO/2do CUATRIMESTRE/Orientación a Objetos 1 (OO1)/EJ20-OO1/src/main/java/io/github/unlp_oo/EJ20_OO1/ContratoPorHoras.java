package io.github.unlp_oo.EJ20_OO1;
import java.time.LocalDate;

public class ContratoPorHoras extends Contrato{
	private double valorPorHora;
	private int cantHoras;
	private LocalDate fechaFin;
	
	
	public boolean isActivo() {
		return this.fechaFin.isAfter(LocalDate.now());
	}
}
