package ar.edu.unlp.info.oo1.OO2_EJ12_PD;

import java.time.LocalDate;
import java.util.List;

public class Archivo extends Component{
	private double tamano;

    public Archivo(String nombre, LocalDate fecha, int tamano) {
        super(nombre, fecha);
        this.tamano = tamano;
    }

	@Override
	public double tamanoTotalOcupado() {
		return this.tamano;
	}

	@Override
	public Archivo archivoMasGrande() {
		return this;
	}

	@Override
	public Archivo archivoMasNuevo() {
		return this;
	}

	@Override
	public Component buscar(String nombre) {
		return this.getNombre().equals(nombre) ? this : null;
	}

	@Override
    public List<Component> buscarTodos(String nombre) {
        return this.getNombre().equals(nombre) ? List.of(this) : List.of();
    }

	@Override
	public String listadoDeContenido(String pathActual) {
		return pathActual + "/" + this.getNombre() + "\n";
	}
}
