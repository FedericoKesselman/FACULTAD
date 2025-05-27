public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.incrementarPuntuacion(100);
    }
    
    public void decrementar(Jugador j) {
        j.decrementarPuntuacion(50);
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public void incrementarPuntuacion(int puntos) {
        this.puntuacion += puntos;
    }

    public void decrementarPuntuacion(int puntos) {
        this.puntuacion -= puntos;
    }
}


