package ar.edu.unlp.info.oo2.OO2_EJ10_PD;

public class Programa {
	public static void main(String[] args) {
		String mensaje = "Hola mundo";
		
		//Fesitel
		Mensajero mensajero = new Mensajero(new FeistelAdapter("clave1"));
		String mensajeCifrado = mensajero.enviar(mensaje);
		System.out.println("Cifrado Feistel: " + mensajeCifrado);
		System.out.println("Descifrado: " + mensajero.recibir(mensajeCifrado));
		
		//RC4
		mensajero.setCifrado(new RC4Adapter("clave2"));
		String mensajeCifrado2 = mensajero.enviar(mensaje);
		System.out.println("Cifrado RC4: " + mensajeCifrado2);
		System.out.println("Descifrado: " + mensajero.recibir(mensajeCifrado2));
	}
}
