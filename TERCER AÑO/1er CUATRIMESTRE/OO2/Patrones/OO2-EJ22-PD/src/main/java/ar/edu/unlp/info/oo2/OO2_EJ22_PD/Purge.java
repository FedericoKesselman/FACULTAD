package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

public class Purge extends ProcessStep{

	@Override
	protected boolean basicExecute(MixingTank tank) {
		return tank.heatPower(0) && tank.mixerPower(0) && tank.purge();
	}

}
