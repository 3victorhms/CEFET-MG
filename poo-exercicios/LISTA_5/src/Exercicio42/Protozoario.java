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
        this.genotipo = genotipo;
    }

    public int gerarProximaId() {
        return proximaId++;
    }

    public int[] getGenotipo() {
        return genotipo;
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
        return Protozoario.getInstance(this.getGenotipo());
    }

    public Protozoario mate( Protozoario mae) {
        int[] filho = new int[10];
        for (int i = 0; i < 10; i++) {
            if (aleatorio.nextInt(101) + 1 == 7)
                this.mutate();
            if (aleatorio.nextInt(2) == 0)
                filho[i] = this.genotipo[i];
            else
                filho[i] = mae.genotipo[i];
        }
        return Protozoario.getInstance(filho);
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
