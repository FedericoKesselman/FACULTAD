package io.github.unlp_oo.EJ23_OO1;
import java.util.*;

public class Cliente extends Persona{
	private List<Pedido> pedidos;
	
	public Cliente (String nombre, String direccion) {
		super(nombre, direccion);
		this.pedidos = new LinkedList<>();
	}
	
	public void crearPedido (FormaPago pago, FormaEnvio envio, Producto pro, int cant) {
		if (!pro.disponibilidad(cant))
			return;
		
		pro.descontarStock(cant);
		pedidos.add(new Pedido(pago, envio, pro, cant));
	}
	
	
	public Map<String, Integer> productosPorCategoria() {
		Map<String, Integer> map = new HashMap<>();
		
		for (Pedido p: pedidos) {
			if (map.containsKey(p.getCategoria()))
					map.put(p.getCategoria(), map.get(p.getCategoria()) + p.getCant());
			else
					map.put(p.getCategoria(), p.getCant());
		}
		
		return map;
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}
}
