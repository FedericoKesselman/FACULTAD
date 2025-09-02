package Herencia;

import java.util.*;

public class GameBoard {
	private List<Robot> robots;
	
	public GameBoard() {
		this.robots = new LinkedList<>();
	}
	
	public void addRobot(Robot robot) {
		this.robots.add(robot);
	}
	
	public void runUntilStopped() {
		// Logica del framework
	}
	
	public void runForCycles(int n) {
		// Logica del framework
	}
}
