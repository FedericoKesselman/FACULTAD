package io.github.unlp_oo.EJ24_OO1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestVehiculo {
	private Vehiculo v;
	private Conductor d = new Conductor("Baltazar", 500, v);
	
	@BeforeEach
	void setUp() throws Exception {
		this.v = new Vehiculo(d, "va", 5, 2020, 76000);
	}
	
	@Test
	void testVehiculo() {
		assertTrue (v.esModerno());
		assertEquals (v.getDueno(), d);
		
		assertTrue (v.hayCapacidad(3));
		assertTrue (v.hayCapacidad(5));
		
		assertEquals (760, v.bonificacion());
	}
}
