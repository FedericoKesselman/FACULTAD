package ar.edu.unlp.info.oo1.OO2_EJ11_PD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TopografiaTest {
	
	private Topografia agua;
	private Topografia tierra;
	private Topografia mixta1;
	private Topografia mixta2;

	@BeforeEach
	public void setUp() throws Exception {
		agua = new Agua();
		tierra = new Tierra();
		mixta1 = new TopografiaMixta(new Agua(),new Tierra(),new Tierra(),new Agua());
		mixta2 = new TopografiaMixta(new Agua(),new Tierra(),new Tierra(),mixta1);
	}

	@Test
	public void testGetProporcionTierra() {
		assertEquals(1, tierra.proporcionTierra());
		assertEquals(0, agua.proporcionTierra());
		assertEquals(0.5, mixta1.proporcionTierra());
		assertEquals(0.625, mixta2.proporcionTierra());
	}
	
	@Test
	public void testGetProporcionAgua() {
		assertEquals(0,tierra.proporcionAgua());
		assertEquals(1,agua.proporcionAgua());
		assertEquals(0.5,mixta1.proporcionAgua());
		assertEquals(0.375,mixta2.proporcionAgua());
	}
	
	@Test
	public void testIsEquals() {
		assertTrue(this.tierra.equals(new Tierra()));
		assertFalse(this.tierra.equals(new Agua()));
		
		assertTrue(this.agua.equals(new Agua()));
		assertFalse(this.agua.equals(new Tierra()));
		/*
		assertFalse(this.mixta1.equals(agua));
		assertFalse(this.mixta1.equals(mixta2));
		assertTrue(this.mixta1.equals(new TopografiaMixta(new Agua(),new Tierra(),new Tierra(),new Agua())));
		assertTrue(this.mixta2.equals(new TopografiaMixta(new Agua(),new Tierra(),new Tierra(),mixta1)));
		assertFalse(this.mixta2.equals(new TopografiaMixta(new Agua(),new Tierra(),mixta1,new Tierra())));
		*/
	}

}