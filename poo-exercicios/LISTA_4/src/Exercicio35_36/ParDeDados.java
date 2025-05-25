package Exercicio35_36;

import java.util.Random;

public class ParDeDados {
    Dado dado1 = new Dado();
    Dado dado2 = new Dado();

    int[] rolar () {
        Random r = new Random();
        dado1.valor = r.nextInt(6) + 1;
        dado2.valor = r.nextInt(6) + 1;
        int[] valores = {dado1.valor, dado2.valor};
        return valores;
    }

    int contarDuplo6 () {
        int contador = 0;
        for (int i = 0; i < 100; i++) {
            if (rolar()[0] == 6 && rolar()[1] == 6) {
                contador++;
            }
        }
        return contador;
    }

    void testar () {
        System.out.println("Quantidade de pares de 6: " + contarDuplo6());
    }
}

class Dado {
    int valor;
}
