package TP_Grafos.Parcial1;
import java.util.*;
import TP_Grafos.*;

public class Parcial {

	public String resolver (Graph<Temaiken> sitios, int tiempo) {
		boolean ok = false;
		
		if (!sitios.isEmpty()) {
			Vertex<Temaiken> origen = null;
			
			for (Vertex<Temaiken> v: sitios.getVertices()) {
				if (v.getData().getNombre().equals("Entrada")) {
					origen = v; 
					break;
				}
			}
			
			if (origen != null)
				ok = helper (sitios, origen, new boolean[sitios.getSize()], tiempo, 0);
		}
		
		if (ok) return "Alcanzable";
		else return "No Alcanzable";
	}
	
	private boolean helper (Graph<Temaiken> sitios, Vertex<Temaiken> vertex, boolean[] visitados, int tiempo, int cant) {
		visitados[vertex.getPosition()] = true;
		boolean paro = false;
		
		if (tiempo - vertex.getData().getMinutos() >= 0) {
			tiempo -= vertex.getData().getMinutos();
			cant += 1;
			
			if (cant == sitios.getSize())
				return true;
			else {
				for (Edge<Temaiken> edge: sitios.getEdges(vertex)) {
					int pos = edge.getTarget().getPosition(); 
					int time = edge.getWeight();
					
					if (!visitados[pos] && !paro && tiempo-time >= 0)
						paro = helper (sitios, edge.getTarget(), visitados, tiempo-time, cant);
				}
			}
		}
		visitados[vertex.getPosition()] = false;
		return paro;
	}
	
	public static void main(String[] args) {
        // Create a new graph
        Graph<Temaiken> grafo = new AdjListGraph<>();

        // Create vertices
        Vertex<Temaiken> entrada = grafo.createVertex(new Temaiken("Entrada", 15));
        Vertex<Temaiken> tigres = grafo.createVertex(new Temaiken("Tigres", 10));
        Vertex<Temaiken> cebras = grafo.createVertex(new Temaiken("Cebras", 10));
        Vertex<Temaiken> flamencos = grafo.createVertex(new Temaiken("Flamencos", 10));
        Vertex<Temaiken> murcielagos = grafo.createVertex(new Temaiken("Murciélagos", 20));
        Vertex<Temaiken> wallabies = grafo.createVertex(new Temaiken("Wallabies", 30));
        Vertex<Temaiken> tortugas = grafo.createVertex(new Temaiken("Tortugas", 10));
        Vertex<Temaiken> pumas = grafo.createVertex(new Temaiken("Pumas", 10));

        // Connect vertices with edges and weights
        grafo.connect(entrada, cebras, 10);
        grafo.connect(cebras, entrada, 10);

        grafo.connect(entrada, tigres, 15);
        grafo.connect(tigres, entrada, 15);

        grafo.connect(entrada, flamencos, 25);
        grafo.connect(flamencos, entrada, 25);

        grafo.connect(entrada, murcielagos, 20);
        grafo.connect(murcielagos, entrada, 20);

        grafo.connect(tigres, cebras, 8);
        grafo.connect(cebras, tigres, 8);

        grafo.connect(cebras, tortugas, 5);
        grafo.connect(tortugas, cebras, 5);

        grafo.connect(wallabies, tortugas, 10);
        grafo.connect(tortugas, wallabies, 10);

        grafo.connect(wallabies, pumas, 2);
        grafo.connect(pumas, wallabies, 2);

        grafo.connect(tortugas, pumas, 15);
        grafo.connect(pumas, tortugas, 15);
        grafo.connect(murcielagos, flamencos, 25);
        grafo.connect(flamencos, murcielagos, 25);

        grafo.connect(murcielagos, wallabies, 10);
        grafo.connect(wallabies, murcielagos, 10);

        Parcial p = new Parcial ();

        System.out.println(p.resolver(grafo, 195));

    }
	
}










