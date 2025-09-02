package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class Arco implements Arma{

	@Override
	public int hacerDanoCuero() {
		return 5;
	}

	@Override
	public int hacerDanoAcero() {
		return 2;
	}

	@Override
	public int hacerDanoHierro() {
		return 3;
	}

}
