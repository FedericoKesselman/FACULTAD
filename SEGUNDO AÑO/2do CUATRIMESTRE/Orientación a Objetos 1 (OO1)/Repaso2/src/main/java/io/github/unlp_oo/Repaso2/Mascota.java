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
	
	public ConsultaMedica crearVacunacion(Medico medico) {
		ConsultaMedica c = new ConsultaMedica (this, LocalDate.now(), medico);
		this.servicios.add(c);
		return c;
	}
}
