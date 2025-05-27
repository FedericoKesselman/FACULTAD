package ar.edu.unlp.info.oo2.OO2_EJ18_PD;

import java.time.LocalDate;

public interface FileManager {
	public String prettyPrint();
	public String getNombre();
	public String getExtension();
	public double getTamano();
	public LocalDate getFechaCreacion();
	public LocalDate getFechaModificacion();
	public int getPermisos();
}
