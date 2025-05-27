package ar.edu.unlp.info.oo1.OO2_EJ6_PD;

import java.time.LocalDate;
import java.util.*;

public class Excursion {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	private List<Usuario> inscriptos;
	private List<Usuario> listaEspera;
	private ExcursionState estado;
	
	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo,
			int cupoMinimo, int cupoMaximo) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoEncuentro = puntoEncuentro;
		this.costo = costo;
		this.cupoMinimo = cupoMinimo;
		this.cupoMaximo = cupoMaximo;
		this.inscriptos = new LinkedList<Usuario>();
		this.listaEspera = new LinkedList<Usuario>();
		this.estado = new StateProvisoria();
	}
	
	public String obtenerInformacion() {
		return this.toString() + this.estado.obtenerInformacion(this);
	}
	
	public void inscribir(Usuario unUsuario) {
		this.estado.inscribir(this, unUsuario);
	}
	
	protected void agregarInscripto(Usuario u) {
		this.inscriptos.add(u);
	}
	
	protected void agregarListaEspera(Usuario u) {
		this.listaEspera.add(u);
	}
	
	public String toString() {
		return "Nombre: " + this.nombre + "\n"
					+ "Costo: " + this.costo + "\n"
					+ "Fecha de Inicio: " + this.fechaInicio + "\n"
					+ "Fecha de Fin: " + this.fechaFin + "\n"
					+ "Punto de Encuentro: " + this.puntoEncuentro + "\n";
	}
	
	protected int faltantesCupoMinimo() {
		return this.inscriptos.size() < this.cupoMinimo ? this.cupoMinimo - this.inscriptos.size() : 0; 
	}
	
	protected int faltantesCupoMaximo() {
		return this.inscriptos.size() < this.cupoMaximo ? this.cupoMaximo - this.inscriptos.size() : 0; 
	}
	
	protected boolean cumpleMinimo() {
		return this.inscriptos.size() >= this.cupoMinimo;
	}
	
	protected boolean cumpleMaximo() {
		return this.inscriptos.size() == this.cupoMaximo;
	}
	
	protected void setEstado(ExcursionState estado) {
		this.estado = estado;
	}
	
	protected String mailsDeInscriptos() {
		StringBuilder mails = new StringBuilder();
		this.inscriptos.stream()
			.forEach(usuario -> mails.append(usuario.getEmail()).append("\n"));
		return mails.toString();
	}

	public ExcursionState getState() {
		return this.estado;
	}
	
	protected List<Usuario> getListaEspera() {
		return this.listaEspera;
	}
}
