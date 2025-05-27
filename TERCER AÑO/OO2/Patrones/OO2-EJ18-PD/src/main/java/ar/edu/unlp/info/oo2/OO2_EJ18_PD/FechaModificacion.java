package ar.edu.unlp.info.oo2.OO2_EJ18_PD;

public class FechaModificacion extends ArchivoDecorator{
	public FechaModificacion(FileManager component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return this.component().prettyPrint() + " " + this.getFechaModificacion();
	}
}
