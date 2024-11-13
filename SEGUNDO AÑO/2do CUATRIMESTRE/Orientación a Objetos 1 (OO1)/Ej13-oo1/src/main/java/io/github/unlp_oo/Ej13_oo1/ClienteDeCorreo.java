package io.github.unlp_oo.Ej13_oo1;
import java.util.*;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo (Carpeta inbox) {
		this.inbox = new Carpeta("inbox");
		this.carpetas = new LinkedList<Carpeta>();
	}
	
	public void recibir(Email email) {
		inbox.agregarEmail(email);
	}
	
	public Email buscar(String texto) {
		return this.carpetas.stream()
				.map(Carpeta -> Carpeta.buscarEmail(texto))
				.findFirst()
				.orElse(null);
	}
	
	public int espacioOcupado() {
		int tamanoCarpetas = carpetas.stream()
				.mapToInt(Carpeta -> Carpeta.tamano())
				.sum();
		
		return this.inbox.tamano() + tamanoCarpetas;
	}
	
	public int cantidadMails() {
		return carpetas.stream()
				.mapToInt(c -> c.cantidadMails())
				.sum();
	}
	
}
