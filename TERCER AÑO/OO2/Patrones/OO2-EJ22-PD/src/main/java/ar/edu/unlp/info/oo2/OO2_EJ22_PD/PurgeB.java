package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

public class PurgeB extends ProcessStep {
	
    @Override
    protected boolean basicExecute(MixingTank tank) {
        if (tank.upTo() == 0) return false;

        tank.heatPower(0);
        tank.mixerPower(0);
        tank.purge();

        try {
            Thread.sleep(4000); // 4 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        return tank.upTo() == 0;
    }
}
