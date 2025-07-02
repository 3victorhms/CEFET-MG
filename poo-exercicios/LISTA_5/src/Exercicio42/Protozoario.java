package Exercicio42;

import java.util.Random;

public class Protozoario {
    Random aleatorio = new Random();
    private int individualidade;
    private int[] genotipo = new int[10];

    static private int proximaId = 1;

    private Protozoario() {
        this.individualidade = gerarProximaId();
        for (int i = 0; i < 10; i++) {
            this.genotipo[i] = aleatorio.nextInt(4);
        }
    }

    private Protozoario(int[] genotipo) {
        this.individualidade = gerarProximaId();
        for (int i = 0; i < genotipo.length; i++) {
            this.genotipo[i] = genotipo[i];
        }
    }

    private Protozoario(Protozoario outro) {
        this.individualidade = gerarProximaId();
        for (int i = 0; i < outro.genotipo.length; i++) {
            this.genotipo[i] = outro.genotipo[i];
        }
    }

    public int gerarProximaId() {
        return proximaId++;
    }

    public static Protozoario getInstance() {
        return new Protozoario();
    }

    public static Protozoario getInstance(int[] genotipo) {
        if (genotipo != null)
            return new Protozoario(genotipo);
        else
            return null;
    }

    public void mutate() {
        int gene = aleatorio.nextInt(10);
        int mutacao = aleatorio.nextInt(4);
        while (mutacao == this.genotipo[gene])
            mutacao = aleatorio.nextInt(4);

        this.genotipo[gene] = mutacao;
    }

    public Protozoario getClone() {
        return new Protozoario(this);
    }

    public Protozoario mate(Protozoario mae) {
        int[] genotipoFilho = new int[10];
        for (int i = 0; i < 10; i++) {
            if (aleatorio.nextInt(2) == 0)
                genotipoFilho[i] = this.genotipo[i];
            else
                genotipoFilho[i] = mae.genotipo[i];
        }

        Protozoario p1 = Protozoario.getInstance(genotipoFilho);
        if (aleatorio.nextInt(100) < 7)
            p1.mutate();

        return p1;
    }

    public void exibirProtozoario() {
        System.out.println(this.toString());
    }

    public String toString() {
        String genotipo = "";
        for (int i = 0; i < 10; i++) {
            genotipo += this.genotipo[i];
            if (i < 9)
                genotipo += ", ";
        }
        return "Protozoário: " + this.individualidade + " {" + genotipo + "}";
    }


}
