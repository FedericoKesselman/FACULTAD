package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

public class FakeMixingTankB implements MixingTank {
    private int heatLevel = 0;
    private int mixLevel = 0;
    private boolean purged = false;
    private double temperature = 20.0;
    private int volumen = 100;
    private long lastHeatTime = 0;

    @Override
    public boolean heatPower(int percentage) {
        this.heatLevel = percentage;
        this.lastHeatTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public boolean mixerPower(int percentage) {
        this.mixLevel = percentage;
        return true;
    }

    @Override
    public boolean purge() {
        // Purga con retraso simulado de 4s
        new Thread(() -> {
            try {
                Thread.sleep(4000);
                volumen = 0;
                purged = true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        return true;
    }

    @Override
    public int upTo() {
        return volumen;
    }

    @Override
    public double temperature() {
        long elapsed = (System.currentTimeMillis() - lastHeatTime) / 1000;
        double incremento = 0;

        if (heatLevel == 100) incremento = 5;
        else if (heatLevel == 75) incremento = 4;
        else if (heatLevel == 50) incremento = 2;
        else if (heatLevel == 25) incremento = 1;
        // 0 → 0

        return temperature + incremento * elapsed;
    }

    public boolean isPurged() {
        return purged;
    }
}
