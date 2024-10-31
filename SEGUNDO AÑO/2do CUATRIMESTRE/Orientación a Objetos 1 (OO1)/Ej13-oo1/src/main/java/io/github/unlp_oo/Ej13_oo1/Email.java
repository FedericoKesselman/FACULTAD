package io.github.unlp_oo.Ej13_oo1;
import java.util.*;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email (String titulo, String cuerpo, List<Archivo> adjuntos) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = adjuntos;
	}
	
	public Email (String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		adjuntos = new LinkedList<Archivo>();
	}
	
	
	public void agregarArchivo (Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> getAdjuntos() {
		return new ArrayList<Archivo>(this.adjuntos);
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
}
