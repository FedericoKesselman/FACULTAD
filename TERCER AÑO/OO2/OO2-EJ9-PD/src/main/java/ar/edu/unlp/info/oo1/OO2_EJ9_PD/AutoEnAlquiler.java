package ar.edu.unlp.info.oo1.OO2_EJ9_PD;

public class AutoEnAlquiler {
	private double precioPorDia;
	private int cantidadPiezas;
	private String marca;
	private PoliticaCancelacion politica;
	
	public AutoEnAlquiler(double precioPorDia, int cantidadPiezas, String marca, PoliticaCancelacion politica) {
		this.precioPorDia = precioPorDia;
		this.cantidadPiezas = cantidadPiezas;
		this.marca = marca;
		this.politica = politica;
	}
	
	public double getPrecioPorDia() {
		return this.precioPorDia;
	}
	
	public PoliticaCancelacion getPolitica() {
		return this.politica;
	}
	
	public void setPolitica (PoliticaCancelacion politica) {
		this.politica = politica;
	}
}
