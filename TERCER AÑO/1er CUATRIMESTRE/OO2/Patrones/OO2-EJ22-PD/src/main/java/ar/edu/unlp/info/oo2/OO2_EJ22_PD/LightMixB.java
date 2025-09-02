package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

public class LightMixB extends ProcessStep {
    @Override
    protected boolean basicExecute(MixingTank tank) {
        double tempInicial = tank.temperature();
        tank.heatPower(100);

        try {
            Thread.sleep(2000); // 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        double delta = tank.temperature() - tempInicial;
        if (delta == 10) {
            tank.mixerPower(5);
            return true;
        }
        return false;
    }
}
