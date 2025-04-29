package ar.edu.unlp.info.oo1.OO2_EJ9_PD;

public class PoliticaFlexible extends PoliticaCancelacion{

	@Override
	public double montoAReembolsar(Reserva reserva) {
		return reserva.montoAPagar();
	}
}
