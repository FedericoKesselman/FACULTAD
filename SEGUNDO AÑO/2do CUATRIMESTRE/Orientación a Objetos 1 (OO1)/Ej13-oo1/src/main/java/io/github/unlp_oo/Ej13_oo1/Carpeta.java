package io.github.unlp_oo.Ej13_oo1;
import java.util.*;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new LinkedList<Email>();
	}
	
	public List<Email> getEmails() {
		return new LinkedList<Email>(this.emails);
	}
	
	public void agregarEmail (Email email) {
		if (email != null)
			this.emails.add(email);
	}
	
	public void mover (Email email, Carpeta destino) {
		if (this.emails.contains(email)) 
			this.emails.remove(email);
		destino.agregarEmail(email);
	}
	
	public Email buscarEmail(String texto) {
		return this.emails.stream()
				.filter(Emails -> Emails.contiene(texto)).findFirst()
				.orElse(null);
	}
	
	public int tamano() {
		return emails.stream()
				.mapToInt(Email -> Email.tamano())
				.sum();
	}
	
	public int cantidadMails() {
		return this.emails.size();
	}
	
	
	public Map<String, Integer> tamanoCategorias() {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("Pequeno", 0);
		map.put("Mediano", 0);
		map.put("Grande", 0);
		
		emails.stream().forEach(e -> map.put(e.getCategoria(), map.get(e.getCategoria() + 1)) );
		
		/*
		for (Email e: emails) 
			map.put(e.getCategoria(), map.get(e.getCategoria() + 1));
		*/
		
		return map;
	}
}









