package io.github.unlp_oo.Ej10_oo1;

public class jobDescription {
	private double effort;
	private int priority;
	private String description;
	
	public jobDescription (double effort, int priority, String description) {
		this.effort = effort;
		this.priority = priority;
		this.description = description;
	}
	
	public double effort() {
		return this.effort;
	}
	
	public int priority() {
		return this.priority;
	}
	
	public String description() {
		return this.description;
	}
}
