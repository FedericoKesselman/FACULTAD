package ar.edu.unlp.info.oo1.OO2_EJ2_PD;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmpleadoTemporarioTest {
	private Empleado e1, e2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.e1 = new EmpleadoTemporario(100, true, 0);
		this.e2 = new EmpleadoTemporario(100, false, 1);
	}
	
	@Test
	void testSueldoBasico() {
		assertEquals(this.e1.sueldo(), 48250);
		assertEquals(this.e2.sueldo(), 45400);
	}
}
