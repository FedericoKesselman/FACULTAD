package io.github.unlp_oo.Ej13_oo1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	Archivo archivo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.archivo = new Archivo("333");
	}
	
	@Test
	void testConstructor() {
		assertEquals (3, archivo.tamano());
	}
}
