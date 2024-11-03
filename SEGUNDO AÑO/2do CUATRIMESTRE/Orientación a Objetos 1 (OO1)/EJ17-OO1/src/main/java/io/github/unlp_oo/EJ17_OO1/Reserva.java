package io.github.unlp_oo.EJ17_OO1;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Ej14b.DateLapse;

public class Reserva {
	private Usuario usuario;
	private DateLapse periodo;
	
	public Reserva(Usuario usuario, double precioNoche, DateLapse periodo) {
        this.usuario = usuario;
        this.periodo = periodo;
	}
    
    
    public boolean isDisponible (DateLapse fechas) {
    	return !periodo.overlaps(fechas);
    }
   
    public int cantDias() {
    	return this.periodo.sizeInDays();
    }
    
    public LocalDate fechaInicio () {
    	return periodo.getFrom();
    }
}
