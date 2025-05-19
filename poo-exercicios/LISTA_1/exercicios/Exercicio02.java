package exercicios;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        int tempF;
        double tempC;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a temperatura: ");
        tempF = scanner.nextInt();

        while (tempF > -460) {
            tempC = ((double) 5 / 9) * (tempF - 32);
            System.out.println("Temperatura em Celsius: " + tempC);

            if (tempC <= 20) {
                System.out.println("Está frio");
            } else {
                System.out.println("Está quente");
            }

            System.out.println("Insira a temperatura: ");
            tempF = scanner.nextInt();

            System.out.println("Fim do programa!");
        }
    }
}