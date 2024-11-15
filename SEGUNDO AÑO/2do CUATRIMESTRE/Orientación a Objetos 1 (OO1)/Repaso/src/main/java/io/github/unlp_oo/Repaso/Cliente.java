package io.github.unlp_oo.Repaso;
import java.util.*;

import io.github.unlp_oo.EJ21_O1.BagImpl;


public class Cliente extends Usuario{
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		this.pedidos = new LinkedList<>();
	}

	public void crearPedido(FormaPago pago, FormaEnvio envio, Producto p, int cant) {
		if (p.hayStock(cant)) {
			p.descontarStock(cant);
			pedidos.add(new Pedido(pago, envio, p, cant));
		}
	}
	
	public BagImpl<String> productosPorCategoria() {
		BagImpl<String> bag = new BagImpl<String>();
		
		this.pedidos.stream()
			.forEach(p -> bag.add(p.categoriaProducto()));
		
		return bag;
	}
}
