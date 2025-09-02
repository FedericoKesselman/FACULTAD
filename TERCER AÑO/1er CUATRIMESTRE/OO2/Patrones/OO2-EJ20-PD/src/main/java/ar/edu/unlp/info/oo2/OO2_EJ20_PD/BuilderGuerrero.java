package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class BuilderGuerrero extends BuilderPersonaje{

	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new ArmaduraCuero());
	}

	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Espada());
	}

	@Override
	public void setHabilidad() {
		this.getPersonaje().setHabilidad("Combate cuerpo a cuerpo");
		
	}

}
