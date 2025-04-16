package ar.edu.unlp.info.oo1.OO2_EJ4_PD;

import java.util.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class ToDoItem {
	private ToDoItemState estado;
	private String name;
	private List<String> comentarios;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	
	public ToDoItem (String name) {
		this.name = name;
		this.comentarios = new LinkedList<>();
		this.estado = new Pending();
	}
	
	public void start() {
		this.estado.start(this);
	}
	
	public void togglePause() {
		this.estado.togglePause(this);
	}
	
	public void finish() {
		this.estado.finish(this);
	}
	
	public void setState(ToDoItemState nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	public LocalDateTime getInicio() {
		return this.inicio;
	}
	
	public LocalDateTime getFin() {
		return this.fin;
	}
	
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	
	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	protected void addComment(String comment) {
		this.comentarios.add(comment);
	}
	
	public void comentar(String comment) {
		this.estado.addComment(this, comment);
	}
	
	
	public Duration workedTime() {
		return this.estado.workedTime(this);
	}
	
	public List<String> getComentarios() {
		return this.comentarios;
	}
	
	public String getEstadoActual() {
		return this.estado.getNombreEstado();
	}
	
	
	
	
	
	
}
