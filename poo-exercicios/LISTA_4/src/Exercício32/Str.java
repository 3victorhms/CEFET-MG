package Exercício32;

public class Str {
    int comprimento;
    char[] caracteres;

    public static void main(String[] args) {

        Str s = new Str();

        s.definirString("Olá");
        s.print();
        System.out.println();

        s = s.acrescente(" mundo!");
        s.print();
        System.out.println();

        
    }

    void definirString (String s1) {
        this.comprimento = s1.length();
        this.caracteres = new char[this.comprimento];

        for (int i = 0; i < this.caracteres.length; i++) {
            this.caracteres[i] = s1.charAt(i);
        }
    }

    void print() {
        for (int i = 0; i < this.comprimento; i++) {
            System.out.print(this.caracteres[i]);
        }
    }

    Str substring(int inicio, int fim) {
        if (inicio < 0 || fim > this.comprimento) {
            System.out.println("Início ou fim inválido.");
            return null;
        }
        Str novaStr = new Str();
        novaStr.comprimento = fim - inicio;
        novaStr.caracteres = new char[novaStr.comprimento];
        for (int i = 0; i < novaStr.comprimento; i++) {
            novaStr.caracteres[i] = this.caracteres[i + inicio];
        }
        return novaStr;
    }

    Str acrescente (String string) {

        Str novaStr = new Str();

        Str aux = new Str();
        aux.definirString(string);

        novaStr.comprimento = this.comprimento + aux.comprimento; // 3 + 5 = 8
        novaStr.caracteres = new char[novaStr.comprimento];

        for (int i = 0; i < this.comprimento; i++) {
            novaStr.caracteres[i] = this.caracteres[i];
        }

        for (int i = 0; i < aux.comprimento; i++) {
            novaStr.caracteres[i + this.comprimento] = aux.caracteres[i];
        }

        return novaStr;
    }
}
