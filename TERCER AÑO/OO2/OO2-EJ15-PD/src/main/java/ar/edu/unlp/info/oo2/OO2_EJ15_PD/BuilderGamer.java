package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

public class BuilderGamer extends ComputadoraBuilder{
	public void setProcesador() {
		this.getComputadora().setProcesador(Catalogo.getComponente("Procesador Gamer"));
		this.getComputadora().add(Catalogo.getComponente("Pad térmico"));
		this.getComputadora().add(Catalogo.getComponente("Cooler"));
	}

	@Override
	public void setRAM() {
		this.getComputadora().setMemoriaRAM(Catalogo.getComponente("32 GB"));
		this.getComputadora().setMemoriaRAM(Catalogo.getComponente("32 GB"));
	}

	@Override
	public void setDisco() {
		this.getComputadora().setDisco(Catalogo.getComponente("SSD 500gb"));
		this.getComputadora().setDisco(Catalogo.getComponente("SSD 1TB"));
	}

	@Override
	public void setTarjeta() {
		this.getComputadora().setTarjetaGrafica(Catalogo.getComponente("RTX 4090"));
	}
	
	public void setGabinete() {
		this.getComputadora().setGabinete(Catalogo.getComponente("Gabinete gamer"));
		double consumo = this.getComputadora().consumo();
		String fuente = "fuente " + (consumo + consumo * 0.5) + " w";
		this.getComputadora().add(Catalogo.getComponente(fuente));
	}

}
