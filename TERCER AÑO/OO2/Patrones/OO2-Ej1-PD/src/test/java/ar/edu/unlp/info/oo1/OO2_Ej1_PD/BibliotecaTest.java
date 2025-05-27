package ar.edu.unlp.info.oo1.OO2_Ej1_PD;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BibliotecaTest {
	
	private Biblioteca biblioteca;
	private Socio s1, s2;
	private JSONParser parseo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.biblioteca = new Biblioteca();
		this.s1 = new Socio("Arya Stark", "needle@stark.com", "5234-5");
		this.s2 = new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2");
		
		this.biblioteca.agregarSocio(s1);
		this.biblioteca.agregarSocio(s2);
		parseo = new JSONParser();
	}
	
	@Test
	void testBibliotecaA() {
		VoorheesExporter exporter = new VoorheesExporter();
		this.biblioteca.setExporter(exporter);
		
		String salida = "[\r\n"
				+ "	{\r\n"
				+ "		\"nombre\": \"Arya Stark\",\r\n"
				+ "		\"email\": \"needle@stark.com\",\r\n"
				+ "		\"legajo\": \"5234-5\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"nombre\": \"Tyron Lannister\",\r\n"
				+ "		\"email\": \"tyron@thelannisters.com\",\r\n"
				+ "		\"legajo\": \"2345-2\"\r\n"
				+ "	}\r\n"
				+ "]";
		
		assertEquals(salida, this.biblioteca.exportarSocios());
		assertTrue(this.biblioteca.exportarSocios().contains("Arya Stark"));
		assertTrue(this.biblioteca.exportarSocios().contains("Tyron Lannister"));
	}
	
	@Test
	void testBibliotecaB() throws ParseException {
		VoorheesExporter adapter = new JSONSimpleAdapter();
		this.biblioteca.setExporter(adapter);
		
		String salida = "[\r\n"
				+ "	{\r\n"
				+ "		\"nombre\": \"Arya Stark\",\r\n"
				+ "		\"email\": \"needle@stark.com\",\r\n"
				+ "		\"legajo\": \"5234-5\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"nombre\": \"Tyron Lannister\",\r\n"
				+ "		\"email\": \"tyron@thelannisters.com\",\r\n"
				+ "		\"legajo\": \"2345-2\"\r\n"
				+ "	}\r\n"
				+ "]";
		
		assertEquals(parseo.parse(salida), parseo.parse(this.biblioteca.exportarSocios()));
		assertTrue(this.biblioteca.exportarSocios().contains("Arya Stark"));
		assertTrue(this.biblioteca.exportarSocios().contains("Tyron Lannister"));
	}
}
