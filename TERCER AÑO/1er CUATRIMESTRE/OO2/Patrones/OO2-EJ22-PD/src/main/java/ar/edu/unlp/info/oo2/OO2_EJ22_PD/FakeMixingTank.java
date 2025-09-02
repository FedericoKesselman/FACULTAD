package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

public class FakeMixingTank implements MixingTank{
	private int heatLevel = 0;
	private int mixLevel = 0;
	private boolean purged = false;

	@Override
	public boolean heatPower(int percentage) {
		this.heatLevel = percentage;
		return true; // se simula que siempre funciona
	}

	@Override
	public boolean mixerPower(int percentage) {
		this.mixLevel = percentage;
		return true;
	}

	@Override
	public boolean purge() {
		this.purged = true;
		return true;
	}

	@Override
	public int upTo() {
		return 50; // Se simula con un valor
	}

	@Override
	public double temperature() {
		return 30.0;
	}
	
	 public int getHeatLevel() {
	        return heatLevel;
	 }

	 public int getMixLevel() {
	        return mixLevel;
	 }

	 public boolean isPurged() {
	        return purged;
	 }
}
