package ar.edu.unlp.info.oo2.OO2_EJ19_PD;

import java.util.*;

public interface WeatherData {
	public double getTemperatura();
	public double getPresion();
	public double getRadiacionSolar();
	public List<Double> getTemperaturas();
	public String displayData();
}
