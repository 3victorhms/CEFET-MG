package Exercício29_30;

public class Ponto {
    int x;
    int y;

    public static void main(String[] args) {
        Ponto p1 = new Ponto();
        p1.x = 10;
        p1.y = 20;

        p1.print();
    }

    Ponto negativo () {
        Ponto p = new Ponto();
        p.x = -x;
        p.y = -y;
        return p;
    }

    double distancia() {
        return Math.sqrt(x * x + y * y);
    }

    void print(){
        System.out.println( "X: " + x + " Y: " + y);
        System.out.printf("Distância até a origem: %.1f\n", distancia());
        System.out.println( "Ponto negativo: " + negativo().x + " " + negativo().y);
    }
}
