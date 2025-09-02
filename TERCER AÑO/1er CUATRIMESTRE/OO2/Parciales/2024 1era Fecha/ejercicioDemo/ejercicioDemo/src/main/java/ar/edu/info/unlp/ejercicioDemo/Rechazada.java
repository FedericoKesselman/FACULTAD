package ar.edu.info.unlp.ejercicioDemo;

public class Rechazada implements EstadoPrestamo{

	@Override
	public void pagarCuota(Prestamo context) {
		throw new Error("Prestamo rechazado.");
	}

	@Override
	public double montoCancelacion(Prestamo context) {
		throw new Error("Prestamo rechazado");
	}

}
