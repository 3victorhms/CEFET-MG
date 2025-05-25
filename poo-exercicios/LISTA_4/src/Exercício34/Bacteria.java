package Exercício34;

public class Bacteria {
    int tempoDeVida = 25; // horas
    double lixoMetabolizado;
    double peso = 10; // picogramas

    public static void main(String[] args) {
        Colonia c = new Colonia();
        c.adicionarBacteria(new Bacteria());

        c.passarHoras(10);

        System.out.println("Lixo total: " + c.calcularLixo());
        System.out.println("Quantidade de bacterias vivas: " + c.calcularQuantidadeBacterias());

    }

    double calcularLixo() {
        if (this.estaViva())
            return this.lixoMetabolizado = (2 * peso) * (25 - tempoDeVida);

        return this.lixoMetabolizado = (2 * peso) * (25);
    }

    void passarHora(int hora) {
        if (!this.estaViva())
            return;

        this.tempoDeVida -= hora;
        this.calcularLixo();
    }

    int tempoRestante() {
        if (this.estaViva())
            return this.tempoDeVida;
        return 0;
    }

    void dividirBacteria(Colonia c) {
        if (temQueDividir()) {
            c.adicionarBacteria(new Bacteria());
        }
    }

    boolean temQueDividir() {
        int horasVividas = 25 - this.tempoDeVida;
        return horasVividas > 0 && horasVividas % 3 == 0;
    }

    boolean estaViva() {
        return this.tempoDeVida > 0;
    }
}

class Colonia {
    Bacteria[] colonia = new Bacteria[10];
    int indice = 0;


    void passarHoras(int horas) {
        for (int i = 0; i < horas; i++) {
            for (Bacteria bacteria : colonia) {
                if (bacteria != null && bacteria.estaViva())
                    bacteria.passarHora(1);
            }
            for (Bacteria bacteria : colonia) {
                if (bacteria != null && bacteria.estaViva())
                    bacteria.dividirBacteria(this);
            }
        }
    }

    int calcularQuantidadeBacterias() {
        int contador = 0;
        for (Bacteria b : colonia) {
            if (b != null) {
                if (b.estaViva())
                    contador++;
            }
        }
        return contador;
    }

    void adicionarBacteria(Bacteria b) {
        if (indice == colonia.length) {
            System.out.println("Colônia cheia.");
        } else {
            colonia[indice] = b;
            indice++;
        }
    }

    int calcularLixo() {
        int total = 0;
        for (Bacteria b : colonia) {
            if (b != null)
                total += (int) b.calcularLixo();
        }
        return total;
    }

}
