package ar.edu.info.unlp.ejercicioDemo;

public class Aceptada implements EstadoPrestamo{

	@Override
	public void pagarCuota(Prestamo context) {
		context.incrementarCuotasPagadas();
		context.increcrementarMontoPagado();
		if (context.getMontoRestante() == 0)
			context.setEstado(new Finalizada());
	}

	@Override
	public double montoCancelacion(Prestamo context) {
		return context.calcularMontoCancelacion();
	}

}
