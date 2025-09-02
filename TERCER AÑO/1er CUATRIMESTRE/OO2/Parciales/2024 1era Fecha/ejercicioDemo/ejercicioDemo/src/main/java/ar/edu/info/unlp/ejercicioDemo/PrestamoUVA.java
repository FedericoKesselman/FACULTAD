package ar.edu.info.unlp.ejercicioDemo;

public class PrestamoUVA extends Prestamo{

	public PrestamoUVA(double monto, int cantCuotas, Cliente cliente) {
		super(monto, cantCuotas, cliente);
	}

	@Override
	protected double getInteres() {
		// return Indec.getIndiceInflacion();
		return 0;
	}

	@Override
	protected double montoSellado() {
		return 0;
	}
}
