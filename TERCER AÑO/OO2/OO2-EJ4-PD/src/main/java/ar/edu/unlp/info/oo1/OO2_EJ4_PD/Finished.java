package ar.edu.unlp.info.oo1.OO2_EJ4_PD;

import java.time.Duration;

public class Finished extends ToDoItemState{

	@Override
	public void start(ToDoItem context) {
		// No hace nada
		
	}

	@Override
	public void togglePause(ToDoItem context) {
		throw new RuntimeException("Esta tarea ya esta finalizada");
	}

	@Override
	public void finish(ToDoItem context) {
		// No hace nada
	}

	@Override
	public Duration workedTime(ToDoItem context) {
		return Duration.between(context.getInicio(), context.getFin());
	}

	@Override
	public void addComment(ToDoItem context, String comment) {
		// No hace nada 
	}

}
