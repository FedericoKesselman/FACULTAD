package io.github.unlp_oo.EJ25_OO1;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class MedicoTest {
	private Medico medico;
	
	@BeforeEach
	void setUp() throws Exception {
		this.medico = new Medico ("Federico", LocalDate.of(2014, 10, 10), 1000);
	}
	
	@Test
	void testAntiguedad() {
		assertEquals(medico.antiguedad(), 10);
	}
	
}
