package ar.edu.unlp.info.oo2.OO2_EJ13_PD;

public class Script {
	public static void main(String[] args) {
        SubteWay subteWay = new SubteWay(new BuilderClasico());

        // Sándwich Clásico
        subteWay.setBuilder(new BuilderClasico());
        Sandwich clasico = subteWay.construirSandwich();
        System.out.println("Sándwich Clásico - Precio: " + clasico.precioSandwich() + " pesos");

        // Sándwich Vegetariano
        subteWay.setBuilder(new BuilderVegetariano());
        Sandwich vegetariano = subteWay.construirSandwich();
        System.out.println("Sándwich Vegetariano - Precio: " + vegetariano.precioSandwich() + " pesos");

        // Sándwich Vegano
        subteWay.setBuilder(new BuilderVegano());
        Sandwich vegano = subteWay.construirSandwich();
        System.out.println("Sándwich Vegano - Precio: " + vegano.precioSandwich() + " pesos");

        // Sándwich Sin TACC
        subteWay.setBuilder(new BuilderSinTacc());
        Sandwich sinTACC = subteWay.construirSandwich();
        System.out.println("Sándwich Sin TACC - Precio: " + sinTACC.precioSandwich() + " pesos");
	}
}
