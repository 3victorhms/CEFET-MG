package Exercício25_27;

public class Exercicio25 {
    public static void main(String[] args) {

        Funcionario f1 = new Funcionario();
        f1.nome = "João";
        f1.departamento = "Financeiro";
        f1.rg = "123456789";
        f1.dtEntrada.dia = 10;
        f1.dtEntrada.mes = 12;
        f1.dtEntrada.ano = 2020;
        f1.salario = 1000;
        f1.recebeAumento(100);

        Funcionario f2 = new Funcionario();
        f2.nome = "Victor";
        f2.departamento = "TI";
        f2.rg = "987654321";
        f2.dtEntrada.dia = 11;
        f2.dtEntrada.mes = 12;
        f2.dtEntrada.ano = 2010;
        f2.salario = 10000;
        f2.recebeAumento(1710);

        if (f1 == f2) {
            System.out.println("Os funcionários são iguais.");
        } else {
            System.out.println("Os funcionários são diferentes.");
        }
    }
}
