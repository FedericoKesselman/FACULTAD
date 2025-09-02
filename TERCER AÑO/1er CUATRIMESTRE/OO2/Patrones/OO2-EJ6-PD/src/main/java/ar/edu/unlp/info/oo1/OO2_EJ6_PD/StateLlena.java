package ar.edu.unlp.info.oo1.OO2_EJ6_PD;

public class StateLlena extends ExcursionState{

	@Override
	public String obtenerInformacion(Excursion excursion) {
		return "";
	}

	@Override
	public void inscribir(Excursion excursion, Usuario unUsuario) {
		excursion.agregarListaEspera(unUsuario);
	}
}
