package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class Baston implements Arma{

	@Override
	public int hacerDanoCuero() {
		return 2;
	}

	@Override
	public int hacerDanoAcero() {
		return 1;
	}

	@Override
	public int hacerDanoHierro() {
		return 1;
	}
}
