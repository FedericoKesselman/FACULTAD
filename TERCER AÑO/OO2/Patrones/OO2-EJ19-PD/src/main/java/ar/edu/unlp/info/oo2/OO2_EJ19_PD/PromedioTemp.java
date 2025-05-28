package ar.edu.unlp.info.oo2.OO2_EJ19_PD;

public class PromedioTemp extends WeatherDecorator{
	public PromedioTemp(WeatherData component) {
		super(component);
	}
	
	@Override
	public String displayData() {
		return this.component.displayData() + "; Promedio: " + this.promedio();
	}
	
	private double promedio() {
	    return this.component.getTemperaturas().stream()
	            .mapToDouble(t -> t)
	            .average()
	            .orElse(0.0); 
	}
}
