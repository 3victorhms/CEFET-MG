package exercicios;

import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = entradaDaMatriz(scanner);
        boolean éPermutacao = verificarPermutacao(matriz);
        if (éPermutacao == true) {
            System.out.print("A matriz é de permutação.");
        } else {
            System.out.print("A matriz não é de permutação.");
        }

    }

    static int[][] entradaDaMatriz(Scanner scanner) {
        System.out.print("Insira a dimensão da matriz (será quadrada, ou seja, linhas = colunas): ");
        int dimensoes = scanner.nextInt();

        int[][] m = new int[dimensoes][dimensoes];

        for (int i = 0; i < dimensoes; i++) {
            for (int j = 0; j < dimensoes; j++) {
                System.out.print("Insira o valor da posição " + (i + 1) + "x" + (j + 1) + ": ");
                m[i][j] = scanner.nextInt();
            }
        }
        return m;
    }

    static boolean verificarPermutacao(int[][] matriz) {
        int dimensoes = matriz.length;
        int[] contadorUmLinha = new int[dimensoes];
        int[] contadorUmColuna = new int[dimensoes];

        for (int i = 0; i < dimensoes; i++) {
            for (int j = 0; j < dimensoes; j++) {

                if (matriz[i][j] != 0 && matriz[i][j] != 1) {
                    return false;
                } else {
                    if (matriz[i][j] == 1) {
                        contadorUmLinha[i]++;
                        contadorUmColuna[j]++;
                    }
                }

            }
        }
        for (int k = 0; k < dimensoes; k++) {
            if (contadorUmLinha[k] != 1 || contadorUmColuna[k] != 1) {
                return false;
            }
        }

        return true;
    }
}
