package exercicios;

import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetorA = entradaVetorA(scanner);
        int[] vetorB = entradaVetorB(scanner);
        int[] vetorC = criarVetorC(vetorA, vetorB);
        if (vetorC != null) {
            vetorC = ordenarVetorC(vetorC);
            imprimirVetorOrdenado(vetorC);
        } else {
            System.out.println("O vetor A ou o vetor B não estava ordenado.");
        }

    }
    static int[] entradaVetorA(Scanner scanner){
        
        System.out.print("Insira o tamanho do vetor A: ");
        int n = scanner.nextInt();
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Insira o" + (i+1) + "° elemento do vetor A: ");
            vetor[i] = scanner.nextInt();
        }
        return vetor;
    }
    static int[] entradaVetorB(Scanner scanner){
        
        System.out.print("Insira o tamanho do vetor B: ");
        int n = scanner.nextInt();
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Insira o" + (i+1) + "° elemento do vetor B: ");
            vetor[i] = scanner.nextInt();
        }
        return vetor;
    }

    static int[] criarVetorC(int[] vetorA, int[] vetorB){

        for (int i = 0; i < vetorA.length; i++) { // verificar se o vetor A já está ordenado
            for (int j = (i+1); j < vetorA.length; j++){
                if (vetorA[i] > vetorA[j]) {
                    return null;
                }
            }
        }

        for (int i = 0; i < vetorB.length; i++) { // verificar se o vetor B já está ordenado;
            for (int j = (i+1); j < vetorB.length; j++){
                if (vetorB[i] > vetorB[j]) {
                    return null;
                }
            }
        }



        int tamanho = vetorA.length + vetorB.length;
        int[] c = new int[tamanho];

        for (int i = 0; i < vetorA.length; i++) { // inserir todo o vetor A
            c[i] = vetorA[i];
        }

        int iB = 0; // indice do vetor b
        for (int j = vetorA.length; j < tamanho; j++) { // inserir todo o vetor b
            c[j] = vetorB[iB];
            iB++;
        }

        return c;
    }

    static int[] ordenarVetorC(int[] vetorC){
        int[] c = new int[vetorC.length];

        for (int i = 0; i < c.length; i++) {
            c[i] = vetorC[i];
        }

        for (int i = 0; i < (c.length-1); i++) {
            for (int j = i+1; j < c.length; j++) {
                if (c[i] > c[j]) {
                    int temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }
            }
        }
        return c;
    }

    static void imprimirVetorOrdenado(int[] vetorC){
        for (int i = 0; i < vetorC.length; i++) {
            System.out.println(vetorC[i]);
        }
    }
}
