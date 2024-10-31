package io.github.unlp_oo.Ej13_oo1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	Carpeta carpeta;
	Carpeta carpeta2;
	Email email1;
	Email email2;
	Email email3;
	
	@BeforeEach
	void setUp() throws Exception {
		email1 = new Email ("email1", "cuerpo1");
		email2 = new Email ("email2", "cuerpo2");
		email3 = new Email ("email3", "cuerpo3");
		carpeta = new Carpeta ("Carpeta");
		carpeta.agregarEmail(email1);
		carpeta.agregarEmail(email2);
		carpeta.agregarEmail(email3);
	}
	
	@Test
	void testAgregar() {
		assertEquals (3, carpeta.getEmails().size());
	}
	
	@Test
	void testTamano() {
		assertEquals (39, carpeta.tamano());
	}
	
	@Test
	void testBuscar() {
		assertEquals (email1, carpeta.buscarEmail("email1"));
		assertEquals (email1, carpeta.buscarEmail("cuerpo1"));
	}
	
	@Test
	void testMover() {
		carpeta2 = new Carpeta ("carpeta2");
		carpeta.mover(email2, carpeta2);
		
		assertEquals (1, carpeta2.getEmails().size());
		assertEquals (email2, carpeta2.buscarEmail("email2"));
		assertEquals (email2, carpeta2.buscarEmail("cuerpo2"));
		assertEquals (2, carpeta.getEmails().size());
	}
	

}


















