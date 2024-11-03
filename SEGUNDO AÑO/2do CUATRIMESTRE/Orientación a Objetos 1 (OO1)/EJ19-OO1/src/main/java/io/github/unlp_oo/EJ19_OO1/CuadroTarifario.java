package io.github.unlp_oo.EJ19_OO1;
import java.util.*;

// EJEMPLO DE IMPLEMENTACION 
// idea de como podria hacerse el cuadro para manejar los valores en una unica clase y no hardcodeados en los envios
// se podria hacer distinto el constructor y agregar setters, etc
public class CuadroTarifario {
	private int localEntregaRapida;
	private int localEntregaEstandar;
	
	private int interurbanoDistanciaCorta;
	private int interurbanoDistanciaMedia;
	private int interurbanoDistanciaLarga;
	
	private int internacionalLiviano;
	private int internacionalPesado;
	// private List<Pais> costoPaises; // cada pais tiene su nombre y su precio
	
	public CuadroTarifario(int localEntregaRapida, int localEntregaEstandar, int interurbanoDistanciaCorta,
			int interurbanoDistanciaMedia, int interurbanoDistanciaLarga, int internacionalLiviano,
			int internacionalPesado, List<String> costoPaises) {

		this.localEntregaRapida = localEntregaRapida;
		this.localEntregaEstandar = localEntregaEstandar;
		this.interurbanoDistanciaCorta = interurbanoDistanciaCorta;
		this.interurbanoDistanciaMedia = interurbanoDistanciaMedia;
		this.interurbanoDistanciaLarga = interurbanoDistanciaLarga;
		this.internacionalLiviano = internacionalLiviano;
		this.internacionalPesado = internacionalPesado;
		// this.costoPaises = costoPaises;
	}
	
	
	public double getCostoEnvioLocal(boolean entregaRapida) {
		if (!entregaRapida)
			return this.localEntregaEstandar;
		else
			return this.localEntregaRapida;
	}
	
	
	public double getCostoEnvioInterurbano (int km, int peso) {
		if (km < 100)
			return  this.interurbanoDistanciaCorta * peso;
		
		if (km < 500)
			return  this.interurbanoDistanciaMedia * peso;
		
		return  this.interurbanoDistanciaLarga * peso;
	}
	
	/*
	public double getCostoEnvioInternacional(Pais pais, int peso) {
		if (peso <= 1000)
			return costoPaises.contains(pais) + internacionalLiviano * peso;

		return costoPaises.contains(pais) + internacionalPesado * peso;
	}
	*/
}
