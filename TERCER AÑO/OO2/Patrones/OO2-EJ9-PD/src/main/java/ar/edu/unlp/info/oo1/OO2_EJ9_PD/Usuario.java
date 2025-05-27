package ar.edu.unlp.info.oo1.OO2_EJ9_PD;
import java.util.*;

public class Usuario {
	private String nombre;
	private List<AutoEnAlquiler> autosEnAlquiler;
	
	public Usuario (String nombre) {
		this.nombre = nombre;
		this.autosEnAlquiler = new LinkedList<>();
	}
	
	public void agregarAutoAlquiler(AutoEnAlquiler auto) {
		this.autosEnAlquiler.add(auto);
	}
}
