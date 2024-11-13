package io.github.unlp_oo.Ej13_oo1;
import java.util.*;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email (String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		adjuntos = new LinkedList<Archivo>();
	}
	
	public void agregarArchivo (Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
	public int tamano() {
		int tamanoAdjuntos = adjuntos.stream()
				.mapToInt(archivo -> archivo.tamano())
				.sum();
		
		return titulo.length() + cuerpo.length() + tamanoAdjuntos;
	}
	
	public boolean contiene (String texto) {
		return (this.titulo.contains(texto) || this.cuerpo.contains(texto));
	}
	
	public String getCategoria() {
		int tam = this.tamano();
		
		if (tam <= 300)
			return "Pequeno";
		else if (tam <= 500)
			return "Mediano";
		else 
			return "Grande";
	}

	public List<Archivo> getAdjuntos() {
		return this.adjuntos;
	}
}
