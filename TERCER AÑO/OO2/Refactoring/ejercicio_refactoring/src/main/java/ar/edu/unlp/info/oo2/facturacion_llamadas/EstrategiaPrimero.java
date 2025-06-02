package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public class EstrategiaPrimero extends GeneradorEstrategia{

	@Override
	protected String obtenerNumeroLibre(SortedSet<String> lineas) {
		return lineas.first();
	}
}
