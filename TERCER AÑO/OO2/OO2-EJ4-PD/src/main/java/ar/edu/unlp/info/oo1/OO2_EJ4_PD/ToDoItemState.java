package ar.edu.unlp.info.oo1.OO2_EJ4_PD;

import java.time.Duration;

public abstract class ToDoItemState {
	public abstract void start(ToDoItem context);
	public abstract void togglePause(ToDoItem context);
	public abstract void finish(ToDoItem context);

	public abstract Duration workedTime(ToDoItem context);
	public abstract void addComment(ToDoItem context, String comment);
}
