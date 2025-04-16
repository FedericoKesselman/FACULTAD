package ar.edu.unlp.info.oo1.OO2_EJ4_PD;

import java.time.Duration;
import java.time.LocalDateTime;

public class Pending extends ToDoItemState{

	@Override
	public void start(ToDoItem context) {
		context.setInicio(LocalDateTime.now());
		context.setState(new InProgress());
	}

	@Override
	public void togglePause(ToDoItem context) {
		throw new RuntimeException("No se puede pausar una tarea pendiente");
	}

	@Override
	public void finish(ToDoItem context) {
		// ---
	}

	@Override
	public Duration workedTime(ToDoItem context) {
		throw new RuntimeException("La tarea aún no se ha iniciado");
	}

	@Override
	public void addComment(ToDoItem context, String comment) {
		context.addComment(comment);
	}

	@Override
	public String getNombreEstado() {
		return "Pending";
	}
}
