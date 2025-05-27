package ar.edu.unlp.info.oo1.OO2_EJ9_PD;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class PoliticaModerada extends PoliticaCancelacion{

	@Override
	public double montoAReembolsar(Reserva reserva) {
		long dias = ChronoUnit.DAYS.between(LocalDate.now(), reserva.getFecha());
		
		if (dias >= 7) return reserva.montoAPagar();
		if (dias >= 2) return reserva.montoAPagar() * 0.5;
		return 0.0;
	}
}
