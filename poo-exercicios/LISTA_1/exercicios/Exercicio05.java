 package exercicios;
import java.util.Scanner;

public class Exercicio05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        double soma = 0;
        double media;
        int contador = 0;
        boolean controle = false;

        while (controle == false) {

            System.out.print("Insira um número: ");
            numero = scanner.nextInt();

            if (numero == -1) {
                controle = true;
            } else {

                if (numero > 0) {
                    if (numero % 2 == 0) {
                        soma = soma + numero;
                        contador++;
                    }
                }
            }

        }

        media = soma / contador;

        System.out.println("Fim do programa!");
        System.out.println("A média foi: " + media);
    }
}
