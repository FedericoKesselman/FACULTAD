package ar.edu.info.unlp.ejercicioDemo;

public class Finalizada implements EstadoPrestamo{
	@Override
	public void pagarCuota(Prestamo context) {
		throw new Error("Prestamo finalizado");
	}

	@Override
	public double montoCancelacion(Prestamo context) {
		return 0.0;
	}

}
