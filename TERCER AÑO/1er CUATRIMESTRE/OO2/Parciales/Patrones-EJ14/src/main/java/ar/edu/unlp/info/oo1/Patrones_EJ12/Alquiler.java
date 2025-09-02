package ar.edu.unlp.info.oo1.Patrones_EJ12;

import java.time.LocalDate;

public class Alquiler extends Bien{
	private LocalDate comienzoContrato;
	private LocalDate finContrato;
	private double costoMensual;
	
	public Alquiler(LocalDate comienzoContrato, LocalDate finContrato, double costoMensual) {
		this.comienzoContrato = comienzoContrato;
		this.finContrato = finContrato;
		this.costoMensual = costoMensual;
	}

	@Override
	public double getValor() {
		return this.costoMensual * (LocalDate.now().compareTo(finContrato)); // faltaria hacer que sea en meses
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.9;
	}

	@Override
	public void add(Bien bien) {}

	@Override
	public void remove(Bien bien) {}

}
