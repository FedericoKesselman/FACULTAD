package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

public class BuilderIntermedio extends ComputadoraBuilder{
	public void setProcesador() {
		this.getComputadora().setProcesador(Catalogo.getComponente("Procesador Intermedio"));
	}

	@Override
	public void setRAM() {
		this.getComputadora().setMemoriaRAM(Catalogo.getComponente("16 GB"));
	}

	@Override
	public void setDisco() {
		this.getComputadora().setDisco(Catalogo.getComponente("SDD 500 GB"));
	}

	@Override
	public void setTarjeta() {
		this.getComputadora().setTarjetaGrafica(Catalogo.getComponente("GTX 1650"));
	}

	@Override
	public void setGabinete() {
		this.getComputadora().setGabinete(Catalogo.getComponente("Gabinete Intermedio"));
		this.getComputadora().add(Catalogo.getComponente("Fuente 800 W"));
	}
}
