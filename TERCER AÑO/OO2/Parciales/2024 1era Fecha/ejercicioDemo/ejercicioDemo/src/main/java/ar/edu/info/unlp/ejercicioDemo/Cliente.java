package ar.edu.info.unlp.ejercicioDemo;

public class Cliente {
	private String nombre;
	private double salario;
	
	public Cliente (String nombre, double Salario) {
		this.nombre = nombre;
		this.salario = salario;
	}

	public double getSalario() {
		return this.salario;
	}
}
