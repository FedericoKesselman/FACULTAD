package ar.edu.unlp.info.oo2.OO2_EJ19_PD;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherCelsiusAdapter implements WeatherData{
	private HomeWeatherStation homeWeather;
	
	public WeatherCelsiusAdapter(HomeWeatherStation homeWeather) {
		this.homeWeather = homeWeather;
	}
	
	@Override
	public double getTemperatura() {
		return this.convertidorACelsius(this.homeWeather.getTemperatura());
	}

	@Override
	public double getPresion() {
		return this.homeWeather.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		return this.homeWeather.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturas() {
		return this.homeWeather.getTemperaturas().stream()
				.map(t -> this.convertidorACelsius(t))
				.collect(Collectors.toList());
	}

	@Override
	public String displayData() {
		return "Temperatura C: " + this.getTemperatura() + "; Presión atmosférica: " + this.getPresion() 
		+ "; Radiación Solar: " + this.getRadiacionSolar();
	}
	
	private double convertidorACelsius(double tempF) {
		return (tempF - 32) / 1.8;
	}

}
