package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class BuilderThoor extends BuilderPersonaje{

	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new ArmaduraHierro());
	}

	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Martillo());
	}

	@Override
	public void setHabilidad() {
		this.getPersonaje().setHabilidad("Lanzar rayos y combate a distancia");
	}

}
