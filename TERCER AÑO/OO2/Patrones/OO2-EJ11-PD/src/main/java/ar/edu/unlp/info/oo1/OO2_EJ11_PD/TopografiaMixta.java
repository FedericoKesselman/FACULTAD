package ar.edu.unlp.info.oo1.OO2_EJ11_PD;
import java.util.*;

public class TopografiaMixta extends Topografia{
	private List<Topografia> componentes; // 4
	
	public TopografiaMixta(Topografia componente1, Topografia componente2, Topografia componente3, Topografia componente4) {
		this.componentes = new ArrayList<>();
		this.componentes.add(componente1);
		this.componentes.add(componente2);
		this.componentes.add(componente3);
		this.componentes.add(componente4);
	}
	
	public List<Topografia> getTopografia() {
		return this.componentes;
	}
	
	public double proporcionAgua() {
		return this.componentes.stream()
				.mapToDouble(componente -> componente.proporcionAgua()).sum() 
				/this.componentes.size();
	}
	
	@Override
	public List<Topografia> getComponentes() {
		return this.componentes;
	}
}
