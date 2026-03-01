package br.com.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraLLMTest {

    private final Calculadora calc = new Calculadora();

    @Test
    public void somaSimples() {
        assertEquals(7.0, calc.calcular(3.0, '+', 4.0), 1e-9);
    }

    @Test
    public void subtracaoSimples() {
        assertEquals(1.0, calc.calcular(5.0, '-', 4.0), 1e-9);
    }

    @Test
    public void multiplicacaoSimples() {
        assertEquals(12.0, calc.calcular(3.0, '*', 4.0), 1e-9);
    }

    @Test
    public void divisaoSimples() {
        assertEquals(2.5, calc.calcular(5.0, '/', 2.0), 1e-9);
    }

    @Test
    public void divisaoPorZeroLancandoExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcular(1.0, '/', 0.0));
    }

    @Test
    public void operadorInvalidoLancandoExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcular(1.0, 'x', 2.0));
    }

    @Test
    public void somaComNegativos() {
        assertEquals(-1.0, calc.calcular(-3.0, '+', 2.0), 1e-9);
    }

    @Test
    public void subtracaoComNegativos() {
        assertEquals(-5.0, calc.calcular(-3.0, '-', 2.0), 1e-9);
    }

    @Test
    public void multiplicacaoPorZero() {
        assertEquals(0.0, calc.calcular(123.0, '*', 0.0), 1e-9);
    }

    @Test
    public void valorAbsolutoEPositividade() {
        assertEquals(5.0, calc.valorAbsoluto(-5.0), 1e-9);
        assertTrue(calc.ehPositivo(5.0));
        assertFalse(calc.ehNegativo(5.0));
    }

    @Test
    public void casosFracionarios() {
        assertEquals(0.3333333333, calc.calcular(1.0, '/', 3.0), 1e-9);
    }

    @Test
    public void zeroComoOperando() {
        assertEquals(0.0, calc.calcular(0.0, '+', 0.0), 1e-9);
    }
}
