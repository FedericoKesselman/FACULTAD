package io.github.unlp_oo.EJ23_OO1;
import java.util.*;

public class Vendedor extends Persona{
	private List<Producto> productos;
	
	public Vendedor (String nombre, String direccion) {
		super(nombre, direccion);
		this.productos = new LinkedList<>();
	}
}
