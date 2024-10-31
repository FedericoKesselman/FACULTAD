package io.github.unlp_oo.Test_EJ9;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	private CuentaCorriente cuenta;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cuenta = new CuentaCorriente();
	}
	
	@Test
	void testConstructor() {
		assertEquals(0, cuenta.getDescubierto());
	}
	
	@Test
    void testDescubierto() {
		cuenta.setDescubierto(1000);
		assertTrue(cuenta.puedeExtraer(1000));
	}
	
	
}
