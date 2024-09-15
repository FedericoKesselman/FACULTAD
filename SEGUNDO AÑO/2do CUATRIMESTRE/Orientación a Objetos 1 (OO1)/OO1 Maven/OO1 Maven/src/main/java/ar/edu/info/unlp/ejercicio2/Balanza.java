package ar.edu.info.unlp.ejercicio2;
import java.time.LocalDate;
import java.util.*;

public class Balanza {
	// private int cantidadDeProductos; no hace falta ahora teniendo la lista
	//private double precioTotal; idem 
	// private double pesoTotal; idem 
	private List<Producto> productos;
	
	public Balanza () {
		this.productos = new LinkedList<Producto>();
	}
	
	
	public void ponerEnCero() {
		this.productos = new LinkedList<Producto>(); // Se "reinicia" la lista de productos
	}
	
	
	public void agregarProducto (Producto producto) {
		this.productos.add(producto);
	}
	
	
	public Ticket emitirTicket() {
		return new Ticket (LocalDate.now(), productos);
	}
	
	
	public double getPesoTotal() {
		double total = 0;
		
		if (!productos.isEmpty()) {
			for (Producto producto: productos)
				total += producto.getPeso();
		}
		
		return total;
	}

	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	
	public double getPrecioTotal() {
		double total = 0;
		
		if (!productos.isEmpty()) {
			for (Producto producto: productos)
				total += producto.getPrecio();
		}
		
		return total;
	}
}
