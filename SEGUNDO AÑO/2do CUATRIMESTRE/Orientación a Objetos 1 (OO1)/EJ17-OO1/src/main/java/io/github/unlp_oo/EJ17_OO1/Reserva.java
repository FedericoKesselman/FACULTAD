package io.github.unlp_oo.EJ17_OO1;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Ej14b.DateLapse;

public class Reserva {
	private Usuario usuario;
	private DateLapse periodo;
	private double precioReserva;
	
	
	public Reserva(Usuario usuario, double precioNoche, LocalDate date1, LocalDate date2) {
        this.usuario = usuario;
        
        int cantidadDias = (int) ChronoUnit.DAYS.between(date1, date2);
        this.periodo = new DateLapse(date1, cantidadDias);
        this.precioReserva = precioNoche * periodo.sizeInDays();
	}
    
    
    public boolean isDisponible (LocalDate date1, LocalDate date2) {
    	return !periodo.includesDate(date1) && !periodo.includesDate(date2);
    }
    
    
    public double getPrecioReserva() {
    	return this.precioReserva;
    }
    
    
    public LocalDate fechaInicio () {
    	return periodo.getFrom();
    }
    
    
}
