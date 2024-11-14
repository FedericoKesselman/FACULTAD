package io.github.unlp_oo.EJ25_OO1;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class ConsultaMedicaTest {
	private Medico medico;
	private Mascota mascota;
	private ConsultaMedica cm1;
	private ConsultaMedica cm2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.medico = new Medico ("Federico", LocalDate.of(2014, 10, 10), 1000);
		this.mascota = new Mascota ("Saul", LocalDate.of(2020, 10, 10), "Callejero");
		this.cm1 = new ConsultaMedica (medico, LocalDate.now(), mascota); 
		this.cm2 = new ConsultaMedica (medico, LocalDate.of(2024, 11, 10), mascota); // Domingo
	}
	
	@Test
	void testCostoServicio() {
		assertEquals (cm1.costoServicio(), 2300);
		assertEquals (cm2.costoServicio(), 2500);
	}
}
