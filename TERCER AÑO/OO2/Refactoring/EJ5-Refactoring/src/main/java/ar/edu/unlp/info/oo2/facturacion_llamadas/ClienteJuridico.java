package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteJuridico extends Cliente{
	private String cuit;
	private double descuento = 0.15;
	
	public ClienteJuridico(String nombre, String numeroTelefono, String cuit) {
		super(nombre, numeroTelefono);
		this.cuit = cuit;
	}

	@Override
	protected double getDescuento() {
		return this.descuento;
	}
}
