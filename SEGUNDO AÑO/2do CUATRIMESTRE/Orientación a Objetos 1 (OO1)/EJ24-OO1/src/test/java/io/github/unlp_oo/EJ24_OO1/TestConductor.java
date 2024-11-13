package io.github.unlp_oo.EJ24_OO1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestConductor {
	private Conductor c1;
	private Vehiculo v1 = new Vehiculo(c1, "va", 5, 2020, 76000);
	private Conductor c2;
	private Vehiculo v2 = new Vehiculo(c2, "va", 5, 2010, 76000);
	
	@BeforeEach
	void setUp() throws Exception {
		this.c1 = new Conductor ("Federico", 0, v1);
		this.c2 = new Conductor ("Juan", 0, v2);
	}
	
	@Test
	void testCargarSaldo() {
		c1.cargarSaldo(1000);
		assertEquals (c1.getSaldo(), 990);
		
		c2.cargarSaldo(1000);
		assertEquals (c2.getSaldo(), 900);
	}
}
