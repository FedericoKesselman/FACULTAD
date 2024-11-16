package io.github.unlp_oo.Repaso2;
import java.time.LocalDate;
import java.util.*;

public class Mascota {
	private String nombre, especie;
	private LocalDate fechaNac;
	private List<Servicio> servicios;
	
	public Mascota(String nombre, String especie, LocalDate fechaNac) {
		this.nombre = nombre;
		this.especie = especie;
		this.fechaNac = fechaNac;
		this.servicios = new LinkedList<>();
	}
	
	public ConsultaMedica crearConsulta(Medico medico) {
		ConsultaMedica c = new ConsultaMedica (this, LocalDate.now(), medico);
		this.servicios.add(c);
		return c;
	}
	
	public Vacunacion crearVacunacion(Medico medico, String nombreV, double costo) {
		Vacunacion v = new Vacunacion (this, LocalDate.now(), medico, nombreV, costo);
		this.servicios.add(v);
		return v;
	}
	
	public Guarderia crearGuarderia (int cantDias) {
		Guarderia g = new Guarderia (this, LocalDate.now(), cantDias);
		this.servicios.add(g);
		return g;
	}
}
