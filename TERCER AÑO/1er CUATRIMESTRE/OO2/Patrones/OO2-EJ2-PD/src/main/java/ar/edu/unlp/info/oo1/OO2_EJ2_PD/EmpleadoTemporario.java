package ar.edu.unlp.info.oo1.OO2_EJ2_PD;

public class EmpleadoTemporario extends Empleado{
	private int cantHoras;
	private boolean casado;
	private int cantHijos;
	
	public EmpleadoTemporario(int cantHoras, boolean casado, int cantHijos) {
		this.cantHoras = cantHoras;
		this.casado = casado;
		this.cantHijos = cantHijos;
	}

	@Override
	protected double sueldoBasico() {
		return 20000 + this.cantHoras * 300;
	}

	@Override
	protected double adicional() {
		return casado ? 5000 + 2000 * this.cantHijos : 2000 * this.cantHijos;
	}
}
