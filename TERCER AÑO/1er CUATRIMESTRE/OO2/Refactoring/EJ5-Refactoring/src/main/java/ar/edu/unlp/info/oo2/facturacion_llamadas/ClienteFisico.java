package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteFisico extends Cliente{
	private String dni;
	private double descuento = 0;
	
	public ClienteFisico(String nombre, String numeroTelefono, String dni) {
		super(nombre, numeroTelefono);
		this.dni = dni;
	}
	
	protected double getDescuento() {
		return this.descuento;
	}
}
