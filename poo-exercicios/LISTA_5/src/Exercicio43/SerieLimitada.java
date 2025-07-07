package Exercicio43;

import java.util.Random;

public class SerieLimitada {
    private static int maximoDeInstancias = 10;
    private static int quantidadeInstancias = 0;
    private static SerieLimitada[] instancias = new SerieLimitada[maximoDeInstancias];
    private String valor;

    public static void main(String[] args) {
        SerieLimitada s1 = new SerieLimitada();
        System.out.println(s1.getValor());

        SerieLimitada s2 = new SerieLimitada();
        System.out.println(s2.getValor());
    }

    public SerieLimitada() {
        if (quantidadeInstancias < maximoDeInstancias) {
            do {
                this.valor = gerarValor();
            } while (this.valor == null);
            instancias[quantidadeInstancias] = this;
            incrementarQuantidadeInstancias();
        }
    }

    public String gerarValor() {

        String[] numeros = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] letras = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        Random aleatorio = new Random();
        String[] aux = new String[10];
        int letraOuNumero;
        for (int i = 0; i < 10; i++) {
            letraOuNumero = aleatorio.nextInt(2);
            if (letraOuNumero == 0) {
                aux[i] = letras[aleatorio.nextInt(letras.length)];
            } else {
                aux[i] = numeros[aleatorio.nextInt(numeros.length)];
            }
        }
        String novoValor = "";
        for (String s : aux) {
            novoValor += s;
        }
        boolean resultado = validarValor(instancias, novoValor);
        if (!resultado) {
            return novoValor;
        } else {
            return null;
        }
    }

    public Boolean validarValor(SerieLimitada[] valores, String valor) {
        for (SerieLimitada valore : valores) {
            if (valore != null) {
                if (valore.getValor().equals(valor)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void incrementarQuantidadeInstancias() {
        quantidadeInstancias++;
    }

    public String getValor() {
        return this.valor;
    }
}
