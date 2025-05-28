package ar.edu.unlp.info.oo1.OO2_Ej2;

public class Tijera implements Jugada{
	
	@Override
	public String juegaContra(Jugada jugada) {
		return jugada.juegaContraTijera();
	}

	@Override
	public String juegaContraPapel() {
		return "Gana tijera";
	}

	@Override
	public String juegaContraPiedra() {
		return "Gana piedra";
	}

	@Override
	public String juegaContraTijera() {
		return "Empate";
	}

	@Override
	public String juegaContraLagarto() {
		return "Gana tijera";
	}

	@Override
	public String juegaContraSpock() {
		return "Gana spock";
	}
}
