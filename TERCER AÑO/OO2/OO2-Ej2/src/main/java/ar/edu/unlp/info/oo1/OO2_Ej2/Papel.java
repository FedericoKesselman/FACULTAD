package ar.edu.unlp.info.oo1.OO2_Ej2;

public class Papel implements Jugada {
	
	@Override
	public String juegaContra(Jugada jugada) {
		return jugada.juegaContraPapel();
	}

	@Override
	public String juegaContraPapel() {
		return "Empate";
	}

	@Override
	public String juegaContraPiedra() {
		return "Gana papel";
	}

	@Override
	public String juegaContraTijera() {
		return "Gana tijera";
	}

	@Override
	public String juegaContraLagarto() {
		return "Gana lagarto";
	}

	@Override
	public String juegaContraSpock() {
		return "Gana papel";
	}
}
