package oo2ej7pd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        this.calculadora = new Calculadora();
    }

    @Test
    void testEstadoInicial() {
        assertEquals("0.0", calculadora.getResultado());
        calculadora.setValor(1.1);
        assertEquals("1.1", calculadora.getResultado());
    }

    @Test
    void testSuma() {
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.setValor(5);
        assertEquals("15.0", calculadora.getResultado());
    }

    @Test
    void testDivision() {
        calculadora.setValor(12);
        calculadora.dividiendo();
        calculadora.setValor(3);
        assertEquals("4.0", calculadora.getResultado());
    }

    @Test
    void testDivisionError() {
        calculadora.setValor(12);
        calculadora.dividiendo();
        calculadora.setValor(0);
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    void testFaltaDeOperando() {
        calculadora.setValor(10);
        calculadora.dividiendo();
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    void testDosOperandos() {
        calculadora.setValor(10);
        calculadora.multiplicando();
        calculadora.dividiendo();
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    void testBorrar() {
        calculadora.setValor(100);
        calculadora.borrar();
        assertEquals("0.0", calculadora.getResultado());
    }
}
