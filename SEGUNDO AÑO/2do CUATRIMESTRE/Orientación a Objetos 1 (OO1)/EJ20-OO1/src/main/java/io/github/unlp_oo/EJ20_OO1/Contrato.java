package io.github.unlp_oo.EJ20_OO1;
import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate fechaInicio;
	
	public Contrato(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	
	private double montoAntiuedad(Empleado e) {
		int ant = e.antiguedad();
		
		if (ant >= 5 && ant < 10)
			return 1.3;
		else if (ant >= 10 && ant < 15)
			return 1.5;
		else if (ant >= 15 && ant < 20)
			return  1.7;
		else 
			return 2;
	}
	
	public double montoContrato(Empleado e) {
		return this.montoBasico(e) * this.montoAntiuedad(e);
		
	}
	
	public abstract boolean isActivo();
	public abstract double montoBasico (Empleado e);
	public abstract int duracion();
}
