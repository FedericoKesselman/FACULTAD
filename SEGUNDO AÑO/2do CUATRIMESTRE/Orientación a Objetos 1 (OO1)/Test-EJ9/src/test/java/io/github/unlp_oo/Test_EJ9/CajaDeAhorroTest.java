package io.github.unlp_oo.Test_EJ9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CajaDeAhorroTest {
	private CajaDeAhorro caja, caja2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.caja = new CajaDeAhorro();
		this.caja2 = new CajaDeAhorro();
	}
	
    @Test
	void testConstructor() {
		assertEquals(0, caja.getSaldo());
	}
    
    @Test
    void testDepositar() {
    	caja.depositar(1000);
    	assertEquals(980, caja.getSaldo());
    	assertTrue(caja.puedeExtraer(960.4));
    	assertFalse(caja.puedeExtraer(961));
    }
    
    @Test
    void testTransferencia() {
    	caja.depositar(1000);
    	caja.transferirACuenta(980, caja2);
    	// System.out.print(caja2.getSaldo());
    	assertEquals(960.4, caja2.getSaldo());
    }
    
    
    
}
