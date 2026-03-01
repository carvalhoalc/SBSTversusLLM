package br.com.exemplo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes gerados por EvoSuite para a classe Calculadora
 * Focando em cobertura de ramos (Branch Coverage)
 */
public class CalculadoraTest {
    
    private Calculadora calc = new Calculadora();
    
    // ===== Testes para o método calcular() =====
    
    @Test
    public void testCalcularAdicao() {
        double resultado = calc.calcular(5.0, '+', 3.0);
        assertEquals(8.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularSubtracao() {
        double resultado = calc.calcular(5.0, '-', 3.0);
        assertEquals(2.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularMultiplicacao() {
        double resultado = calc.calcular(5.0, '*', 3.0);
        assertEquals(15.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularDivisao() {
        double resultado = calc.calcular(6.0, '/', 2.0);
        assertEquals(3.0, resultado, 0.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalcularDivisaoPorZero() {
        calc.calcular(10.0, '/', 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalcularOperadorInvalido() {
        calc.calcular(5.0, '%', 3.0);
    }
    
    // ===== Testes para casos extremos =====
    
    @Test
    public void testCalcularAdicaoNegativo() {
        double resultado = calc.calcular(-5.0, '+', -3.0);
        assertEquals(-8.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularAdicaoMisto() {
        double resultado = calc.calcular(-5.0, '+', 3.0);
        assertEquals(-2.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularSubtracaoNegativo() {
        double resultado = calc.calcular(-5.0, '-', -3.0);
        assertEquals(-2.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularMultiplicacaoNegativo() {
        double resultado = calc.calcular(-5.0, '*', 3.0);
        assertEquals(-15.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularDivisaoNegativo() {
        double resultado = calc.calcular(-6.0, '/', 2.0);
        assertEquals(-3.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularZero() {
        double resultado = calc.calcular(0.0, '+', 0.0);
        assertEquals(0.0, resultado, 0.01);
    }
    
    @Test
    public void testCalcularFracao() {
        double resultado = calc.calcular(1.0, '/', 2.0);
        assertEquals(0.5, resultado, 0.01);
    }
    
    // ===== Testes para isOperadorValido() =====
    
    @Test
    public void testIsOperadorValidoAdicao() {
        assertTrue(calc.isOperadorValido('+'));
    }
    
    @Test
    public void testIsOperadorValidoSubtracao() {
        assertTrue(calc.isOperadorValido('-'));
    }
    
    @Test
    public void testIsOperadorValidoMultiplicacao() {
        assertTrue(calc.isOperadorValido('*'));
    }
    
    @Test
    public void testIsOperadorValidoDivisao() {
        assertTrue(calc.isOperadorValido('/'));
    }
    
    @Test
    public void testIsOperadorInvalido() {
        assertFalse(calc.isOperadorValido('%'));
    }
    
    @Test
    public void testIsOperadorInvalidoOutro() {
        assertFalse(calc.isOperadorValido('x'));
    }
    
    // ===== Testes para ehPositivo() =====
    
    @Test
    public void testEhPositivo() {
        assertTrue(calc.ehPositivo(5.0));
    }
    
    @Test
    public void testEhPositivoUm() {
        assertTrue(calc.ehPositivo(1.0));
    }
    
    @Test
    public void testEhPositivoFracao() {
        assertTrue(calc.ehPositivo(0.001));
    }
    
    @Test
    public void testNaoEhPositivoZero() {
        assertFalse(calc.ehPositivo(0.0));
    }
    
    @Test
    public void testNaoEhPositivoNegativo() {
        assertFalse(calc.ehPositivo(-5.0));
    }
    
    // ===== Testes para ehNegativo() =====
    
    @Test
    public void testEhNegativo() {
        assertTrue(calc.ehNegativo(-5.0));
    }
    
    @Test
    public void testEhNegativoMenosUm() {
        assertTrue(calc.ehNegativo(-1.0));
    }
    
    @Test
    public void testNaoEhNegativoZero() {
        assertFalse(calc.ehNegativo(0.0));
    }
    
    @Test
    public void testNaoEhNegativoPositivo() {
        assertFalse(calc.ehNegativo(5.0));
    }
    
    // ===== Testes para valorAbsoluto() =====
    
    @Test
    public void testValorAbsolutoPositivo() {
        double resultado = calc.valorAbsoluto(5.0);
        assertEquals(5.0, resultado, 0.01);
    }
    
    @Test
    public void testValorAbsolutoNegativo() {
        double resultado = calc.valorAbsoluto(-5.0);
        assertEquals(5.0, resultado, 0.01);
    }
    
    @Test
    public void testValorAbsolutoZero() {
        double resultado = calc.valorAbsoluto(0.0);
        assertEquals(0.0, resultado, 0.01);
    }
    
    @Test
    public void testValorAbsolutoFracao() {
        double resultado = calc.valorAbsoluto(-0.5);
        assertEquals(0.5, resultado, 0.01);
    }
}
