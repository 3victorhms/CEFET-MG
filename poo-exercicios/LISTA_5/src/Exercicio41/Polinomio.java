package Exercicio41;

public class Polinomio {
    private Termo[] termos;
    private final int tamanho = 100;
    private int n;

    public Polinomio(Termo termo) {
        this.termos = new Termo[tamanho];
        this.termos[n] = new Termo(termo.getCoeficiente(), termo.getExpoente());
        this.n++;
    }

    public Polinomio() {
        this.termos = new Termo[this.tamanho];
    }

    public boolean insere(Termo t) {
        if (this.n < tamanho) {
            for (int i = 0; i < this.n; i++) {
                if (t.getExpoente() == this.termos[i].getExpoente()) {
                    this.termos[i].setCoeficiente(t.getCoeficiente() + this.termos[i].getCoeficiente());
                    return true;
                }
            }
            // se não encontrar o termo na lista, então ele será inserido na última posição
            this.termos[n] = new Termo(t.getCoeficiente(), t.getExpoente());
            n++;
            return true;
        } else {
            System.out.println("Não é possível inserir mais termos.");
        }
        return false;
    }

    public int calcula(int x) {
        int resultado = 0;
        for (int i = 0; i < n; i++) {
            resultado += this.termos[i].calcula(x);
        }
        return resultado;
    }

    public Polinomio fusao(Polinomio p) {
        Polinomio polinomio = new Polinomio();
        for (int i = 0; i < this.n; i++) {
            if (!polinomio.insere(this.termos[i])) {
                System.out.println("Capacidade do polinômio chegou ao máximo.");
                return null;
            }
        }

        for (int i = 0; i < p.n; i++) {
            if (!polinomio.insere(p.termos[i])) {
                System.out.println("Capacidade do polinômio chegou ao máximo.");
                return null;
            }
        }
        return polinomio;
    }
}
