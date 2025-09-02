package ar.edu.unlp.info.oo1.Parcial2024_2doRecuperatorio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBolsa {
	private Jugador jugador;
	
	@BeforeEach
	void setUp() {
		this.jugador = new Jugador("Federico", 10);
	}
	
	@Test
	void test() {
		assertTrue(jugador.add(new Objeto(3, "Item 1")));
		assertTrue(jugador.add(new Bolsa("Bolsa 2", 13)));
		assertFalse(jugador.add(new Objeto(30, "Item grande")));
	}
}
