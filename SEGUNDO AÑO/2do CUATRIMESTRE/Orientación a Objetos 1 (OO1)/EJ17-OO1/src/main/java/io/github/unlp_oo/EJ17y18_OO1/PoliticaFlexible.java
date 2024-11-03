package io.github.unlp_oo.EJ17y18_OO1;

import Ej14b.DateLapse;

public class PoliticaFlexible implements PoliticaCancelacion {
	
	public double calcularReembolso(DateLapse periodo, double precio) {
		return periodo.sizeInDays() * precio;
	}
}
