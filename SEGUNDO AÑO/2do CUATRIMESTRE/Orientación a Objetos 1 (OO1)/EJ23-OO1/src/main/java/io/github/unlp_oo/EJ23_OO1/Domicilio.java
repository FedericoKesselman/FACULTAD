package io.github.unlp_oo.EJ23_OO1;

public class Domicilio implements FormaEnvio{
	private String domicilioVendedor;
	private String domicilioComprador;

	public Domicilio (String domicilioVendedor, String domicilioComprador) {
		this.domicilioVendedor = domicilioVendedor;
		this.domicilioComprador = domicilioComprador;
	 }
	  
	public double adicionalEnvio() {
		return CalculadoraDeDistancia.distanciaEntre(domicilioVendedor, domicilioComprador) * 0.5;
	}
}
