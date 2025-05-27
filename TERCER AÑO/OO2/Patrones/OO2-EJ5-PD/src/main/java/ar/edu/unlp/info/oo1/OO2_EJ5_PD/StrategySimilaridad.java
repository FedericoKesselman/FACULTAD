package ar.edu.unlp.info.oo1.OO2_EJ5_PD;

import java.util.List;
import java.util.stream.Collectors;

public class StrategySimilaridad extends Strategy {

	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getPeliculasNoReproducidas().stream()                              
			.flatMap(p -> p.getSimilares().stream())                                   // junta todo en un stream
			.filter(p -> !decodificador.getPeliculasNoReproducidas().contains(p))                // FILTRAR reproducidas
			.distinct()                                                               // elimina duplicados
			.sorted((p1, p2) -> p2.getAnioEstreno().compareTo(p1.getAnioEstreno())) // ordenar por fecha
			.limit(3)                                                                 // 3 elementos
			.collect(Collectors.toList());                                            
	}
}
