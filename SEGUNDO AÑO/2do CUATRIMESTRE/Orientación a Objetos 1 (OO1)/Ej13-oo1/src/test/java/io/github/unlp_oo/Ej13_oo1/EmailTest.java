package io.github.unlp_oo.Ej13_oo1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	Email email;
	Archivo archivo1;
	Archivo archivo2;
	
	@BeforeEach
	void setUp() throws Exception {
		email = new Email ("email1", "cuerpo");
		archivo1 = new Archivo("22");
		archivo2 = new Archivo("4444");
		email.agregarArchivo(archivo1);
		email.agregarArchivo(archivo2);
	}
	
	@Test
	void testListaArchivos() {
		assertEquals (2, email.getAdjuntos().size());
	}
	
	@Test
	void testTamano() {
		assertEquals (18, email.tamano());
	}
	
	@Test
	void testContiene() {
		assertTrue (email.contiene("email1"));
		assertTrue (email.contiene("email"));
		assertTrue (email.contiene("cuerpo"));
		assertFalse (email.contiene("dkajdkja"));
	}
}
