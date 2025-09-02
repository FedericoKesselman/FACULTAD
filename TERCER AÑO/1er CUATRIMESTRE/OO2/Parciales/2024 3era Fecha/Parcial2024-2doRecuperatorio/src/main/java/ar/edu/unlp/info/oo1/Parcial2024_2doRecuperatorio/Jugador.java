package ar.edu.unlp.info.oo1.Parcial2024_2doRecuperatorio;

public class Jugador {
	private String nombre;
	private Bolsa bolsaInicial;
	
	public Jugador(String nombre, int capacidad) {
		this.nombre = nombre;
		this.bolsaInicial = new Bolsa("Bolsa 1", capacidad);
	}
	
	public boolean guardarObjeto(Item item) {
		return this.bolsaInicial.guardarObjeto(item);
	}
	
	public int espacioMaximo() {
		return this.bolsaInicial.espacioMaximo();
	}
	
	public int capacidadDisponible() {
		return this.bolsaInicial.capacidadDisponible();
	}
	
	public Item buscarItem(String nombre) {
		return this.buscarItem(nombre);
	}
	
	public boolean add(Item item) {
		return this.bolsaInicial.add(item);
	}
}
