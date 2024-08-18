package TP_Grafos;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;

    public Mapa (Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    /*------------------------------------- 1 -------------------------------------*/
    public List<String> devolverCamino (String ciudad1, String ciudad2) {
    	List<String> camino = new LinkedList<>();
    	
    	if (!mapaCiudades.isEmpty()) {
    		Vertex<String> origen = mapaCiudades.search(ciudad1);
    		Vertex<String> destino = mapaCiudades.search(ciudad2);
    		
    		if (origen != null && destino != null)
    			devolverCaminoHelper (origen, new boolean[mapaCiudades.getSize()], ciudad2, camino);
    	}
    	
    	return camino;
    }
    
    private boolean devolverCaminoHelper (Vertex<String> vertex, boolean[] visitados, String ciudad2, List<String> camino) {
    	visitados[vertex.getPosition()] = true;
    	camino.add(vertex.getData());
    	boolean paro = false;
    	
    	if (vertex.getData().equals(ciudad2))
    		return true;
    	else {
    		for (Edge<String> edge: mapaCiudades.getEdges(vertex)) {
    			if (!visitados[edge.getTarget().getPosition()] && !paro)
    				paro = devolverCaminoHelper (edge.getTarget(), visitados, ciudad2, camino);
    		}
    	}
    	
    	if (!paro) {
    		visitados[vertex.getPosition()] = false;
    		camino.remove(vertex.getData());
    	}
    	return paro;
    }
    

    /*------------------------------------- 2 -------------------------------------*/
    public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades) {
    	List<String> camino = new LinkedList<>();
    	
    	if (!mapaCiudades.isEmpty()) {
    		Vertex<String> origen = mapaCiudades.search(ciudad1);
    		Vertex<String> destino = mapaCiudades.search(ciudad2);
    		
    		if (origen != null && destino != null) {
    			boolean[] visitados = new boolean[mapaCiudades.getSize()];
    			
    			for (String ciudad: ciudades) {
    				Vertex<String> v = mapaCiudades.search(ciudad);
    				
    				if (v != null)
    					visitados[v.getPosition()] = true;
    			}
    			
    			devolverCaminoHelper(origen, visitados, ciudad2, camino);
    		}
    	}
    	return camino;
    }
   
  
    /*------------------------------------- 3 -------------------------------------*/
    public List<String> caminoMasCorto (String ciudad1, String ciudad2) {
    	List<String> camino = new LinkedList<>();
    	
    	if (!mapaCiudades.isEmpty()) {
    		Vertex<String> origen = mapaCiudades.search(ciudad1);
    		Vertex<String> destino = mapaCiudades.search(ciudad2);
    		
    		if (origen != null && destino != null)
    			caminoMasCortoHelper (origen, ciudad2, new boolean[mapaCiudades.getSize()], camino, new LinkedList<>(), 9999, 0);
    	}
    	
    	return camino;
    }
    
    private int caminoMasCortoHelper (Vertex<String> vertex, String ciudad2, boolean[] visitados, List<String> caminoMin, List<String> caminoAct, int min, int cant) {
    	visitados[vertex.getPosition()] = true;
    	caminoAct.add(vertex.getData());
    	
    	if (vertex.getData().equals(ciudad2) && cant < min) {
    		min = cant;
    		caminoMin.removeAll(caminoMin);
    		caminoMin.addAll(caminoAct);
    	}
    	else {
    		for (Edge<String> edge: mapaCiudades.getEdges(vertex)) {
    			if (!visitados[edge.getTarget().getPosition()])
    				min = caminoMasCortoHelper (edge.getTarget(), ciudad2, visitados, caminoMin, caminoAct, min, cant+edge.getWeight());
    		}
    	}
    	
    	caminoAct.remove(caminoAct.size()-1);
    	visitados[vertex.getPosition()] = false;
    	return min;
    }
    
    
    /*------------------------------------- 4 -------------------------------------*/
    public List<String> caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
    	List<String> camino = new LinkedList<>();
    	
    	if (!mapaCiudades.isEmpty()) {
    		Vertex<String> origen = mapaCiudades.search(ciudad1);
    		Vertex<String> destino = mapaCiudades.search(ciudad2);
    		
    		if (origen != null && destino != null)
    			caminoSinCombustibleHelper (origen, new boolean[mapaCiudades.getSize()], ciudad2, camino, tanqueAuto);
    	}
    		
    	
    	return camino;
    }
    
    private boolean caminoSinCombustibleHelper (Vertex<String> vertex, boolean[] visitados, String ciudad2, List<String> camino, int tanque) {
    	visitados[vertex.getPosition()] = true;
    	camino.add(vertex.getData());
    	boolean paro = false;
    	
    	if (vertex.getData().equals(ciudad2))
    		return true;
    	else {
    		for (Edge<String> edge: mapaCiudades.getEdges(vertex)) {
    			int combustibleNecesario = edge.getWeight();
    			
    			if (!visitados[edge.getTarget().getPosition()] && !paro && tanque - combustibleNecesario >= 0)
    				paro = caminoSinCombustibleHelper (edge.getTarget(), visitados, ciudad2, camino, tanque-combustibleNecesario);
    		}	
    	}
    	if (!paro) {
    		camino.remove(camino.size()-1);
    		visitados[vertex.getPosition()] = false;
    	}
    	return paro;
    }
    	
    	
    /*------------------------------------- 5 -------------------------------------*/
    public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
    	List<String> camino = new LinkedList<>();
    	
    	if (!mapaCiudades.isEmpty()) {
    		Vertex<String> origen = mapaCiudades.search(ciudad1);
    		Vertex<String> destino = mapaCiudades.search(ciudad2);
    		
    		if (origen != null && destino != null) 
    			helper (origen, new boolean[mapaCiudades.getSize()], ciudad2, camino, new LinkedList<String>(), tanqueAuto, tanqueAuto, 0, 9999);
    	}
    	
    	return camino;
    }
    
    private int helper (Vertex<String> vertex, boolean[] visitados, String ciudad2, List<String> caminoMin, List<String> caminoAct, int tanqueMax, int tanqueAct, int rec, int recMin) {
    	visitados[vertex.getPosition()] = true;
    	caminoAct.add(vertex.getData());
    	
    	if (vertex.getData().equals(ciudad2) && rec < recMin) {
    		recMin = rec;
    		caminoMin.removeAll(caminoMin);
    		caminoMin.addAll(caminoAct);
    	}
    	else {
    		for (Edge<String> edge: mapaCiudades.getEdges(vertex)) {
    			if (!visitados[edge.getTarget().getPosition()] && tanqueAct - edge.getWeight() >= 0)
    				recMin = helper (edge.getTarget(), visitados, ciudad2, caminoMin, caminoAct, tanqueMax, tanqueAct - edge.getWeight(), rec, recMin);
    			
    			else if (!visitados[edge.getTarget().getPosition()] && tanqueMax - edge.getWeight() >= 0)
    				recMin = helper(edge.getTarget(), visitados, ciudad2, caminoMin, caminoAct, tanqueMax, tanqueMax - edge.getWeight(), rec+1, recMin);
    		}
    	}
    	
    	visitados[vertex.getPosition()] = false;
    	caminoAct.remove(caminoAct.size()-1);
    	return recMin;
    }
    
  
    /*-----------------------------------------------------------------------------*/
    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.print(mapa.devolverCamino("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        System.out.print(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
        System.out.print(mapa.caminoMasCorto("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
        System.out.print(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 10));
        
        System.out.println("");

        System.out.print("LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: ");
        System.out.print(mapa.caminoConMenorCargaDeCombustible("La Plata", "San Vicente", 4));
        
        System.out.println("");
    }
}
