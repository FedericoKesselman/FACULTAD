package ar.edu.unlp.info.oo2.OO2_EJ22_PD;

public interface MixingTank {
	boolean heatPower(int percentage);
    boolean mixerPower(int percentage);
    boolean purge();
    int upTo();           // volumen
    double temperature(); // temperatura
    // Se simula la implementacion con un Fake
}
