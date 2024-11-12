package io.github.unlp_oo.EJ20_OO1;
import java.time.LocalDate;
import java.util.*;


public class Empleado {
	private String nombre;
	private String apellido;
	private int CUIL;
	private LocalDate fechaNacimiento;
	private boolean hijos;
	private boolean conyuge;
	private List<Contrato> contratos;
	
	
	public Empleado(String nombre, String apellido, int cUIL, LocalDate fechaNacimiento, boolean hijos, boolean conyuge) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		CUIL = cUIL;
		this.fechaNacimiento = fechaNacimiento;
		this.hijos = hijos;
		this.conyuge = conyuge;
	}
	
	
	public boolean isHijos() {
		return hijos;
	}


	public void setHijos(boolean hijos) {
		this.hijos = hijos;
	}


	public boolean isConyuge() {
		return conyuge;
	}


	public void setConyuge(boolean conyuge) {
		this.conyuge = conyuge;
	}


	public List<Contrato> getContratos() {
		return this.contratos;
	}
	
	
	public Contrato contratoVigente() {
		return contratos.stream()
				.filter (c -> c.isActivo())
				.findFirst().orElse(null);
	}
	
	
	public void agregarContrato (Contrato contrato) {
		if (this.contratoVigente() == null) // o si lo quiere arear despues
			contratos.add(contrato);
	}
	
	
	public int antiguedad() {
		return contratos.stream()
				.mapToInt(c -> c.duracion())
				.sum();
	}
	
	
	public ReciboSueldo generarRecibo() {
		if (this.contratoVigente() == null)
			return null;
		
		return new ReciboSueldo (this.nombre, this.apellido, this.CUIL, this.antiguedad(), 
				LocalDate.now(), this.contratoVigente().montoContrato(this));
			}
	
	
	
}
