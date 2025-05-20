package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

public class BuilderBasico extends ComputadoraBuilder{

	@Override
	public void setProcesador() {
		this.getComputadora().setProcesador(Catalogo.getComponente("Procesador Basico"));
	}

	@Override
	public void setRAM() {
		this.getComputadora().setMemoriaRAM(Catalogo.getComponente("8 GB"));
	}

	@Override
	public void setDisco() {
		this.getComputadora().setDisco(Catalogo.getComponente("HDD 500 GB"));
	}

	@Override
	public void setTarjeta() {
	}

	@Override
	public void setGabinete() {
		this.getComputadora().setGabinete(Catalogo.getComponente("Gabinete Estándar"));
	}
}
