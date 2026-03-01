package br.com.exemplo;
import java.util.Scanner;

public class Calculadora {
    
    /**
     * Realiza operações aritméticas básicas.
     * @param num1 Primeiro número
     * @param operador Operador (+, -, *, /)
     * @param num2 Segundo número
     * @return Resultado da operação
     * @throws IllegalArgumentException se operador for inválido ou divisão por zero
     */
    public double calcular(double num1, char operador, double num2) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Erro: Divisão por zero!");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }
    
    /**
     * Verifica se o operador é válido.
     */
    public boolean isOperadorValido(char operador) {
        return operador == '+' || operador == '-' || operador == '*' || operador == '/';
    }
    
    /**
     * Verifica se um número é positivo.
     */
    public boolean ehPositivo(double numero) {
        return numero > 0;
    }
    
    /**
     * Verifica se um número é negativo.
     */
    public boolean ehNegativo(double numero) {
        return numero < 0;
    }
    
    /**
     * Calcula o valor absoluto.
     */
    public double valorAbsoluto(double numero) {
        return numero < 0 ? -numero : numero;
    }
    
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculadora Simples ===");
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o operador (+, -, *, /): ");
        char operador = scanner.next().charAt(0);

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        try {
            double resultado = calc.calcular(num1, operador, num2);
            System.out.printf("Resultado: %.2f %c %.2f = %.2f%n", num1, operador, num2, resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

