package io.github.unlp_oo.EJ25_OO1;
import java.time.LocalDate;
import java.util.*;

public class Mascota {
	private String nombre;
	private LocalDate fechaNac;
	private String especie;
	private List<Servicio> servicios;
	
	public Mascota (String nombre, LocalDate fechaNac, String especie) {
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.especie = especie;
		this.servicios = new LinkedList<>();
	}
	
	public void agregarServicio(Servicio s) {
		this.servicios.add(s);
	}
	
	public ConsultaMedica altaConsultaMedica (Medico medico) {
		ConsultaMedica consulta = new ConsultaMedica (medico, LocalDate.now(), this);
		this.agregarServicio(consulta);
		return consulta;
	}
	
	public Vacunacion altaVacunacion (String nomV, double costo, Medico medico) {
		Vacunacion vacunacion = new Vacunacion (nomV, costo, medico, LocalDate.now(), this);
		this.agregarServicio(vacunacion);
		return vacunacion;
	}
	
	public Guarderia altaGuarderia (int cantDias) {
		Guarderia guarderia = new Guarderia (LocalDate.now(), this, cantDias);
		this.agregarServicio(guarderia);
		return guarderia;
	}
	
	public boolean tiene5Servicios () {
		return this.servicios.size() >= 5;
	}

	public double recaudacionEnFecha (LocalDate fecha) {
		return this.servicios.stream()
				.mapToDouble (s -> s.calcularCostoEnFecha(fecha))
				.sum();
	}
}


