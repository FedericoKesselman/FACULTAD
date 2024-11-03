package io.github.unlp_oo.EJ19_OO1;
import java.time.LocalDate;
import java.util.*;

public abstract class Cliente {
	private String nombre;
	private String direccion;
	private List<Envio> envios;
	
	
	public Cliente (String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.envios = new LinkedList<Envio>();
	}
	
	
	public void agregarEnvio (Envio envio) {
		this.envios.add(envio);
	}
	
	
	public double calcularMontoTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		double total = 0.0;
		
		for (Envio envio : envios) { // seria mejor manejarlo en Envio? (por el concepto de envidia)
            if (envio.getFecha().isAfter(fechaInicio.minusDays(1)) && 
                envio.getFecha().isBefore(fechaFin.plusDays(1))) {
                total += envio.calcularCosto();
            }
        }
		
		return total;
	}
}
