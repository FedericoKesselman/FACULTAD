package ar.edu.unlp.info.oo2.OO2_EJ15_PD;

import java.util.*;

public class Catalogo {
	private static List<Componente> componentes;
	
	public Catalogo() {
		componentes = new ArrayList<Componente>();
	}

	public static void addComponente(Componente nuevo) {
		Catalogo.componentes.add(nuevo);
	}

	public static Componente getComponente(String descripcion) {
		return componentes.stream().
				filter(c -> c.getDescripcion().equals(descripcion)).
				findFirst().
				orElse(null);
	}
}
