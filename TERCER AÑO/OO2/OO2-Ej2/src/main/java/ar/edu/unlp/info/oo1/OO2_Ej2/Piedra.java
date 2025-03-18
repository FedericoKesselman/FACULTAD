package ar.edu.unlp.info.oo1.OO2_Ej2;

public class Piedra implements Jugada {
	
	@Override
	public String juegaContra(Jugada jugada) {
		return jugada.juegaContraPiedra();
	}

	@Override
	public String juegaContraPapel() {
		return "Gana papel";
	}

	@Override
	public String juegaContraPiedra() {
		return "Empate";
	}

	@Override
	public String juegaContraTijera() {
		return "Gana piedra";
	}

	@Override
	public String juegaContraLagarto() {
		return "Gana piedra";
	}

	@Override
	public String juegaContraSpock() {
		return "Gana spock";
	}	
}
