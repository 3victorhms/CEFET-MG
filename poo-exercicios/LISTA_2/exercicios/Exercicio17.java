package exercicios;

import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrizA = lerMatrizA(scanner);
        int[][] matrizC = gerarMatrizB(matrizA);
        immprimirMatrizC(matrizC);

    }

    static int[][] lerMatrizA(Scanner scanner) {

        // ler dimensões
        System.out.print("Insira a quantidade de linhas da matriz: ");
        int linhas = scanner.nextInt();
        while (linhas > 10) {
            System.out.print("A quantidade de linhas deve ser menor ou igual a 10: ");
            linhas = scanner.nextInt();
        }

        System.out.print("Insira a quantidade de colunas da matriz: ");
        int colunas = scanner.nextInt();
        while (colunas > 10) {
            System.out.print("A quantidade de colunas deve ser menor ou igual a 10: ");
            colunas = scanner.nextInt();
        }

        // preencher a matriz
        int[][] m = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Insira o valor da posição " + (i + 1) + "x" + (j + 1) + ": ");
                m[i][j] = scanner.nextInt();
            }
        }
        return m;
    }

    static int[][] gerarMatrizB(int[][] matrizA) {
        int linhas = matrizA.length;
        int colunas = matrizA[0].length;
        int[][] m = new int[linhas][colunas + 1];

        // passa a matrizA pro nova matriz
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                m[i][j] = matrizA[i][j];
            }
        }

        // define a ultima coluna como 1 so pra n multiplicar por 0
        for (int i = 0; i < linhas; i++) {
            m[i][colunas] = 1;
        }

        // calcula a nova coluna da matriz
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                m[i][colunas] = m[i][j] * m[i][colunas];
            }
        }
        return m;
    }

    static void immprimirMatrizC(int[][] matrizC) {
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[0].length; j++) {
                System.out.print(matrizC[i][j] + " ");
            }
            System.out.println();
        }
    }

}