package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // gerar matriz
        int[][] distanciaCidades = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || j == 0) {
                    distanciaCidades[i][j] = -1;
                } else {
                    if (i == j) {
                        distanciaCidades[i][j] = 0;
                    } else {
                        distanciaCidades[i][j] = random.nextInt(100);
                        distanciaCidades[j][i] = distanciaCidades[i][j];
                    }
                }
            }
        }

        imprimirMatriz(distanciaCidades);
        System.out.println(); // so pra dar um espaço
        System.out.println();
        System.out.println();
        System.out.println();

        // aq le os caminhoes
        System.out.println("Insira a quantidade de caminhões: ");
        int quantidadeCaminhoes = scanner.nextInt();

        Caminhao[] caminhoes = new Caminhao[quantidadeCaminhoes];
        for (int c = 0; c < quantidadeCaminhoes; c++) {
            caminhoes[c] = new Caminhao();
        }

        for (int k = 0; k < quantidadeCaminhoes; k++) {
            caminhoes[k] = lerFicha(scanner, caminhoes);
        }

        System.out.println("Insira um código de caminhão para você ver sua distância percorrida: ");
        int numCaminhao = scanner.nextInt();

        int indiceCaminhao = -1;

        for (int k = 0; k < quantidadeCaminhoes; k++) {
            if (caminhoes[k].numero == numCaminhao) {
                indiceCaminhao = k;
                for (int l = 0; l < (caminhoes[k].codigosCidades.length-1); l++) {
                    int cidadeAtual = caminhoes[k].codigosCidades[l];
                    int proximaCidade = caminhoes[k].codigosCidades[l+1];
                    caminhoes[k].distanciaPercorrida = caminhoes[k].distanciaPercorrida + distanciaCidades[cidadeAtual][proximaCidade];
                }
            }
        }
        if (indiceCaminhao == -1) {
            System.out.println("Caminhão não encontrado");
        } else {
            System.out.println("A distância percorrida pelo caminhão" + numCaminhao + " é: " + caminhoes[indiceCaminhao].distanciaPercorrida);
        }
    }

    static void imprimirMatriz(int[][] distanciaCidades) {

        System.out.print("    ");
        for (int i = 0; i < distanciaCidades.length; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();

        for (int i = 0; i < distanciaCidades.length; i++) {
            System.out.printf("%3d ", i);
            for (int j = 0; j < distanciaCidades.length; j++) {
                System.out.printf("%5d", distanciaCidades[i][j]);
            }
            System.out.println();
        }
    }

    static Caminhao lerFicha(Scanner scanner, Caminhao[] caminhoes) {
        Caminhao c = new Caminhao();

        System.out.print("Insira o número do caminhão: ");
        c.numero = scanner.nextInt();

        System.out.print("Insira a quantidade de cidades percorridas: ");
        c.cidadesPercorridas = scanner.nextInt();

        c.codigosCidades = new int[c.cidadesPercorridas];

        for (int i = 0; i < c.cidadesPercorridas; i++) {
            System.out.println("Insira o código da cidade " + (i + 1) + ": ");
            c.codigosCidades[i] = scanner.nextInt();
        }
        return c;
    }

    static class Caminhao {
        int numero;
        int cidadesPercorridas;
        int[] codigosCidades;
        int distanciaPercorrida;
    }
}
