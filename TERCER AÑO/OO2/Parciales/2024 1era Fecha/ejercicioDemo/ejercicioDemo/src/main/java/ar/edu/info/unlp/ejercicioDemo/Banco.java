package ar.edu.info.unlp.ejercicioDemo;
import java.util.*;

public class Banco {
	private List<Cliente> clientes;
	private List<Prestamo> prestamos;
	private double interes;
	
	public Banco(double interes) {
		this.clientes = new LinkedList<>();
		this.prestamos = new LinkedList<>();
		this.interes = interes;
	}
	
	public void altaCliente(String nombre, Double salario) {
		this.clientes.add(new Cliente(nombre, salario));
	}
	
	public Prestamo solicitarPrestamoSimple(int cantCuotas, double monto, Cliente cliente) {
		Prestamo prestamo = new PrestamoSimple(monto, cantCuotas, cliente, interes);
		this.prestamos.add(prestamo);
		return prestamo; // Lo hago asi para testear
	}
	
	public Prestamo solicitarPrestamoUVA(int cantCuotas, double monto, Cliente cliente) {
		Prestamo prestamo = new PrestamoUVA(monto, cantCuotas, cliente);
		this.prestamos.add(prestamo);
		return prestamo;
	}
}
