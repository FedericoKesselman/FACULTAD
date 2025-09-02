package ar.edu.unlp.info.oo1.OO2_Ej2;

public class Spock implements Jugada{
	
	@Override
	public String juegaContra(Jugada jugada) {
		return jugada.juegaContraSpock();
	}

	@Override
	public String juegaContraPapel() {
		return "Gana papel";
	}

	@Override
	public String juegaContraPiedra() {
		return "Gana spock";
	}

	@Override
	public String juegaContraTijera() {
		return "Gana spock";
	}

	@Override
	public String juegaContraLagarto() {
		return "Gana lagarto";
	}

	@Override
	public String juegaContraSpock() {
		return "Empate";
	}

}
