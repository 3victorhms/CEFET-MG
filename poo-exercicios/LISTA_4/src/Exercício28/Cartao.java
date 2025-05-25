package Exercício28;

public class Cartao {
    Conta conta;
    int senha;
    compraDebito[] relacaoDeDebitos = new compraDebito[100];
    int indiceDebitos = 0;

    public static void main(String[] args) {
        Cartao c1 = new Cartao();
        c1.conta = new Conta();
        c1.conta.saldo = 1000;
        c1.senha = 1234;

        c1.debitar(100, "Estabelecimento 1", 1234);
        c1.debitar(200, "Estabelecimento 2", 1234);
        c1.debitar(300, "Estabelecimento 3", 1234);
        c1.gerarFatura(1234);
    }

    boolean debitar(double valor, String estabelecimento, int senha) {
        if (senha == this.senha) {
            if (valor <= conta.saldo) {
                conta.saldo -= valor;
                relacaoDeDebitos[indiceDebitos] = new compraDebito();
                relacaoDeDebitos[indiceDebitos].estabelecimento = estabelecimento;
                relacaoDeDebitos[indiceDebitos].valor = valor;
                indiceDebitos++;
                return true;
            }
        }
        return false;
    }

    void gerarFatura(int senha) {
        if (senha == this.senha) {
            for (int i = 0; i < indiceDebitos; i++) {
                System.out.println("Valor da compra: " + relacaoDeDebitos[i].valor + " no estabelecimento: " + relacaoDeDebitos[i].estabelecimento);
            }
        }
    }
}

class Conta {
    double saldo;
}

class compraDebito {
    String estabelecimento;
    double valor;
}