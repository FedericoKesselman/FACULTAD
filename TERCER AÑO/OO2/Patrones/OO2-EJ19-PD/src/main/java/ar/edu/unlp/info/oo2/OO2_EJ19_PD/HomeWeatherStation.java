package ar.edu.unlp.info.oo2.OO2_EJ19_PD;

import java.util.LinkedList;
import java.util.List;

public class HomeWeatherStation implements WeatherData{
	private double temperatura;
	private double presion;
	private double radiacionSolar;
	private List<Double> temperaturas;
	
	public HomeWeatherStation(double temperatura, double presion, double radiacionSolar) {
		this.temperatura = temperatura;
		this.presion = presion;
		this.radiacionSolar = radiacionSolar;
		this.temperaturas = new LinkedList<>();
	}
	
	@Override
	public double getTemperatura() {
		this.temperaturas.add(this.temperatura);
		return this.temperatura; // farenheit
	}

	@Override
	public double getPresion() {
		return this.presion;
	}

	@Override
	public double getRadiacionSolar() {
		return this.radiacionSolar;
	}

	@Override
	public List<Double> getTemperaturas() {
		return this.temperaturas;
	}

	@Override
	public String displayData() {
		return "Temperatura F: " + this.getTemperatura() + "; Presión atmosférica: " + this.getPresion() 
				+ "; Radiación Solar: " + this.getRadiacionSolar();
	}
	
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
}
