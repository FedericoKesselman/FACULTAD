package ar.edu.unlp.info.oo2.OO2_EJ18_PD;

public class Tamano extends ArchivoDecorator{
	public Tamano(FileManager component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return this.component().prettyPrint() + " " + this.getTamano();
	}
}
