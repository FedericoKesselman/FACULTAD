package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class Personaje {
	private String nombre;
	private int vida;
	private Arma arma;
	private Armadura armadura;
	private String habilidad;
	
	public void atacar(Personaje rival) {
		if(this.estaVivo() && rival.estaVivo()) 
			rival.recibirGolpe(arma);
	}	
	
	public void recibirGolpe(Arma arma) {
		this.armadura.recibirDano(arma, this);
	}
	
	public boolean estaVivo() {
		return this.vida > 0;
	}
	
	public void decrementarVida(int valor) {
		this.vida -= valor;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}
	
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
}
