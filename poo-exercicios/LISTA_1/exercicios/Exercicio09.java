package exercicios;

import java.util.Scanner;

public class Exercicio09 {

    static int CalcularFatorialImpar(int n) {
        int contador = 1;
        int fatorialAuxiliar = 1;
        while (contador < n) {
            if (contador % 2 == 1) {
                fatorialAuxiliar = fatorialAuxiliar * contador;
            }
            contador++;
        }
        return fatorialAuxiliar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira um número: ");
        int n = scanner.nextInt();
        while (n <= 1) {
            System.out.print("Tente novamente com um número maior que 1: ");
            n = scanner.nextInt();
        }

        int fatorial = CalcularFatorialImpar(n);
        System.out.println("O fatorial ímpar de " + n + " é " + fatorial);
    }
}
