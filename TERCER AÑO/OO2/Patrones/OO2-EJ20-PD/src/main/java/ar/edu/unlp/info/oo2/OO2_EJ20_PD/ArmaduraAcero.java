package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class ArmaduraAcero implements Armadura{

	@Override
	public void recibirDano(Arma arma, Personaje personaje) {
		personaje.decrementarVida(arma.hacerDanoAcero());
	}

}
