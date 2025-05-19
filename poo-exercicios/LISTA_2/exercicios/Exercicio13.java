package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Insira o tamanho do vetor: ");
            int n = scanner.nextInt();

            int[] vetor = randomizarVetor(n);

            System.out.println("");
            System.out.println("Os valores do vetor são: ");
            imprimirVetor(vetor, n);

            System.out.print("Insira um número X para eu pesquisar no vetor: ");
            int x = scanner.nextInt();
            int posicao = pesquisarNoVetor(vetor, x);
            if (posicao == -1) {
                System.out.println("Número não presente no vetor.");
            } else {
                System.out.println("Número encontrado no vetor na posição " + posicao);
            }

        }
    }

    static int[] randomizarVetor(int n) {
        int[] v = new int[n];

        Random random = new Random();

        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(100);
        }

        return v;
    }

    static void imprimirVetor(int[] vetor, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(vetor[i]);
        }
    }

    static int pesquisarNoVetor(int[] vetor, int x) {
        int contador;
        for (contador = 0; contador < vetor.length; contador++) {
            if (vetor[contador] == x) {
                return contador;
            }
        }
        return -1;
    }
}