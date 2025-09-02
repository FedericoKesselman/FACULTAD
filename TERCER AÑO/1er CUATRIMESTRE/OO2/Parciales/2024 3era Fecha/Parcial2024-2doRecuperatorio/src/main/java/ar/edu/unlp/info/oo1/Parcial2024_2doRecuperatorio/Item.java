package ar.edu.unlp.info.oo1.Parcial2024_2doRecuperatorio;

public abstract class Item {
	private int espacioOcupado;
	private String nombre;
	
	public Item(int espacioOcupado, String nombre) {
		this.espacioOcupado = espacioOcupado;
		this.nombre = nombre;
	}
	
	public int getEspacioOcupado() {
		return this.espacioOcupado;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract Item buscarItem(String nombre);
	public abstract int espacioMaximo();
	public abstract int capacidadDisponible();
	
	protected abstract boolean puedeGuardar(int tamano);
	public abstract boolean guardarObjeto(Item objeto);
	
	public abstract int capacidad();
}
