package io.github.unlp_oo.Repaso;

public class Pedido {
	private FormaPago pago;
	private FormaEnvio envio;
	private Producto producto;
	private int cant;
	
	public Pedido(FormaPago pago, FormaEnvio envio, Producto producto, int cant) {
		this.pago = pago;
		this.envio = envio;
		this.producto = producto;
		this.cant = cant;
	}
	
	public int getCant() {
		return this.cant;
	}
	
	public String categoriaProducto() {
		return producto.getCategoria();
	}
	
	public double costoTotal() {
		double costo = producto.getPrecio() * cant;
		return costo + pago.adicionalPago(costo) + envio.adicionalEnvio();
	}
	
	
}
