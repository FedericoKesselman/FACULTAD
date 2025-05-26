package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

public class Director {
	private ComputadoraBuilder builder;
	
	public Director(ComputadoraBuilder builder) {
		this.builder = builder;
	}
	
	public void setBuilder(ComputadoraBuilder builder) {
		this.builder = builder;
	}
	
	public Computadora build() {
		this.builder.reset();
		this.builder.setProcesador();
		this.builder.setRAM();
		this.builder.setDisco();
		this.builder.setTarjeta();
		this.builder.setGabinete();
		return this.builder.getComputadora();
	}
}
