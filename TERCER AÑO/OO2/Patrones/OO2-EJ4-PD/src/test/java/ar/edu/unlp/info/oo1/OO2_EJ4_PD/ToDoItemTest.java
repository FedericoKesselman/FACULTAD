package ar.edu.unlp.info.oo1.OO2_EJ4_PD;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.*;

public class ToDoItemTest {
	private ToDoItem toDo;
	
	@BeforeEach
	void setUp() throws Exception {
		toDo = new ToDoItem("Prueba");
	}
	
	@Test
	void testFlujo() {
		assertEquals(toDo.getEstadoActual(),"Pending");
		
		toDo.start();
		assertEquals(toDo.getEstadoActual(),"InProgress");
		
		toDo.togglePause();
		assertEquals(toDo.getEstadoActual(), "Paused");
		
		toDo.togglePause();
		assertEquals(toDo.getEstadoActual(), "InProgress");
		
		toDo.finish();
		assertEquals(toDo.getEstadoActual(), "Finished");
		
		Duration tiempo = toDo.workedTime();
		assertTrue(tiempo.toSeconds() >= 0); 
		// Se acepta cualquier positivo
	}
	
	@Test
    public void testErroresTogglePause() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> toDo.togglePause());
        assertEquals("No se puede pausar una tarea pendiente", e.getMessage());
    }
	
	@Test
    public void testComentariosSegunEstado() {
        toDo.comentar("Comentario en pending");
        toDo.start();
        toDo.comentar("Comentario en progreso");
        toDo.togglePause();
        toDo.comentar("Comentario en pausa");
        toDo.finish();

        // No debe lanzar error pero no debería hacer nada
        toDo.comentar("Comentario post-finalización");

        assertEquals(3, toDo.getComentarios().size());
    }
}
