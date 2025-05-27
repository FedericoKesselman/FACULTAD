package ar.edu.unlp.info.oo1.OO2_EJ6_PD;

public class StateDefinitiva extends ExcursionState{

	@Override
	public String obtenerInformacion(Excursion excursion) {
		return "Mails inscriptos: " + excursion.mailsDeInscriptos() + 
				"Faltantes cupo maximo: " + excursion.faltantesCupoMaximo();
	}

	@Override
	public void inscribir(Excursion excursion, Usuario unUsuario) {
		excursion.agregarInscripto(unUsuario);
		if (excursion.cumpleMaximo())
			excursion.setEstado(new StateLlena());
	}
}
