package ar.edu.unlp.info.oo1.Parcial2024_2doRecuperatorio;

public class Objeto extends Item{

	public Objeto(int espacioOcupado, String nombre) {
		super(espacioOcupado, nombre);
	}

	@Override
	public Item buscarItem(String nombre) {
		if (nombre.equals(this.getNombre()))
			return this;
		return null;
	}

	@Override
	public int espacioMaximo() {
		return 0;
	}

	@Override
	public int capacidadDisponible() {
		return 0;
	}

	@Override
	protected boolean puedeGuardar(int tamano) {
		return false;
	}

	@Override
	public boolean guardarObjeto(Item objeto) {
		return false;
	}

	@Override
	public int capacidad() {
		return 0;
	}
}
