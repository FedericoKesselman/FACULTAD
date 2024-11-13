package io.github.unlp_oo.EJ23_OO1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PagoTest {
	private FormaPago contado;
	private FormaPago cuotas;
	
	@BeforeEach
	void setUp() {
		this.contado = new Contado();
		this.cuotas = new SeisCuotas();
	}
	
	@Test
	void adicional() {
		assertEquals(0, contado.adicionalPago(1000));
		assertEquals(0, contado.adicionalPago(200));
		assertNotEquals(1, contado.adicionalPago(200));
		
		assertEquals(200, cuotas.adicionalPago(1000));
		assertEquals(400, cuotas.adicionalPago(2000));
		assertNotEquals(201, cuotas.adicionalPago(1000));
	}

}
