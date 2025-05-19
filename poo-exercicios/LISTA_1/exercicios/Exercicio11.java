package exercicios;

import java.util.Scanner;

public class Exercicio11 {
    static int CalcularFatorialPrimo(int n) {

        int contador = 1;
        int fatorialAuxiliar = 1;
        while (contador <= n) {
            if (VerificarPrimo(contador)) {
                fatorialAuxiliar = fatorialAuxiliar * contador;
            }
            contador++;
        }

        return fatorialAuxiliar;

    }

    static boolean VerificarPrimo(int n) {
        int limite = n;
        int contador = 1;
        int divisores = 0;
        while (contador <= limite) {
            if (n % contador == 0) {
                divisores++;
            }
            contador++;
        }

        return divisores == 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o número: ");
        int n = scanner.nextInt();
        int fatorialPrimo = CalcularFatorialPrimo(n);
        System.out.println("O fatorial primo de " + n + " é: " + fatorialPrimo);
    }
}
