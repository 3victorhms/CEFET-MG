package Exercício29_30;

public class Circulo {
    double raio;
    Ponto centro;

    public static void main(String[] args) {
        Circulo c1 = new Circulo();
        c1.raio = 10;;
        c1.centro = new Ponto();
        c1.centro.x = 10;
        c1.centro.y = 20;

        System.out.println( "Raio: " + c1.raio );
        System.out.println( "Área: " + c1.area() );
        System.out.println( "Perímetro: " + c1.perimetro() );
    }

    double area() {
        return  3.14 * raio * raio;
    }
    double perimetro() {
        return 2 * 3.14 * raio;
    }
}
