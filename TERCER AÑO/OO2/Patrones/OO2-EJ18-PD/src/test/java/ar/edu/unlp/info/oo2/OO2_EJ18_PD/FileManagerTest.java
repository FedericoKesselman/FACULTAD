package ar.edu.unlp.info.oo2.OO2_EJ18_PD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FileManagerTest {
	private FileManager fileManager;
	private ArchivoDecorator extension;
	private ArchivoDecorator tamano;
	private ArchivoDecorator fechaCreacion;
	private ArchivoDecorator fechaModificacion;
	private ArchivoDecorator permisos;
	private ArchivoDecorator todos;
	

	@BeforeEach
    void setUp() throws Exception {
		this.fileManager = new Archivo("archivo", ".txt", 100, LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 25), 7);
		this.extension = new Extension(fileManager);
		this.tamano = new Tamano(fileManager);
		this.fechaCreacion = new FechaCreacion(fileManager);
		this.fechaModificacion = new FechaModificacion(fileManager);
		this.permisos = new Permisos(fileManager);
		this.todos = new Permisos(new FechaModificacion(new FechaCreacion(new Tamano(new Extension(fileManager)))));
    }
	
	@Test
    void testUnDecorador() {
		assertEquals("archivo .txt", this.extension.prettyPrint());
		assertEquals("archivo 100.0", this.tamano.prettyPrint());
		assertEquals("archivo 2025-05-20", this.fechaCreacion.prettyPrint());
		assertEquals("archivo 2025-05-25", this.fechaModificacion.prettyPrint());
		assertEquals("archivo 7", this.permisos.prettyPrint());
    }
	
	@Test
	void testTodosLosDecorators() {
		assertEquals("archivo .txt 100.0 2025-05-20 2025-05-25 7", this.todos.prettyPrint());
	}
	
	@Test
	void testSinDecorators() {
		assertEquals("archivo", this.fileManager.prettyPrint());
	}
}
