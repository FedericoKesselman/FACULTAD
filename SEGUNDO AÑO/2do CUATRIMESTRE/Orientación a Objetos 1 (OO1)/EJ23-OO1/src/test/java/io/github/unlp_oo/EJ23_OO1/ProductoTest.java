package io.github.unlp_oo.EJ23_OO1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ProductoTest {
	private Producto producto1;
	
	@BeforeEach
	void setUp() {
		this.producto1 = new Producto("Tablet", "Tecnologia", 200, 4);
	}
	
	@Test
	void testDisponibilidad() {
		assertTrue (producto1.disponibilidad(2));
		assertTrue (producto1.disponibilidad(4));
		assertFalse (producto1.disponibilidad(5));
	}
	
	@Test
	void testDescontarStock() {
		producto1.descontarStock(2);
		assertTrue (producto1.disponibilidad(2));
		assertFalse (producto1.disponibilidad(3));
	}
}
