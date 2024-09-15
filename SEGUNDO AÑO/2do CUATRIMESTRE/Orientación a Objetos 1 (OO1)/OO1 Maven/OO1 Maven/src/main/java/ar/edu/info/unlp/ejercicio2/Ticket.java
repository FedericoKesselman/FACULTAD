package ar.edu.info.unlp.ejercicio2;
import java.time.LocalDate;
import java.util.*;

public class Ticket {
	private LocalDate fecha;
	// private int cantidadDeProductos;
	// private double pesoTotal;
	// private double precioTotal;
	private List<Producto> productos;
	
	
	public Ticket(LocalDate fecha, List<Producto> productos) {
		this.fecha = fecha;
		//this.cantidadDeProductos = cantidadDeProductos;
		//sthis.pesoTotal = pesoTotal;
		// this.precioTotal = precioTotal;
		this.productos = new LinkedList<Producto>();
		
		for (Producto producto : productos) {
            this.productos.add(new Producto(producto)); 
            // En ticket hay que guardar una copia porque se tiene que mantener los valores al momento de la compra
            // En la balanza si hay que cambiarlos y tienen que tener los actuales
        }
	}

	
	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}

	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	
	public double getPesoTotal() {
		double total = 0;
		
		if (!productos.isEmpty()) {
			for (Producto producto: productos)
				total += producto.getPeso();
		}
		
		return total;
	}


	public double getPrecioTotal() {
		double total = 0;
		
		if (!productos.isEmpty()) {
			for (Producto producto: productos)
				total += producto.getPrecio();
		}
		
		return total;
	}

	
	public LocalDate getFecha() {
		return fecha;
	}


}
