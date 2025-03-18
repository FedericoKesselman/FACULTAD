package io.github.unlp_oo.ParcialOO1;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import Ej14b.DateLapse;

public class Usuario {
	private String nombre;
	private List<Entrada> entradas;
	
	public Usuario (String nombre) {
		this.nombre = nombre;
		this.entradas = new LinkedList<>();
	}
	
	public Entrada comprarEntrada(Evento evento, boolean seguro) {
		Entrada e = new Entrada (evento, evento.precioEvento(LocalDate.now()), LocalDate.now(), seguro);
		this.entradas.add(e);
		return e;
	}
	
	public double precioEnPeriodo (LocalDate fechaI, LocalDate fechaF) {
		DateLapse periodo = new DateLapse (fechaI, Period.between(fechaI, fechaF).getDays());
		return entradas.stream()
				.filter(e -> periodo.includesDate(e.fecha()))
				.mapToDouble(e -> e.precio())
				.sum();
	}
	
	public Entrada entradaSiguiente() {
		return entradas.stream()
				.min((e1, e2) -> Integer.compare(e1.diasHasta(), e2.diasHasta()))
				.orElse(null);
	}
}
