package ar.edu.unlp.info.oo2.OO2_EJ21_PD;

import java.util.Date;

public interface MamiferoInterface {
	public String getIdentificador();
	public void setIdentificador(String identificador);
	public String getEspecie();
	public void setEspecie(String especie);
	public Date getFechaNacimiento();
	public void setFechaNacimiento(Date fechaNacimiento);
	public MamiferoInterface getPadre();
	public void setPadre(Mamifero padre);
	public MamiferoInterface getMadre();
	public void setMadre(Mamifero madre);	
	public MamiferoInterface getAbueloMaterno();
	public MamiferoInterface getAbuelaMaterna();	
	public MamiferoInterface getAbueloPaterno();
	public MamiferoInterface getAbuelaPaterna();
	public boolean tieneComoAncestroA (Mamifero unMamifero);
}
