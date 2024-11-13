package io.github.unlp_oo.EJ23_OO1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.*;

public class ClienteTest {
	private Cliente cliente;
	
	@BeforeEach 
	void setUp() throws Exception {
		this.cliente = new Cliente ("Federico", "123");
		cliente.crearPedido(new Contado(), new RetirarComercio(), new Producto("Movil", "Tecnologia", 100, 1), 1);
		cliente.crearPedido(new SeisCuotas(), new RetirarComercio(), new Producto("Tablet", "Tecnologia", 200, 2), 3);
	}
	
	@Test
	void testPedido() {
		assertEquals(1, cliente.getPedidos().size());
		cliente.crearPedido(new Contado(), new RetirarComercio(), new Producto("Movil", "Tecnologia", 100, 2), 1);
		assertEquals(2, cliente.getPedidos().size());
	}
	
	@Test
	void testCategorias() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Tecnologia", 1);
		assertEquals (map, cliente.productosPorCategoria());
		
		cliente.crearPedido(new Contado(), new RetirarComercio(), new Producto("Movil", "Tecnologia", 100, 2), 2);
		map.put("Tecnologia", 2);
		assertNotEquals (map, cliente.productosPorCategoria());
		
		map.put("Tecnologia", 3);
		assertEquals (map, cliente.productosPorCategoria());
	}
	

}
