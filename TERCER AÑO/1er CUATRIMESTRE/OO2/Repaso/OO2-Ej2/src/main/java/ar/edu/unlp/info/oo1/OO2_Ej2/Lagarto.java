package ar.edu.unlp.info.oo1.OO2_Ej2;

public class Lagarto implements Jugada{
	
	@Override
	public String juegaContra(Jugada jugada) {
		return jugada.juegaContraLagarto();
	}

	@Override
	public String juegaContraPapel() {
		return "Gana lagarto";
	}

	@Override
	public String juegaContraPiedra() {
		return "Gana piedra";
	}

	@Override
	public String juegaContraTijera() {
		return "Gana tijera";
	}

	@Override
	public String juegaContraLagarto() {
		return "Empate";
	}

	@Override
	public String juegaContraSpock() {
		return "Gana lagarto";
	}

}
