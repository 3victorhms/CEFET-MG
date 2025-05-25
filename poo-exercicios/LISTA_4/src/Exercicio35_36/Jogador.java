package Exercicio35_36;

public class Jogador {
    int indice;
    int pontos = 0;
    boolean arriscando = false;

    boolean taArriscando() {
        return this.arriscando;
    }

    void adicionarPontos (int pontos) {
        this.pontos += pontos;
    }

    boolean ganhou() {
        return this.pontos >= 100;
    }

}
