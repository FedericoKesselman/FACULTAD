package io.github.unlp_oo.EJ23_OO1;

public class Pedido {
	private FormaPago pago;
	private FormaEnvio envio;
	private Producto pro;
	private int cant;
	
	public Pedido (FormaPago pago, FormaEnvio envio, Producto pro, int cant) {
		this.pago = pago;
		this.envio = envio;
		this.pro = pro;
		this.cant = cant;
	}
	
	public String getCategoria() {
		return pro.getCategoria();
	}
	
	public int getCant() {
		return this.cant;
	}
	
	public double costoTotal() {
		double precio = pro.getPrecio() * this.cant;
		
		return precio + pago.adicionalPago(precio) + envio.adicionalEnvio();
	}
}
