package ar.edu.unlp.info.oo2.OO2_EJ10_PD;

public class Mensajero {
	private AlgoritmoCifrado algoritmo;
	
	public Mensajero(AlgoritmoCifrado algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	public void setCifrado(AlgoritmoCifrado algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	public String enviar(String mensaje) {
		return this.algoritmo.cifrar(mensaje);
	}
	
	public String recibir(String mensaje) {
		return this.algoritmo.descifrar(mensaje);
	}
	
	/*
	 * Se usa el patron Strategy, para poder manejar los diferentes tipos
	 * de cifrado de manera separada. Para poder cambiar de algoritmo facilmente, y
	 * tambien para poder agregar nuevos cifrados facilmente.
	 * Se usa el patron Adapter, para poder adaptar los metodos brindados por el
	 * ejercicio(Feistel y RC4) y los metodos de AlgoritmoCifrado.
	 */
}
