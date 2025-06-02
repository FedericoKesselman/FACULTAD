package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class PrestamoTest {
	private Banco banco;
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		this.banco = new Banco(0.05);
		this.cliente = new Cliente("Federico", 5000);
	}
	
	@Test
	void testPrestamo() {
		Prestamo prestamo = this.banco.solicitarPrestamoSimple(10, 100, cliente);
		assertEquals(prestamo.valorCuota(), 10.5);
		assertEquals(prestamo.getMontoRestante(), 105);
		assertEquals(prestamo.montoCancelacion(), 5115.5);
	}
}
