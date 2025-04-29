package ar.edu.unlp.info.oo1.OO2_EJ9_PD;

import java.time.LocalDate;

public class Programa {
	public static void main(String[] args) {
        AutoEnAlquiler auto = new AutoEnAlquiler(10.0, 4, "BMW", new PoliticaFlexible());
        Usuario usuario = new Usuario("Juan");
        usuario.agregarAutoAlquiler(auto);
        
        LocalDate inicio = LocalDate.now().plusDays(10); // Reserva dentro de 10 días
        Reserva reserva = new Reserva(10, inicio, usuario, auto);
        
        // Politica flexible
        System.out.println("Monto total: $" + reserva.montoAPagar());
        System.out.println("Reembolso: $" + reserva.montoAReembolsar());

        // Politica estricta
        auto.setPolitica(new PoliticaEstricta());
        System.out.println("Monto total: $" + reserva.montoAPagar());
        System.out.println("Reembolso: $" + reserva.montoAReembolsar());
    }
}
