package ar.edu.unlp.info.oo1.OO2_Ej2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJuego {
	Jugada piedra;
	Jugada papel;
	Jugada tijera;
	Jugada lagarto, lagarto2;
	Jugada spock;
	
	@BeforeEach
	void setUp() throws Exception{
		lagarto = new Lagarto();
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
		spock = new Spock();
		lagarto2 = new Lagarto();
	}
	
	@Test
	void test() {
		assertEquals("Gana lagarto", lagarto.juegaContra(papel));
		assertEquals("Gana piedra", lagarto.juegaContra(piedra));
		assertEquals("Gana tijera", lagarto.juegaContra(tijera));
		assertEquals("Gana lagarto", lagarto.juegaContra(spock));
		assertEquals("Empate", lagarto.juegaContra(lagarto2));
	}
}
