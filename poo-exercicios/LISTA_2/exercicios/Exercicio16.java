package exercicios;

import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrizA = entradaMatrizA(scanner);
        System.out.println("Matriz A preenchida com sucesso!");

        int[][] matrizB = entradaMatrizB(scanner);
        System.out.println("Matriz B preenchida com sucesso!");

        int[][] matrizR = somarMatrizes(matrizA, matrizB);
        System.out.println("Soma das matrizes completa, aqui está a matriz resultante: ");

        imprimirMatrizResultante(matrizR);

    }

    static int[][] entradaMatrizA(Scanner scanner) {
        System.out.println("Vamos preencher a matriz A!");
        int[][] m = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Insira o valor da posição " + (i + 1) + "x" + (j + 1) + ": ");
                m[i][j] = scanner.nextInt();
            }
        }
        return m;
    }

    static int[][] entradaMatrizB(Scanner scanner) {
        System.out.println("");
        System.out.println("Vamos preencher a matriz B!");
        int[][] m = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Insira o valor da posição " + (i + 1) + "x" + (j + 1) + ": ");
                m[i][j] = scanner.nextInt();
            }
        }
        return m;
    }

    static int[][] somarMatrizes(int[][] matrizA, int[][] matrizB) {
        int[][] m = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return m;
    }

    static void imprimirMatrizResultante(int[][] matrizR) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println();
        }
    }

}