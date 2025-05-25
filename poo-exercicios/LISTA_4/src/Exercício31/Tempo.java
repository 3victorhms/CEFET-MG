package Exercício31;

public class Tempo {
    int hora;
    int minuto;
    int segundo;

    public static void main(String[] args) {

        Tempo t1 = new Tempo();
        t1.print();

        t1.avance(1, 60, 120);
        t1.print();

        t1.reset(10, 20, 30);
        t1.print();
    }

    void avance(int h, int m, int s){
        this.hora += h;
        this.minuto += m;
        this.segundo += s;

        ajustarTempo();
    }

    void ajustarTempo () {
        while (this.segundo >= 60) {
            this.segundo -= 60;
            this.minuto += 1;
        }
        while (this.minuto >= 60) {
            this.minuto -= 60;
            this.hora += 1;
        }

        while (this.hora >= 24) {
            this.hora -= 24;
        }
    }

    void reset(int h, int m, int s){
        this.hora = h;
        this.minuto = m;
        this.segundo = s;
    }

    void print(){
        System.out.println(this.hora + "h" + this.minuto + "min" + this.segundo + "s");
    }
}
