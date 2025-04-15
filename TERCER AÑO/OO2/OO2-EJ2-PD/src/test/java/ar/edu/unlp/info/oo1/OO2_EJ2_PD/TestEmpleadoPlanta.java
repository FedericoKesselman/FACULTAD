package ar.edu.unlp.info.oo1.OO2_EJ2_PD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEmpleadoPlanta {
private Empleado e1, e2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.e1 = new EmpleadoPlanta(true, 2, 0);
		this.e2 = new EmpleadoPlanta(false, 0, 10);
	}
	
	@Test
	void testSueldoBasico() {
		assertEquals(this.e1.sueldo(), 52050);
		assertEquals(this.e2.sueldo(), 62500);
	}
}
