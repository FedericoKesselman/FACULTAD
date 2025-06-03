package ar.edu.unlp.info.oo2.OO2_EJ21_PD;

import java.util.Date;

public class MamiferoNull implements MamiferoInterface{

	@Override
	public String getIdentificador() {
		return "";
	}

	@Override
	public void setIdentificador(String identificador) {}

	@Override
	public String getEspecie() {
		return "";
	}

	@Override
	public void setEspecie(String especie) {}

	@Override
	public Date getFechaNacimiento() {
		return null;
	}

	@Override
	public void setFechaNacimiento(Date fechaNacimiento) {}

	@Override
	public MamiferoInterface getPadre() {
		return this;
	}

	@Override
	public void setPadre(Mamifero padre) {}

	@Override
	public MamiferoInterface getMadre() {
		return this;
	}

	@Override
	public void setMadre(Mamifero madre) {}

	@Override
	public MamiferoInterface getAbueloMaterno() {
		return this;
	}

	@Override
	public MamiferoInterface getAbuelaMaterna() {
		return this;
	}

	@Override
	public MamiferoInterface getAbueloPaterno() {
		return this;
	}

	@Override
	public MamiferoInterface getAbuelaPaterna() {
		return this;
	}

	@Override
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return false;
	}
}
