package exercicios;

import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrizA = entradaMatrizA(scanner);
        System.out.println("Matriz A preenchida com sucesso!");

        int[][] matrizB = entradaMatrizB(scanner, matrizA);
        System.out.println("Matriz B preenchida com sucesso!");

        int[][] matrizR = multiplicarMatrizes(matrizA, matrizB);
        System.out.println("Multiplicação das matrizes completa, aqui está a matriz resultante: ");

        imprimirMatrizResultante(matrizR);

    }

    static int[][] entradaMatrizA(Scanner scanner) {
        System.out.println("Vamos preencher a matriz A!");

        System.out.print("Insira quantidade de linhas: ");
        int linhas = scanner.nextInt();

        System.out.print("Insira quantidade de colunas: ");
        int colunas = scanner.nextInt();

        int[][] m = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Insira o valor da posição " + (i + 1) + "x" + (j + 1) + ": ");
                m[i][j] = scanner.nextInt();
            }
        }
        return m;
    }

    static int[][] entradaMatrizB(Scanner scanner, int[][] matrizA) {
        System.out.println("");
        System.out.println("Vamos preencher a matriz B!");
        System.out.print("Insira quantidade de linhas: ");
        int linhas = scanner.nextInt();
        while (linhas != matrizA[0].length) {
            System.out.print("A quantidade de linhas da matriz B deve ser igual a quantidade de colunas da matriz A: ");
            linhas = scanner.nextInt();
        }

        System.out.print("Insira quantidade de colunas: ");
        int colunas = scanner.nextInt();

        int[][] m = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Insira o valor da posição " + (i + 1) + "x" + (j + 1) + ": ");
                m[i][j] = scanner.nextInt();
            }
        }
        return m;
    }

    // todos elementos de uma linha da matriz A multiplicam pelos elementos de uma coluna da matriz B e seus produtos são somados.
    // ex: A = {1,2, e B = {5,6 =    (1*5) + (2*7) = i,j e (1*6) + (2*8) = i,j+1. E assim por diante.
    //          3,4}        7,8} = 

    static int[][] multiplicarMatrizes(int[][] matrizA, int[][] matrizB) {
        int linha = matrizA.length;
        int coluna = matrizB[0].length;
        int[][] m = new int[linha][coluna];
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                for (int k = 0; k < matrizA[0].length; k++) {
                    m[i][j] = m[i][j] + (matrizA[i][k] * matrizB[k][j]);
                }
            }
        }

        return m;
    }

    static void imprimirMatrizResultante(int[][] matrizR) {
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[0].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println();
        }
    }

}