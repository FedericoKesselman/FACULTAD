package io.github.unlp_oo.EJ15_OO1;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
	Persona per1, per2;
	CuadroTarifario cuadro;
	
	@BeforeEach
	void setUp() throws Exception {
		cuadro = new CuadroTarifario(10);
		per1 = new Persona("Juan", "123");
		per2 = new Persona("Pedro", "321");
		
		per1.agregarConsumo(new Consumo(10, 10));
		per2.agregarConsumo(new Consumo(30, 20));
	}
	
	
	@Test
	void testFactura() {
		Factura factura1 = per1.emitirFactura(cuadro);
		Factura factura2 = per2.emitirFactura(cuadro);
		
		assertEquals(per1, factura1.getUsuario());
		assertEquals(LocalDate.now(), factura1.getFechaEmision());
		assertEquals(100 ,factura1.getMonto());
		assertFalse(factura1.isBonificacion());
		
		assertTrue(factura2.isBonificacion());
	}

}
