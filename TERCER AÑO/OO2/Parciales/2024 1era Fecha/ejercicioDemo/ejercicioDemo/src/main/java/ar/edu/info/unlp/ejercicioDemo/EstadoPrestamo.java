package ar.edu.info.unlp.ejercicioDemo;

public interface EstadoPrestamo {
	public abstract void pagarCuota(Prestamo context);
	public abstract double montoCancelacion(Prestamo context);
}
