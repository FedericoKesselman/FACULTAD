package io.github.unlp_oo.EJ23_OO1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class EnvioTest {
	private FormaEnvio retiroComercio;
	private FormaEnvio retiroSucursal;
	private FormaEnvio domicilio;
	
	@BeforeEach
	void setUp() {
		this.retiroComercio = new RetirarComercio();
		this.retiroSucursal = new RetirarSucursal();
		this.domicilio = new Domicilio ("Calle 123", "Calle 321");
	}
	
	@Test
	void costos() {
		assertEquals(0, retiroComercio.adicionalEnvio());
		assertNotEquals(1, retiroComercio.adicionalEnvio());
		
		assertEquals(3000, retiroSucursal.adicionalEnvio());
		assertNotEquals(3001, retiroSucursal.adicionalEnvio());
		
		assertEquals(50, domicilio.adicionalEnvio());
		assertNotEquals(51, domicilio.adicionalEnvio());
	}
}
