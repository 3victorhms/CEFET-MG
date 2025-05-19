package exercicios;

import java.util.Scanner;

public class Exercicio12 {
    static int InverterNumero(int num) {
        int numeroInvertido = 0;
        int backupNum = num;

        while (backupNum > 0) {
            numeroInvertido = numeroInvertido * 10;
            numeroInvertido = numeroInvertido + (backupNum % 10);
            backupNum = backupNum / 10;
        }
        return numeroInvertido;
    }

    static boolean éPalindromo(int num) {
        int numeroInvertido = InverterNumero(num);
        return numeroInvertido == num;
    }

    static void ImprimirPalindromos() {
        int contador = 1;
        while (contador < 1000) {
            if (éPalindromo(contador)) {
                System.out.println(contador);
            }
            contador++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Os palindromos entre 1 e 1000 são: ");
        ImprimirPalindromos();
    }
}
