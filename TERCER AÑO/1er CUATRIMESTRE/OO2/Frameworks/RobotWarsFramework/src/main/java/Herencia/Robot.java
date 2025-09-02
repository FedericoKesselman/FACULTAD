package Herencia;

public abstract class Robot {
	
	// TemplateMethod
	public void step() {
		this.move();
		this.consumeBattery();
		this.fireArms();
		this.collectArtifacts();
	}
	
	protected void collectArtifacts() {}
	
	protected abstract void consumeBattery(); // En PanelSolarRobot 
	protected abstract void move();	// En PanelSolarCaterpillarRobot y PanelSolarOvercraftRobot
	protected abstract void fireArms(); // En las clases concretas
}
