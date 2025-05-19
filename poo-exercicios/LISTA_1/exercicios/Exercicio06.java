package exercicios;

import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o valor de A: ");
        double a = scanner.nextDouble();
        while (a == 0) {
            System.out.println("O valor de A não pode ser 0.");
            System.out.print("Insira o valor de A: ");
            a = scanner.nextDouble();
        }

        System.out.print("Insira o valor de B: ");
        double b = scanner.nextDouble();

        System.out.print("Insira o valor de C: ");
        double c = scanner.nextDouble();

        double delta = (Math.pow(b, 2)) - (4 * a * c);
        if (delta < 0) {
            System.out.println("A equação não tem raízes reais.");
        } else {
            double x1 = ((-b) + Math.sqrt(delta)) / (2 * a);
            double x2 = ((-b) - Math.sqrt(delta)) / (2 * a);

            if (x1 == x2) {
                System.out.println("A equação tem apenas uma raíz: " + x1);
            } else {
                System.out.println("Raiz 1: " + x1);
                System.out.println("Raiz 2: " + x2);
            }
        }
    }
}
