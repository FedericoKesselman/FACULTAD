package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class Videojuego {
	private BuilderPersonaje builder;
	
	public Videojuego(BuilderPersonaje builder) {
		this.builder = builder;
	}
	
	public Personaje build(String nombre) {
		this.builder.setArma();
		this.builder.setArmadura();
		this.builder.setHabilidad();
		this.builder.setNombre(nombre);
		return this.builder.getPersonaje();
	}
	
	public void setBuilder(BuilderPersonaje builder) {
		this.builder = builder;
	}
}
