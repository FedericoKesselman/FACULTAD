package io.github.unlp_oo.EJ17y18_OO1;
import java.time.LocalDate;

import Ej14b.DateLapse;


public class PoliticaModerada implements PoliticaCancelacion {
	
	public double calcularReembolso(DateLapse periodo, double precio) {
        LocalDate unaSemanaAntes = periodo.getFrom().minusDays(7);
        LocalDate dosDiasAntes = periodo.getFrom().minusDays(2);
        
        if (LocalDate.now().isBefore(unaSemanaAntes)) 
            return periodo.sizeInDays() * precio; 
        
        if (LocalDate.now().isBefore(dosDiasAntes)) 
            return periodo.sizeInDays() * (precio * 0.5); 
        
        return 0.0; // reembolso se realiza 1 dia antes
	}
}
