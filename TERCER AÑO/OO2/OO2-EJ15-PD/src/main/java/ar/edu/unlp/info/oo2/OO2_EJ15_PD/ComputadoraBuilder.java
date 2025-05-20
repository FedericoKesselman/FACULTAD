package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

public abstract class ComputadoraBuilder {
	private Computadora computadora;
	
	public void reset() {
		this.computadora = new Computadora();
	}
	
	public Computadora getComputadora() {
		return this.computadora;
	}
	
	public abstract void setProcesador();
	public abstract void setRAM();
	public abstract void setDisco();
	public abstract void setTarjeta();
	public abstract void setGabinete();
}
