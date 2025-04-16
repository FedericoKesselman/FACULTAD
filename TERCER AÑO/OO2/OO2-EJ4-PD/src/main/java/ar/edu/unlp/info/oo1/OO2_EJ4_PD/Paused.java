package ar.edu.unlp.info.oo1.OO2_EJ4_PD;

import java.time.Duration;
import java.time.LocalDateTime;

public class Paused extends ToDoItemState{

	@Override
	public void start(ToDoItem context) {
		// No hace nada
	}

	@Override
	public void togglePause(ToDoItem context) {
		context.setState(new InProgress());
	}

	@Override
	public void finish(ToDoItem context) {
		context.setFin(LocalDateTime.now());
		context.setState(new Finished());
	}

	@Override
	public Duration workedTime(ToDoItem context) {
		return Duration.between(context.getInicio(), LocalDateTime.now());
	}

	@Override
	public void addComment(ToDoItem context, String comment) {
		context.addComment(comment);
	}
}
