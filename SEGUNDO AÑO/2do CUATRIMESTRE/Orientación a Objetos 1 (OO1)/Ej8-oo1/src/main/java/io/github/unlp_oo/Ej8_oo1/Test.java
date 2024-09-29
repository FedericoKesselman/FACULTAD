package io.github.unlp_oo.Ej8_oo1;

public class Test {

	public static void main(String[] args) {
		Gerente alan = new Gerente("Alan Turing");
		double aportesDeAlan = alan.aportes();

		Gerente alan2 = new Gerente("Alan Turing");
		double sueldoBasicoDeAlan = alan2.sueldoBasico();

		System.out.println("APORTES DE ALAN = " + aportesDeAlan);  // 2850
		System.out.println("SUELDO BASICO DE ALAN = " + sueldoBasicoDeAlan); // 
		
		/*
		 1) alan.aportes() , ejecuta:
		 		aportes() de Gerente
		 		montoBasico() de Gerente
		 		
		 	RETORNA: 2.850
		  
		 
		 2) alan2.sueldoBasico(), ejecuta:  
		 		sueldoBasico() de EmpleadoJerarquico: 67.850
		 		
		 			sueldoBasico() de Empleado: 59.850
		 				montoBasico() de Gerente : 57.000
		 				aportes() de Gerente : 2.850
		 				
	 				bonoPorCategoria() de EmpleadoJerarquico: 8.000

			RETORNA: 67.850
			
			La clase gerente no tiene el metodo sueldoBasico() por lo que lo busca en su superclase EmpleadoJerarquico y 
			lo ejecuta. 
			El sueldoBasico() de EmpleadoJerarquico ejecuta con super el metodo sueldoBasico() de Empleado. Este metodo 
			ejecuta montoBasico() y aportes() de GERENTE (ya que son llamados con .this y la clase Gerente los tiene)
			
			El sueldoBasico() de EmpleadoJerarquico ejecuta por ultimo al metodo bonoPorCategoria() de EmpleadoJerarquico.
			La busqueda comienza en Gerente, no lo encuentra y continua en la superclase la busqueda donde si lo encuentra
		 */
		
		
	}
	
}
