package io.github.unlp_oo.EJ24_OO1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

public class TestPasajero {
	private Pasajero p1;
	private Pasajero p2;
	private Viaje viaje;
	private Vehiculo vehiculo;
	private Conductor c;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.p1 = new Pasajero ("Federico", 0);
		this.p2 = new Pasajero ("Joaquin", 0);
		
		this.c = new Conductor("Baltazar", 500, vehiculo);
		Vehiculo vehiculo = new Vehiculo(c, "va", 5, 2020, 76000);
		this.viaje = new Viaje ("///", "///", 100, vehiculo, LocalDate.now());
	}
	
	@Test
	void testCargaSaldo() {
		p2.cargarSaldo(1000);
		assertEquals (900, p2.getSaldo());
		
		p1.realizarViaje(viaje);
		viaje.procesarViaje();
		
		p1.cargarSaldo(1000);
		System.out.println (p1.getSaldo());
		assertEquals (1000, p1.getSaldo());
	}
}
