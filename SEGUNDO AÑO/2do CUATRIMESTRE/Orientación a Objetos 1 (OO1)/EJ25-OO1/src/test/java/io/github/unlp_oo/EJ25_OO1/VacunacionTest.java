package io.github.unlp_oo.EJ25_OO1;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class VacunacionTest {
	private Medico medico;
	private Mascota mascota;
	private Vacunacion v1;
	private Vacunacion v2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.medico = new Medico ("Federico", LocalDate.of(2014, 10, 10), 1000);
		this.mascota = new Mascota ("Saul", LocalDate.of(2020, 10, 10), "Callejero");
		this.v1 = new Vacunacion ("Rabia", 1000, medico, LocalDate.now(), mascota); 
		this.v2 = new Vacunacion ("Rabia", 1000, medico, LocalDate.of(2024, 11, 10), mascota); // Domingo
	}
	
	@Test
	void testCostoServicio() {
		assertEquals (v1.costoServicio(), 2500);
		assertEquals (v2.costoServicio(), 2700);
	}
}
