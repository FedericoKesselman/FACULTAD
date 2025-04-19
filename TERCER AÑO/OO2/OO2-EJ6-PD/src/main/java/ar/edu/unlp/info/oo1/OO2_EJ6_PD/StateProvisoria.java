package ar.edu.unlp.info.oo1.OO2_EJ6_PD;

public class StateProvisoria extends ExcursionState{

	@Override
	public String obtenerInformacion(Excursion excursion) {
		return "Faltantes cupo minimo: " + excursion.faltantesCupoMinimo();
	}

	@Override
	public void inscribir(Excursion excursion, Usuario unUsuario) {
		excursion.agregarInscripto(unUsuario);
		if (excursion.cumpleMinimo())
			excursion.setEstado(new StateDefinitiva());
	}
}
