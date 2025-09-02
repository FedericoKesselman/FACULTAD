package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public abstract class BuilderPersonaje {
	private Personaje personaje;
	
	public void reset() {
		this.personaje = new Personaje();
	}
	
	public abstract void setArmadura();
	public abstract void setArma();
	public abstract void setHabilidad();
	
	public void setNombre(String nombre) {
		this.personaje.setNombre(null);
	}
	
	public Personaje getPersonaje() {
		return this.personaje;
	}
}
