package ar.edu.unlp.info.oo2.OO2_EJ19_PD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeWeatherTest {
	private HomeWeatherStation homeWeather;
	private WeatherCelsiusAdapter weatherCelsius;
	
	@BeforeEach
	void setUp() {
		this.homeWeather = new HomeWeatherStation(0, 1008, 200);
		this.homeWeather.setTemperatura(82.4);
		this.homeWeather.getTemperatura(); // agrega a lista
		this.homeWeather.setTemperatura(89.6);
		this.homeWeather.getTemperatura(); // agrega a lista
		this.homeWeather.setTemperatura(86.0);
		this.homeWeather.getTemperatura(); // agrega a lista

		this.weatherCelsius = new WeatherCelsiusAdapter(this.homeWeather);
	}
	
	@Test
	void testDisplaySinDecorator() {
		assertEquals("Temperatura F: 86.0; Presión atmosférica: 1008.0; Radiación Solar: 200.0", this.homeWeather.displayData());
		assertEquals("Temperatura C: 30.0; Presión atmosférica: 1008.0; Radiación Solar: 200.0", this.weatherCelsius.displayData());
	}
	
	@Test
	void testDisplayConDecorator() {
		WeatherData decorator = new PromedioTemp(this.weatherCelsius);
		decorator = new TemperaturasMin(decorator);
		decorator = new TemperaturasMax(decorator);
		
		assertEquals("Temperatura C: 30.0; Presión atmosférica: 1008.0; Radiación Solar: 200.0; Promedio: 30.0; Mínimo: 28.000000000000004; Máximo: 31.999999999999996", decorator.displayData());
	}
}
