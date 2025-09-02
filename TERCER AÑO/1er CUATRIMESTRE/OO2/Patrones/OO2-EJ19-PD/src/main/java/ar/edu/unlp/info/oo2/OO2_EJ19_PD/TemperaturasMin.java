package ar.edu.unlp.info.oo2.OO2_EJ19_PD;

public class TemperaturasMin extends WeatherDecorator{
	public TemperaturasMin(WeatherData component) {
		super(component);
	}
	
	@Override
	public String displayData() {
		return super.displayData() + "; Mínimo: " + this.minTemp();
	}
	
	private double minTemp() {
		return this.component.getTemperaturas().stream()
				.min(Double::compare)
				.orElse(0.0);
	}
}
