package io.github.unlp_oo.EJ17_OO1;
import java.util.*;
import java.time.LocalDate;

public class Propiedad {
	private String direccion;
	private String nombre;
	private double precio;
	private List<Reserva> reservas;
	
	
	public boolean estaDisponible (LocalDate fechaInicio, LocalDate fechaFin) {
		for (Reserva reserva: reservas) {
			if (!reserva.isDisponible(fechaInicio, fechaFin))
				return false;
		}
		return true;
	}
	
	
	public boolean crearReserva (Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin) {
		if (this.estaDisponible (fechaInicio, fechaFin)) {
			reservas.add(new Reserva(usuario, precio, fechaInicio, fechaFin));
			return true;
		}
		return false;
	}
	
	
	public double precioReserva (LocalDate fechaInicio) {
		// busca la reserva a partir de la fecha de inicio de la misma
		for (Reserva reserva: reservas) {
			if (reserva.fechaInicio().equals(fechaInicio))
				return reserva.getPrecioReserva();
		}
		return -1;
	}
	
	
	public void cancelarReserva (LocalDate fechaInicio) {
		for (Reserva reserva: reservas) {
			if (reserva.fechaInicio().equals(fechaInicio))
				reservas.remove(reserva);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
