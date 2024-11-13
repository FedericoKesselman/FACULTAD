package io.github.unlp_oo.EJ23_OO1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class PedidoTest {
	private Pedido pedido1;
	private Pedido pedido2;
	private Pedido pedido3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.pedido1 = new Pedido (new Contado(), new RetirarComercio(), new Producto("Movil", "Tecnologia", 100, 1), 1);
		this.pedido2 = new Pedido (new SeisCuotas(), new RetirarComercio(), new Producto("Tablet", "Tecnologia", 200, 2), 2);
		this.pedido3 = new Pedido (new Contado(), new RetirarSucursal(), new Producto("Remera", "Ropa", 50, 4), 2);
	}
	
	@Test
	void costoTotal() {
		assertEquals (100, pedido1.costoTotal());
		assertEquals (480, pedido2.costoTotal());
		assertEquals (3100, pedido3.costoTotal());
	}

}
