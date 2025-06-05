package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

public abstract class ProcessStep {
	private boolean result;
	
	public void execute(MixingTank tank) {
        this.result = this.basicExecute(tank);
    }

    public boolean isDone() {
        return result;
    }

    protected abstract boolean basicExecute(MixingTank tank);
}
