package io.github.unlp_oo.EJ17y18_OO1;
import java.util.*;
import Ej14b.DateLapse;
import java.time.LocalDate;

public class Propiedad {
	private String direccion;
	private String nombre;
	private double precio;
	private List<Reserva> reservas;
	private PoliticaCancelacion politica;
	
	
	public Propiedad (String direccion, String nombre, double precio, PoliticaCancelacion politica) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.precio = precio;
		this.reservas = new LinkedList<Reserva>();
		this.politica = politica;
	}
	
	
	public List<Reserva> getReservas() {
		return this.reservas;
	}
	
	
	public boolean estaDisponible (LocalDate fechaInicial, LocalDate fechaFinal) {
		return reservas.stream()
				.allMatch(reserva -> reserva.isDisponible( new DateLapse(fechaInicial, fechaFinal)) );
		// .allMatch(...) para verificar que todas las reservas existentes son compatibles con el nuevo período (isDisponible es true para todas).
	}
	
	
	public boolean crearReserva (Usuario usuario, LocalDate fechaInicial, LocalDate fechaFinal) {
		if (this.estaDisponible (fechaInicial, fechaFinal)) {
			reservas.add(new Reserva(usuario, precio, new DateLapse(fechaInicial, fechaFinal) ));
			return true;
		}
		return false;
	}
	
	
	public double precioReserva (Reserva reserva) {
		return reserva.cantDias() * precio;
	}
	
	
	public double cancelarReserva(Reserva reserva) {
		
	    if (LocalDate.now().isBefore(reserva.fechaInicio()) && reservas.contains(reserva)) {
	    	reservas.remove(reserva);
	    	return politica.calcularReembolso(reserva.getPeriodo(), precio);
	    }
	    
	    return 0.0;
	}
	
	
	public double precioReservasEnPeriodo (DateLapse periodo) {
		return reservas.stream()
				.filter(reserva -> !reserva.isDisponible(periodo)) 
	            .mapToDouble(reserva -> this.precioReserva(reserva)) 
	            .sum(); 
	}
	
}











