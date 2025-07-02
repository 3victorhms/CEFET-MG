package Exercicio41;

public class Termo {
    private int coeficiente;
    private int expoente;

    public int getCoeficiente() {
        return coeficiente;
    }

    public int getExpoente() {
        return expoente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public Termo(int ai, int i) {
        this.coeficiente = ai;
        this.expoente = i;
    }

    public void insere (Termo t) {
        this.coeficiente = t.coeficiente;
        this.expoente = t.expoente;
    }

    public int calcula (int x) {
        return this.coeficiente * (this.expoente^x);
    }

}
