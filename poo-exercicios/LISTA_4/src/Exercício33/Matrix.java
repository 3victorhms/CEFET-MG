package Exercício33;

public class Matrix {
    int[][] matriz = new int[2][2];

    public static void main(String[] args) {
        Matrix m = new Matrix();
        m.adicionar(0, 0, 1);
        m.adicionar(0, 1, 2);
        m.adicionar(1, 0, 3);
        m.adicionar(1, 1, 4);
        m.print();

        System.out.println("Determinante da matriz: " + m.determinante());

        Matrix matrizInversa = m.inversa();
        matrizInversa.print();
    }

    void adicionar(int linha, int coluna, int valor) {
        this.matriz[linha][coluna] = valor;
    }

    Matrix inversa(){
        if (!isSingular()) {
            Matrix m = new Matrix();
            m.matriz[0][0] = this.matriz[1][1];
            m.matriz[0][1] = -this.matriz[0][1];
            m.matriz[1][0] = -this.matriz[1][0];
            m.matriz[1][1] = this.matriz[0][0];
            return m;
        }
        return null;
    }

    double determinante() {
        return (this.matriz[0][0] * this.matriz[1][1] - this.matriz[0][1] * this.matriz[1][0]);
    }

    boolean isSingular() {
        if (determinante() == 0) {
            return true;
        } else {
            return false;
        }
    }

    void print() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}
