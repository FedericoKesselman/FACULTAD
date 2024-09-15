package io.github.unlp_oo.ej3;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.fecha = LocalDate.now();
		this.cliente = cliente;
		this.items = new LinkedList<Item>();
	}
	
	public void agregarItem (Item item) {
		if (item != null)
			this.items.add(item);
	}
	
	public double calcularTotal() {
		double total = 0;
		
		if (!items.isEmpty()) {
			for (Item item: items)
				total += item.costo();
		}
		
		return total;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	
}
