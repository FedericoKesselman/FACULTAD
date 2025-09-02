package Composicion;

public abstract class Robot {
	private movementSystem movementSys;
	private batterySystem batterySys;
	private armsSystem armsSys;
	
	public Robot(movementSystem movementSys, batterySystem batterySys, armsSystem armsSys) {
		this.movementSys = movementSys;
		this.batterySys = batterySys;
		this.armsSys = armsSys;
	}

	// TemplateMethod
	public void step() {
		this.movementSys.move(this);
		this.batterySys.consumeBattery(this);
		this.armsSys.fire(this);
		this.collectArtifacts();
	}
	
	protected void collectArtifacts() {}
}

