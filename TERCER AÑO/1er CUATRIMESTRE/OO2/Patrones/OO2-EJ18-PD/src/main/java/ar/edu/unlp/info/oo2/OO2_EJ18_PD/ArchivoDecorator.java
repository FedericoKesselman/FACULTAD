package ar.edu.unlp.info.oo2.OO2_EJ18_PD;

import java.time.LocalDate;

public abstract class ArchivoDecorator implements FileManager{
	private FileManager component;
	
	public ArchivoDecorator(FileManager component) {
		this.component = component;
	}

	@Override
	public String prettyPrint() {
		return this.component.prettyPrint();
	}

	@Override
	public String getNombre() {
		return this.component.getNombre();
	}

	@Override
	public String getExtension() {
		return this.component.getExtension();
	}

	@Override
	public double getTamano() {
		return this.component.getTamano();
	}

	@Override
	public LocalDate getFechaCreacion() {
		return this.component.getFechaCreacion();
	}

	@Override
	public LocalDate getFechaModificacion() {
		return this.component.getFechaModificacion();
	}

	@Override
	public int getPermisos() {
		return this.component.getPermisos();
	}
	
	public FileManager component() {
		return this.component;
	}

}
