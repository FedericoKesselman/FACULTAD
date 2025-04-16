package ar.edu.unlp.info.oo1.OO2_EJ5_PD;

import java.util.*;
import java.util.stream.Collectors;

public class StrategyNovedad extends Strategy{

	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador){
		return decodificador.getPeliculasNoReproducidas().stream()
				.sorted((p1, p2) -> p2.getFechaEstreno().compareTo(p1.getFechaEstreno())) // descendente
				.limit(3)
				.collect(Collectors.toList());
	}
	
}
