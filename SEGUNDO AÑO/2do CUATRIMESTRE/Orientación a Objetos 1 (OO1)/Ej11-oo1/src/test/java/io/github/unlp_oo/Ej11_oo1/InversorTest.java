package io.github.unlp_oo.Ej11_oo1;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class InversorTest {
	private Inversor inversor;
	private InversionEnAcciones acciones;
	private PlazoFijo fijo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.inversor = new Inversor("Federico");
		this.acciones = new InversionEnAcciones("MELI", 3, 20000);
		this.fijo = new PlazoFijo (LocalDate.of(2024, 10, 30), 100.0, 0.01);
	}
	
	@Test
	void testAcciones() {
		assertEquals (60000, acciones.valorActual());
	}
	
	@Test
	void testPlazoFijo() {
		// Se ejecuta a 1 dia de la fecha de constitucion. Tener en cuenta el interes compuesto
		assertEquals (101.0, fijo.valorActual());
	}
	
	@Test
	void testInversor() {
		assertEquals(0, inversor.valorInversiones());
		inversor.agregarInversion(acciones);
		assertEquals(60000, inversor.valorInversiones());
		inversor.agregarInversion(fijo);
		assertEquals(60101, inversor.valorInversiones());
	}
	
}
