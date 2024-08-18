package TP_Grafos.Parcial3;
import TP_Grafos.*;

public class Parcial {
	
	public int resolver (Graph<Ciudad> ciudades, String origen, String destino, int maxControles) {
		int max = -1;
		
		if (!ciudades.isEmpty() && maxControles > 0) {
			Vertex<Ciudad> ori = buscarCiudad(ciudades, origen);
			Vertex<Ciudad> des = buscarCiudad(ciudades, destino);
			
			if (ori != null && des != null)
				max = resolverHelper (ciudades, ori, destino, new boolean[ciudades.getSize()], maxControles, 0, -1);
		}
		return max;
	}
	
	private int resolverHelper (Graph<Ciudad> ciudades, Vertex<Ciudad> vertex, String destino, boolean[] visitados, int maxControles, int cant, int max) {
		visitados[vertex.getPosition()] = true;
		cant += vertex.getData().getDias();
		
		if (vertex.getData().getNombre().equals(destino) && cant > max) {
			max = cant;
			return max;
		}
		else {
			for (Edge<Ciudad> edge: ciudades.getEdges(vertex)) {
				if (!visitados[edge.getTarget().getPosition()] && edge.getWeight() <= maxControles)
					max = resolverHelper (ciudades, edge.getTarget(), destino, visitados, maxControles, cant, max);
			}
		}
		
		visitados[vertex.getPosition()] = false;
		return max;
	}
	
	private Vertex<Ciudad> buscarCiudad (Graph<Ciudad> ciudades, String ciudad) {
		for (Vertex<Ciudad> v: ciudades.getVertices()) {
			if (v.getData().getNombre().equals(ciudad))
				return v;
		}
		return null;
	}
	
}
