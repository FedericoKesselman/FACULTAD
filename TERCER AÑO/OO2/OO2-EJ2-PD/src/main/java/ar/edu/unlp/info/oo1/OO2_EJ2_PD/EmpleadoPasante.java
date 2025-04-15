package ar.edu.unlp.info.oo1.OO2_EJ2_PD;

public class EmpleadoPasante extends Empleado{
	private int cantExamenes;

	public EmpleadoPasante(int cantExamenes) {
		this.cantExamenes = cantExamenes;
	}

	@Override
	protected double sueldoBasico() {
		return 20000;
	}

	@Override
	protected double adicional() {
		return this.cantExamenes * 2000;
	}
}
