package TP_Grafos;
import java.util.*;


public class carteraJubilados {

	public List<Persona> crearCartera (Graph<Persona> personas, String empleado, int separacion) {
		List<Persona> cartera = new LinkedList<>();
		
		if (!personas.isEmpty()) {
			Vertex<Persona> emp = buscarEmpleado (personas, empleado);
			
			if (emp != null) {
				Queue<Vertex<Persona>> cola = new Queue<>();
				boolean[] visitados = new boolean[personas.getSize()];
				visitados[emp.getPosition()] = true;
				
				cola.enqueue(emp);
				cola.enqueue(null);
				
				int distancia = 0;

				while (!cola.isEmpty() && distancia < separacion && cartera.size() < 40) {
					Vertex<Persona> graph_aux = cola.dequeue();
					
					if (graph_aux != null) {
						for (Edge<Persona> edge: personas.getEdges(graph_aux)) {
							if (!visitados[edge.getTarget().getPosition()]) {
								visitados[edge.getTarget().getPosition()] = true;
								cola.enqueue(edge.getTarget());
							}
						}
						
						if (graph_aux.getData().cumple() && cartera.size() < 40)
							cartera.add(graph_aux.getData());
					}
					else if (!cola.isEmpty()) {
						cola.enqueue(null);
						distancia++;
					}
				}
			}
		}
		return cartera;
	}
	
	
	
	
	private Vertex<Persona> buscarEmpleado (Graph<Persona> personas, String empleado) {
		for (Vertex<Persona> vertex: personas.getVertices()) {
			if (vertex.getData().getNombre().equals(empleado))
				return vertex;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex(new Persona(false, "Matias", "AAA", true));
        Vertex v2 = grafo.createVertex(new Persona(true, "Julian", "BBB", false));
        Vertex v3 = grafo.createVertex(new Persona(true, "Francisco", "CCC", false));
        Vertex v4 = grafo.createVertex(new Persona(false, "Valentin", "DDD", true));
        Vertex v5 = grafo.createVertex(new Persona(true, "Omar", "EEE", true));
        Vertex v6 = grafo.createVertex(new Persona(false, "Rosana", "FFF", true));
        Vertex v7 = grafo.createVertex(new Persona(true, "Maria", "GGG", false));
        Vertex v8 = grafo.createVertex(new Persona(true, "Sandra", "HHH", true));
        Vertex v9 = grafo.createVertex(new Persona(true, "Matheo", "III", false));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        carteraJubilados banco = new carteraJubilados();
        
        System.out.println(banco.crearCartera(grafo, "Matias", 3));
    }
        
}
