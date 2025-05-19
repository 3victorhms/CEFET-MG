package exercicios;

import java.util.Scanner;

public class Exercicio08 {

    static int CalcularMDC(int x, int y) {
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else {
                int temp = x;
                x = y;
                y = temp;
            }
        }
        return x;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o primeiro número: ");
        int x = scanner.nextInt();
        System.out.print("Insira o segundo número: ");
        int y = scanner.nextInt();

        int mdc = CalcularMDC(x, y);

        System.out.println("O MDC entre " + x + " e " + y + " é " + mdc);

    }
}
