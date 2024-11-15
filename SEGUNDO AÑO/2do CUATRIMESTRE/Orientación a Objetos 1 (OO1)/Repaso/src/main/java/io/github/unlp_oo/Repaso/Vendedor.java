package io.github.unlp_oo.Repaso;
import java.util.*;

public class Vendedor extends Usuario{
	private List<Producto> productos;
	
	public Vendedor (String nombre, String direccion) {
		super(nombre, direccion);
		this.productos = new LinkedList<>();
	}
}
