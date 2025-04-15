package ar.edu.unlp.info.oo1.OO2_EJ2_PD;

public class EmpleadoPlanta extends Empleado{
	private boolean casado;
	private int cantHijos;
	private int cantAnios;

	public EmpleadoPlanta (boolean casado, int cantHijos, int cantAnios) {
		this.casado = casado;
		this.cantHijos = cantHijos;
		this.cantAnios = cantAnios;
	}

	@Override
	protected double sueldoBasico() {
		return 50000;
	}

	@Override
	protected double adicional() {
		return casado ? 5000 + 2000 * this.cantHijos + 2000 * cantAnios : 2000 * this.cantHijos + 2000 * cantAnios;
	}
}
