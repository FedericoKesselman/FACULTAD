package ar.edu.unlp.info.oo2.OO2_EJ20_PD;

public class BuilderArquero extends BuilderPersonaje{

	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new ArmaduraCuero());
	}

	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Arco());
	}

	@Override
	public void setHabilidad() {
		this.getPersonaje().setHabilidad("Especialistas en disparos");
	}

}
