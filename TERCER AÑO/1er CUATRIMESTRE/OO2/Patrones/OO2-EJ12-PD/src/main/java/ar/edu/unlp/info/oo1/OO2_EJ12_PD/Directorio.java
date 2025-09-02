package ar.edu.unlp.info.oo1.OO2_EJ12_PD;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Directorio extends Component{
	private List<Component> componentes;

    public Directorio(String nombre, LocalDate fecha) {
        super(nombre, fecha);
        this.componentes = new ArrayList<>();
    }
    
    public void agregar(Component componente) {
    	this.componentes.add(componente);
    }

	@Override
	public double tamanoTotalOcupado() {
		return 32 + this.componentes.stream()
			.mapToDouble(c -> c.tamanoTotalOcupado())
			.sum();
	}

	@Override
	public Archivo archivoMasGrande() {
	    return this.componentes.stream()
	        .map(elemento -> elemento.archivoMasGrande())  // Por cada elemento llama a su metodo archivoMasGrande() 
	        .max((ar1, ar2) -> Double.compare(ar1.tamanoTotalOcupado(), ar2.tamanoTotalOcupado()) )
	        .orElse(null);                       
	}


	@Override
	public Archivo archivoMasNuevo() {
		return this.componentes.stream()
		        .map(elemento -> elemento.archivoMasNuevo())  
		        .max((ar1, ar2) -> ar1.getFechaCreacion().compareTo(ar2.getFechaCreacion()) )
		        .orElse(null);    
	}

	@Override
	public Component buscar(String nombre) {
		if (this.getNombre().equals(nombre)) return this;
		
		return this.componentes.stream()
				.map(componente -> componente.buscar(nombre))
				.filter(Objects::nonNull)
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Component> buscarTodos(String nombre) {
		 List<Component> resultados = new ArrayList<>();
		 if (this.getNombre().equals(nombre)) resultados.add(this);
		    
		// flatMap para "aplanar" las listas de resultados de cada búsqueda
	    this.componentes.stream()
	        .flatMap(elemento -> elemento.buscarTodos(nombre).stream()) 
	        	.forEach(resultado -> resultados.add(resultado));
	    
	    return resultados;
	}

	@Override
	public String listadoDeContenido(String pathActual) {
		String myPath = pathActual + "/" + this.getNombre();
	    
	    return myPath + "\n" + 
	           this.componentes.stream()
	               .map(elemento -> elemento.listadoDeContenido(myPath))
	               .collect(Collectors.joining());
	}
}
