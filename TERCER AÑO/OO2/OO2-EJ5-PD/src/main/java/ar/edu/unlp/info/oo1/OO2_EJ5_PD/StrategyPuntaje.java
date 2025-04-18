package ar.edu.unlp.info.oo1.OO2_EJ5_PD;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StrategyPuntaje extends Strategy{

	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador){
		return decodificador.getPeliculasNoReproducidas().stream()
			.sorted((p1, p2) -> {
				int comparacion = Double.compare(p2.getPuntaje(), p1.getPuntaje()); // compara puntaje
				if (comparacion == 0) { // a igual puntaje, compara por fecha 
					return p2.getAnioEstreno().compareTo(p1.getAnioEstreno());
				}
				return comparacion; // puntaje distintos
			})
			.limit(3)
			.collect(Collectors.toList());
	}
}
