package TP_Grafos.GitHub;
import TP_Grafos.*;
import java.util.*;

public class Ejer2 {

	private boolean helper(Graph<Ciudad> ciudades, Vertex<Ciudad> vertex, Vertex<Ciudad> destino, boolean[] visitados, List<Ciudad> camino, List<Ciudad> listaCiudades) {
		visitados[vertex.getPosition()] = true;
		camino.add(vertex.getData());
		boolean ok = false;
		
		if (vertex == destino) {
			return camino.containsAll(listaCiudades);
		}
		else {
			for (Edge<Ciudad> edge: ciudades.getEdges(vertex)) {
				int pos = edge.getTarget().getPosition();
				
				if (!visitados[pos] && !ok)
					ok = helper (ciudades, edge.getTarget(), destino, visitados, camino, listaCiudades);
			}
		}
		
		visitados[vertex.getPosition()] = false;
		if (!ok)
			camino.add(vertex.getData());
		return ok;
	}
	
}
