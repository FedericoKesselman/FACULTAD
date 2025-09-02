package ar.edu.unlp.info.oo2.OO2_EJ21_PD;

import java.util.Date;

public class Mamifero implements MamiferoInterface{
	private String identificador;
	private String especie;
	private Date fechaNacimiento;
	private MamiferoInterface padre;
	private MamiferoInterface madre;
	
	public Mamifero (String identificador) {
		this.identificador = identificador;
		this.padre = new MamiferoNull();
		this.madre = new MamiferoNull();
	}
	
	public Mamifero() {}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public MamiferoInterface getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public MamiferoInterface getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	
	public MamiferoInterface getAbueloMaterno() {
		return this.madre.getPadre();
	}
	
	public MamiferoInterface getAbuelaMaterna() {
		return this.madre.getMadre();
	}
	
	
	public MamiferoInterface getAbueloPaterno() {
		return this.padre.getPadre();
	}
	
	public MamiferoInterface getAbuelaPaterna() {
		return this.padre.getMadre();
	}
	
	
	public boolean tieneComoAncestroA (Mamifero unMamifero) {
		if ( (this.padre == unMamifero) || (this.madre == unMamifero) )
			return true;
		if ( (this.padre.tieneComoAncestroA(unMamifero)) || (this.madre.tieneComoAncestroA(unMamifero)) )
			return true;
		return false;
	}
}





























