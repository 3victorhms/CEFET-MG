package exercicios;

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira a massa do material em gramas: ");
        double massaInicial = scanner.nextDouble();
        double massaFinal = massaInicial;
        int tempo = 0;

        if (massaInicial <= 0.5) {
            System.out.println("O material já tem menos que 0,5 gramas.");
        } else {
            while (massaFinal > 0.5) {
                massaFinal = (massaFinal / 2);
                tempo = tempo + 50;
            }
            System.out.println("Massa inicial: " + massaInicial + " gramas.");
            System.out.println("Massa final: " + massaFinal + " gramas.");
            System.out.println("Tempo para chegar na massa final: " + tempo + " segundos");
        }
    }
}
