package ArbolesG;
import java.util.*;

public class Parcial {
	GeneralTree<Integer> arbol;
	
	public List<Integer> resolver(int num) {
		List<Integer> lista = new LinkedList<>();
		
		if (!arbol.isEmpty())
			resolverHelper (arbol, lista, new LinkedList<Integer>(), num);
		
		return lista;
	}
	
	private boolean resolverHelper (GeneralTree<Integer> nodo, List<Integer> camino, List<Integer> caminoAct, int num) {
		caminoAct.add(nodo.getData());
		
		if ( (nodo.isLeaf()) && (camino.isEmpty()) ) {
			camino.addAll(caminoAct);
			return true;
		}
		else {
			boolean paro = false;
			
			if (nodo.getChildren().size() >= num) {
				for (GeneralTree<Integer> child: nodo.getChildren()) {
					if (!paro)
						paro = resolverHelper (child, camino, caminoAct, num);
				}
			}
			
			caminoAct.remove(caminoAct.size()-1);
			return paro;
		}
	}
}
