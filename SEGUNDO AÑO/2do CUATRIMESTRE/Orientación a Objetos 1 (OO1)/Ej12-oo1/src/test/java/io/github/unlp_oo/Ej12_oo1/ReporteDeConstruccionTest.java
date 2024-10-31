package io.github.unlp_oo.Ej12_oo1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	ReporteDeConstruccion reporte;
	Cilindro cilindro;
	Esfera esfera;
	PrismaRectangular prisma;
	
	@BeforeEach
	void setUp() throws Exception {
		reporte = new ReporteDeConstruccion();
		cilindro = new Cilindro ("Hierro", "Azul", 5, 10);
		esfera = new Esfera ("Hierro", "Naranja", 10);
		prisma = new PrismaRectangular ("Papel", "Azul", 10, 5, 30);
	}
	
	@Test
	void testConstructoresYClases() {
		assertEquals (785, Math.round(cilindro.getVolumen()));
		assertEquals (471, Math.round(cilindro.getSuperficie()));
		
		assertEquals (4189, Math.round(esfera.getVolumen()));
		assertEquals (1257, Math.round(esfera.getSuperficie()));
		
		assertEquals (1500, prisma.getVolumen());
		assertEquals (1000, prisma.getSuperficie());
	}
	
	@Test
	void testReportes() {
		reporte.agregarPieza(cilindro);
		reporte.agregarPieza(esfera);
		reporte.agregarPieza(prisma);
		
		assertEquals (4974, Math.round(reporte.getVolumenDeMaterial("Hierro")));
		assertEquals (1500, reporte.getVolumenDeMaterial("Papel"));
		
		assertEquals (1471, Math.round(reporte.superficieDeColor("Azul")));
		assertEquals (1257, Math.round(reporte.superficieDeColor("Naranja")));
	}
	
	
}
