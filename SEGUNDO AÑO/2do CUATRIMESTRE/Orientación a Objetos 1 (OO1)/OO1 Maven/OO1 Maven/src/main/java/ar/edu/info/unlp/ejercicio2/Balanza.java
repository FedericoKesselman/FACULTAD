package ar.edu.info.unlp.ejercicio2;
import java.time.LocalDate;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	public void agregarProducto (Producto producto) {
		this.cantidadDeProductos++;
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
	}
	
	public Ticket emitirTicket() {
		Ticket ticket = new Ticket ();
		
		ticket.setFecha(LocalDate.now());
		ticket.setCantidadDeProductos(this.cantidadDeProductos);
		ticket.setPrecioTotal(this.precioTotal);
		ticket.setPesoTotal(this.pesoTotal);
		
		return ticket;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
}
