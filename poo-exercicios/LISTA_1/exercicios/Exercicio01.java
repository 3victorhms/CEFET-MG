package exercicios;
import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double maior;
        double menor;
        double altura;
        boolean controle = false;

        System.out.print("Insira a altura (em m): ");
        altura = scanner.nextDouble();

        maior = altura;
        menor = altura;

        while (controle == false) {

            if (altura <= 0) {
                controle = true;
            } else {

                if (altura > maior) {
                    maior = altura;
                }

                if (altura < menor) {
                    menor = altura;
                }

                System.out.println("Maior altura atual: " + maior);
                System.out.println("Menor altura atual: " + menor);

                System.out.print("Insira a altura (em m): ");
                altura = scanner.nextDouble();

            }

        }

        System.out.println("Fim do programa!");
        System.out.println("A maior altura foi: " + maior);
        System.out.println("A menor altura foi: " + menor);

    }
}
