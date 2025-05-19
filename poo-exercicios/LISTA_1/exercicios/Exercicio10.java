package exercicios;

import java.util.Scanner;

public class Exercicio10 {
    static int CalcularNEsimoPrimo(int n) {
        int contador = 2;
        int contadorPrimos = 0;
        boolean encontrado = false;
        while (encontrado == false) {
            if (contadorPrimos == n) {
                encontrado = true;
            } else {
                if (VerificarPrimo(contador)) {
                    contadorPrimos++;
                }
                contador++;
            }
        }

        return contador-1;

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
        int nEsimo = CalcularNEsimoPrimo(n);
        System.out.println("O n-ésimo número primo é: " + nEsimo);
    }
}
