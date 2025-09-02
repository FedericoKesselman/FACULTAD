package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * En este caso se utilizo el TestDouble de fake, ya que se tuvo que simular el funcionamiento completo 
 * de un tanque, para poder testear el correcto funcionamiento de la clase LightMix y Purge.
 * No es Mock porque no se comprueba la validez de los mensajes recibidos y porque el FakeMixingTank tiene lógica interna real.
 */

public class TestTanque {
	private FakeMixingTank tank;
	private LightMix lightMix;
	private Purge purge;
	
	@BeforeEach
	void setUp() {
		tank = new FakeMixingTank();
		lightMix = new LightMix();
		purge = new Purge();
	}
	
	@Test
	void testLightMix() {
		lightMix.execute(tank);

        assertTrue(lightMix.isDone());
        assertEquals(20, tank.getHeatLevel());
        assertEquals(5, tank.getMixLevel());
	}
	
	@Test
	void testPurge() {
		purge.execute(tank);
		
		assertTrue(purge.isDone());
        assertEquals(0, tank.getHeatLevel());
        assertEquals(0, tank.getMixLevel());
        assertTrue(tank.isPurged());
	}
}
