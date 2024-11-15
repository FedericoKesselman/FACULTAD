package io.github.unlp_oo.Repaso;

public class Domicilio implements FormaEnvio{
	private String direccionVendedor;
	private String direccionCliente;
	
	public Domicilio (String direccionVendedor, String direccionCliente) {
		this.direccionVendedor = direccionVendedor;
		this.direccionCliente = direccionCliente;
	}
	
	public double adicionalEnvio () {
		return CalculadoraDeDistancia.distanciaKm(direccionVendedor, direccionCliente) * 0.5;
	}
}
