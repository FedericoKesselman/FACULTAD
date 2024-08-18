package TP_Grafos.GitHub;
import TP_Grafos.*;
import java.util.*;

public class Ejer1 {
	
	public List<Ciudad> resolver (Graph<Ciudad> ciudades, String origen, String destino) {
		List<Ciudad> camino = new LinkedList<>();
		
		if (!ciudades.isEmpty()) {
			Vertex<Ciudad> ori = buscarCiudad (ciudades, origen);
			Vertex<Ciudad> des = buscarCiudad (ciudades, destino);
			
			if (ori != null && des != null)
				resolverHelper (ciudades, ori, des, new boolean[ciudades.getSize()], camino);
		}
		
		return camino;
	}
	
	
	private boolean resolverHelper (Graph<Ciudad> ciudades, Vertex<Ciudad> vertex, Vertex<Ciudad> des, boolean[] visitados, List<Ciudad> camino) {
		visitados[vertex.getPosition()] = true;
		camino.add(vertex.getData());
		boolean paro = false;
		
		if (vertex == des)
			return true;
		else {
			for (Edge<Ciudad> edge: ciudades.getEdges(vertex)) {
				int fase = edge.getTarget().getData().getFase();
				int pos = edge.getTarget().getPosition();
				
				if (!visitados[pos] && !paro && fase != 1)
					paro = resolverHelper (ciudades, edge.getTarget(), des, visitados, camino);
			}
		}
		
		if (!paro)
			camino.remove(camino.size()-1);
		visitados[vertex.getPosition()] = false;
		return paro;
	}
	
	
	private Vertex<Ciudad> buscarCiudad (Graph<Ciudad> ciudades, String nombre) {
		for (Vertex<Ciudad> v: ciudades.getVertices()) {
			if (v.getData().getNombre().equals(nombre))
				return v;
		}
		return null;
	}
}
