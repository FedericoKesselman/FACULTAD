package TP_Grafos.Parcial2;
import java.util.*;
import TP_Grafos.*;

public class Parcial2 {

	public List<String> estadios (Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm) {
		List<String> camino = new LinkedList<>();
		
		if (!mapaEstadios.isEmpty() && cantKm > 0) {
			Vertex<Estadio> origen = null;
			
			for (Vertex<Estadio> v: mapaEstadios.getVertices()) {
				if(v.getData().getNombreCiudad().equals(estadioOrigen)) {
					origen = v;
					break;
				}
			}
			
			if (origen != null)
				estadiosHelper (mapaEstadios, origen, new boolean[mapaEstadios.getSize()], camino, new LinkedList<String>(), cantKm);
		}
		
		return camino;
	}
	
	private void estadiosHelper (Graph<Estadio> mapaEstadios, Vertex<Estadio> vertex, boolean[] visitados, List<String> caminoMax, List<String> caminoAct, int kmAct) {
		visitados[vertex.getPosition()] = true;
		caminoAct.add(vertex.getData().getNombre());
		
		if (caminoAct.size() > caminoMax.size()) {
			caminoMax.removeAll(caminoMax);
			caminoMax.addAll(caminoAct);
		}
		
		for (Edge<Estadio> edge: mapaEstadios.getEdges(vertex)) {
			int kmArista = edge.getWeight();
			
			if (!visitados[edge.getTarget().getPosition()] && kmAct-kmArista >= 0)
				estadiosHelper (mapaEstadios, edge.getTarget(), visitados, caminoMax, caminoAct, kmAct - kmArista);
		}	
		
		visitados[vertex.getPosition()] = false;
		caminoAct.remove(caminoAct.size()-1);
	}
	
	
	public static List<List<String>> parcial (Graph<String> grafo) {
		List<List<String>> caminos = new LinkedList<>();
		
		if (!grafo.isEmpty()) {
			boolean[] visitados = new boolean[grafo.getSize()];
			for (Vertex<String> ver: grafo.getVertices()) {
				helper (grafo, ver, visitados, caminos, new LinkedList<String>(), 0);
			}
		}
		
		return caminos;
	}
	
	private static void helper (Graph<String> grafo, Vertex<String> vertex, boolean[] visitados, List<List<String>> caminos, List<String> caminoAct, int cant) {
		visitados[vertex.getPosition()] = true;
		caminoAct.add(vertex.getData());
		
		if (cant == 10)
			caminos.add(new LinkedList<String>(caminoAct));
		else {
			for (Edge<String> edge: grafo.getEdges(vertex)) {
				if (!visitados[edge.getTarget().getPosition()] && cant+edge.getWeight() <= 10)
					helper (grafo, edge.getTarget(), visitados, caminos, caminoAct, cant+edge.getWeight());
			}
		}
		
		caminoAct.remove(caminoAct.size()-1);
		visitados[vertex.getPosition()] = false;
	}
	
	
	public static void main(String[] args) {
        Graph<String> lugares = new AdjListGraph<String>();
        Vertex<String> v1 = lugares.createVertex("Holmenkollen");
        Vertex<String> v2 = lugares.createVertex("Parque Vigeland");
        Vertex<String> v3 = lugares.createVertex("Galería Nacional");
        Vertex<String> v4 = lugares.createVertex("Parque Botánico");
        Vertex<String> v5 = lugares.createVertex("Museo Munch");
        Vertex<String> v6 = lugares.createVertex("FolkMuseum");
        Vertex<String> v7 = lugares.createVertex("Palacio Real");
        Vertex<String> v8 = lugares.createVertex("Ayuntamiento");
        Vertex<String> v9 = lugares.createVertex("El Tigre");
        Vertex<String> v10 = lugares.createVertex("Akker Brigge");
        Vertex<String> v11 = lugares.createVertex("Museo Fram");
        Vertex<String> v12 = lugares.createVertex("Museo Vikingo");
        Vertex<String> v13 = lugares.createVertex("La Opera");
        Vertex<String> v14 = lugares.createVertex("Museo del Barco Polar");
        Vertex<String> v15 = lugares.createVertex("Fortaleza Akershus");   
        
        lugares.connect(v1, v2, 30);
        lugares.connect(v2, v1, 30);
        lugares.connect(v2, v3, 10);
        lugares.connect(v3, v2, 10);
        lugares.connect(v3, v4, 15);
        lugares.connect(v4, v3, 15);
        lugares.connect(v4, v5, 1);
        lugares.connect(v5, v4, 1);
        
        lugares.connect(v5, v9, 15);
        lugares.connect(v9, v5, 15);
        lugares.connect(v9, v13, 5);
        lugares.connect(v13, v9, 5);
        lugares.connect(v13, v15, 10);
        lugares.connect(v15, v13, 10);
        
        lugares.connect(v2, v6, 20);
        lugares.connect(v6, v2, 20);
        lugares.connect(v6, v7, 5);
        lugares.connect(v7, v6, 5);
        lugares.connect(v7, v8, 5);
        lugares.connect(v8, v7, 5);
        lugares.connect(v6, v10, 30);
        lugares.connect(v10, v6, 30);
        lugares.connect(v10, v8, 20);
        lugares.connect(v8, v10, 20);
        lugares.connect(v8, v4, 10);
        lugares.connect(v4, v8, 10);
        lugares.connect(v8, v9, 15);
        lugares.connect(v9, v8, 15);
        
        lugares.connect(v6, v11, 5);
        lugares.connect(v11, v6, 5);
        lugares.connect(v10, v12, 30);
        lugares.connect(v12, v10, 30);
        lugares.connect(v11, v14, 5);
        lugares.connect(v14, v11, 5);
        lugares.connect(v12, v14, 5);
        lugares.connect(v14, v12, 5);
        
        System.out.println(parcial(lugares));
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
