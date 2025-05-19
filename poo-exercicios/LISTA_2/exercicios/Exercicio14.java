
package exercicios;

import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) { // função principal
        int[] vetor = entradaDoVetor();
        vetor = inverterVetor(vetor);
        imprimirVetor(vetor);
    }

    static int[] entradaDoVetor(){ // função que le o vetor
        try (Scanner scanner = new Scanner(System.in)) {
            int[] v = new int[10];
            for (int i = 0; i < 10; i++) {
                System.out.print("Insira o " + (i+1) + "° elemento do vetor: ");
                v[i] = scanner.nextInt();
            }
            return v;
        }
    }

    static int[] inverterVetor(int[] vetor){
        int poloMaior = 9;
        int poloMenor = 0;
        int temp;
        while (poloMaior > poloMenor) {
            temp = vetor[poloMaior];
            vetor[poloMaior] = vetor[poloMenor];
            vetor[poloMenor] = temp;

            poloMenor++;
            poloMaior--;

        }
        return vetor;
    }

    static void imprimirVetor(int[] vetor){
        for (int i = 0; i < 10; i++) {
            System.out.println(vetor[i]);
        }
    }
}