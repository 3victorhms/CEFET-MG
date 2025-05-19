package exercicios;

import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        System.out.print("Insira o número: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int limite = num;
        int contador = 1;
        int fatorial = 1;

        while (contador <= limite) {
            fatorial = fatorial * contador;
            contador = contador + 1;
        }

        System.out.println("O fatorial de " + num + " é " + fatorial);

    }
}
