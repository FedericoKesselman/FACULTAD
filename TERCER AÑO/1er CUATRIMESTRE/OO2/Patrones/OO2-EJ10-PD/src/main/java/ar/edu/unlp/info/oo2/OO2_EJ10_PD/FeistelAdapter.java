package ar.edu.unlp.info.oo2.OO2_EJ10_PD;

public class FeistelAdapter implements AlgoritmoCifrado{
	private FeistelCipher feistel;
	
	public FeistelAdapter (String clave) {
        this.feistel = new FeistelCipher(clave);
    }

	@Override
	public String cifrar(String mensaje) {
		return this.feistel.encode(mensaje);
	}

	@Override
	public String descifrar(String mensaje) {
		return this.feistel.encode(mensaje);
	}
	
}
