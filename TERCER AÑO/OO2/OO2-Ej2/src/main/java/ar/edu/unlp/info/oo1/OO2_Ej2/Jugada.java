package ar.edu.unlp.info.oo1.OO2_Ej2;

public interface Jugada {
	public String juegaContraPapel();
	public String juegaContraPiedra();
	public String juegaContraTijera();
	public String juegaContraLagarto();
	public String juegaContraSpock();
	public String juegaContra(Jugada jugada);
}
