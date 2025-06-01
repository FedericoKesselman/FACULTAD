package ar.edu.unlp.info.oo2.OO2_EJ19_PD;

public class TemperaturasMax extends WeatherDecorator{
	public TemperaturasMax(WeatherData component) {
		super(component);
	}
	
	@Override
	public String displayData() {
		return super.displayData() + "; Máximo: " + this.maxTemp();
	}
	
	private double maxTemp() {
		return this.component.getTemperaturas().stream()
				.max((t1, t2)-> Double.compare(t1, t2))
				.orElse(0.0);
	}
}
