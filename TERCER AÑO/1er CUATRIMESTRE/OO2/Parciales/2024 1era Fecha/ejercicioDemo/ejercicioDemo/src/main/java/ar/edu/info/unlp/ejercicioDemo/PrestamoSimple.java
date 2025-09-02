package ar.edu.info.unlp.ejercicioDemo;

public class PrestamoSimple extends Prestamo{
	private double tasaInteres;

	public PrestamoSimple(double monto, int cantCuotas, Cliente cliente, double tasaInteres) {
		super(monto, cantCuotas, cliente);
		this.tasaInteres = tasaInteres;
	}

	@Override
	protected double montoSellado() {
		return 5000;
	}

	@Override
	protected double getInteres() {
		return this.tasaInteres;
	}

}
