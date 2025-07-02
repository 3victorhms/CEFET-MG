package Exercicio42;

public class Teste {
    public static void main(String[] args) {
        Protozoario p1 = Protozoario.getInstance();
        p1.exibirProtozoario();

        Protozoario p2 = Protozoario.getInstance();
        p2.exibirProtozoario();

        Protozoario p3 = p1.getClone();
        p3.exibirProtozoario();

        Protozoario p4 = p1.mate(p2);
        p4.exibirProtozoario();

        p1.mutate();
        p1.exibirProtozoario();
    }
}
