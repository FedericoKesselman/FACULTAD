package ar.edu.unlp.info.oo1.OO2_EJ12_PD;

import java.util.List;

public class FileSystem {
    private Directorio raiz;

    public FileSystem(Directorio raiz) {
        this.raiz = raiz;
    }

    public double tamanoTotalOcupado() {
        return raiz.tamanoTotalOcupado();
    }

    public Archivo archivoMasGrande() {
        return raiz.archivoMasGrande();
    }

    public Archivo archivoMasNuevo() {
        return raiz.archivoMasNuevo();
    }

    public Component buscar(String nombre) {
        return raiz.buscar(nombre);
    }

    public List<Component> buscarTodos(String nombre) {
        return raiz.buscarTodos(nombre);
    }

    public String listadoDeContenido() {
        return raiz.listadoDeContenido("");
    }
}
