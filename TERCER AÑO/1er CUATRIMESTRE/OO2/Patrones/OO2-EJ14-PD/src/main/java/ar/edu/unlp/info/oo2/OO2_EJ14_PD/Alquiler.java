package ar.edu.unlp.info.oo2.OO2_EJ14_PD;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Alquiler extends Prenda{
	private LocalDate comienzoContracto;
	private LocalDate finContrato;
	private double costoMensual;

	public Alquiler(LocalDate comienzoContracto, LocalDate finContrato, double costoMensual) {
		this.comienzoContracto = comienzoContracto;
		this.finContrato = finContrato;
		this.costoMensual = costoMensual;
	}

	@Override
	public double getValor() {
	    long mesesRestantes = ChronoUnit.MONTHS.between(LocalDate.now(), finContrato);
	    return mesesRestantes > 0 ? mesesRestantes * costoMensual : 0.0;
	}

	@Override
	public double getLiquidez() {
		return 0.9;
	}

	@Override
	public void agregarPrenda(Prenda prenda) {
	}

	@Override
	public List<Prenda> obtenerPrendas(Prenda prenda) {
		return null;
	}
}
