package ar.edu.unlp.info.oo1.OO2_EJ2_PD;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoPasanteTest {
	private Empleado e1;
	
	@BeforeEach
	void setUp() throws Exception {
		this.e1 = new EmpleadoPasante(3);
	}
	
	@Test
	void testSueldoBasico() {
		assertEquals(this.e1.sueldo(), 23100);
	}
}
