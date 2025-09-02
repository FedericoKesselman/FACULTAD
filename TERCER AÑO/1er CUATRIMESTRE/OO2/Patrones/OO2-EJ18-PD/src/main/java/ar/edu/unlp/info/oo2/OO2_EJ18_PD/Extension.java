package ar.edu.unlp.info.oo2.OO2_EJ18_PD;

public class Extension extends ArchivoDecorator{
	public Extension(FileManager component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return this.component().prettyPrint() + " " + this.getExtension();
	}
}
