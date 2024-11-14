package io.github.unlp_oo.EJ25_OO1;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class MascotaTest {
	private Mascota mascota;
	private Medico medico;
	private Vacunacion v;
	private ConsultaMedica cm;
	private Guarderia g;
	
	@BeforeEach
	void setUp() throws Exception {
		this.mascota = new Mascota ("Saul", LocalDate.of(2020, 10, 10), "Callejero");
		this.medico = new Medico ("Federico", LocalDate.of(2014, 10, 10), 1000);
	}
	
	@Test
	void testAltaServicios() {
		assertEquals(mascota.getServicios().size(), 0);
		
		this.mascota.altaConsultaMedica(medico);
		this.mascota.altaVacunacion("Rabia", 1000, medico);
		this.mascota.altaGuarderia(3);
		
		assertEquals(mascota.getServicios().size(), 3);
		
		this.mascota.altaVacunacion("Rabia", 1000, medico);
		this.mascota.altaGuarderia(3);
		
		assertTrue(mascota.tiene5Servicios());
	}
	
	@Test
	void testRecaudacion() {
		this.mascota.altaConsultaMedica(medico); // 2500
		this.mascota.altaVacunacion("Rabia", 1000, medico); // 2300
		this.mascota.altaGuarderia(3); // 1500
		
		assertEquals(mascota.recaudacionEnFecha(LocalDate.now()), 6300);
	}

}
