package ar.edu.unlp.info.oo2.OO2_EJ10_PD;

public class RC4Adapter implements AlgoritmoCifrado{
	private RC4 rc4;
	private String clave;
	
	public RC4Adapter (String clave) {
		this.rc4 = new RC4();
		this.clave = clave;
	}

	@Override
	public String cifrar(String mensaje) {
		return this.rc4.encriptar(mensaje, clave);
	}

	@Override
	public String descifrar(String mensaje) {
		return this.rc4.desencriptar(mensaje, clave);
	}

}
