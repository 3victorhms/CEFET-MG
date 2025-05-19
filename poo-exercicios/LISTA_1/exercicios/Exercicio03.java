package exercicios;

import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double maior = 0;
        double segundoMaior = 0;
        double menor = 0;
        double segundoMenor = 100;
        double altura;
        boolean controle = false;
        boolean primeiroValor = true;

        while (controle == false) {
            System.out.print("Insira a altura (em m): ");
            altura = scanner.nextDouble();

            if (altura <= 0) {
                controle = true;
            } else {
                if (primeiroValor == true) {
                    maior = altura;
                    menor = altura;
                    primeiroValor = false;
                } else {
                    if (altura > maior) {
                        segundoMaior = maior;
                        maior = altura;
                    } else {
                        if (altura > segundoMaior && altura < maior) {
                            segundoMaior = altura;
                        }
                    }

                        if (altura < menor) {
                            segundoMenor = menor;
                            menor = altura;
                        } else {
                            if (altura > menor && altura < segundoMenor) {
                                segundoMenor = altura;
                            }
                        }
                }
            }
        }

        System.out.println("----------------------------");
        System.out.println("Fim do programa!");
        System.out.println("Maior altura: " + maior);
        System.out.println("Segunda maior altura: " + segundoMaior);
        System.out.println("Segunda menor altura: " + segundoMenor);
        System.out.println("Menor altura: " + menor);
        System.out.println("----------------------------");

    }
}