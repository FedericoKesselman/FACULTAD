package TP_Grafos.Parcial2;
import java.util.*;
import TP_Grafos.*;

public class Parcial3 {

	public List<String> devolverRecorrido (Graph<Nodo> grafo) {
		List<String> camino = new LinkedList<>();
		
		if (!grafo.isEmpty()) {
			Vertex<Nodo> origen = buscarNodo(grafo, "A");
			Vertex<Nodo> destino = buscarNodo(grafo, "D");
			
			if (origen != null && destino != null)
				recorridoHelper (grafo, origen, new boolean[grafo.getSize()], camino);
		}
		
		return camino;
	}
	
	
	private boolean recorridoHelper (Graph<Nodo> grafo, Vertex<Nodo> vertex, boolean[] visitados, List<String> camino) {
		visitados[vertex.getPosition()] = true;
		camino.add(vertex.getData().getLetra());
		boolean paro = false;
		
		if (vertex.getData().getLetra().equals("D")) {
			return true;
		}
		else {
			for (Edge<Nodo> edge: grafo.getEdges(vertex)) {
				boolean color = edge.getTarget().getData().isColor();
				
				if (!visitados[edge.getTarget().getPosition()] && !paro && color != vertex.getData().isColor())
					paro = recorridoHelper (grafo, edge.getTarget(), visitados, camino);
			}
		}
		if (!paro)
			camino.remove(camino.size()-1);
		visitados[vertex.getPosition()] = false;
		return paro;
	}
	
	
	private Vertex<Nodo> buscarNodo (Graph<Nodo> grafo, String letra) {
		for (Vertex<Nodo> v: grafo.getVertices()) {
			if (v.getData().getLetra().equals(letra))
				return v;
		}
		return null;
	}
	
}
