package Exercicio37;

public class TestaEmpresa {
    public static void main(String[] args) {
        Empresa e1 = new Empresa();
        e1.nome = "CEFET";
        e1.empregados = new Funcionario[10];
        e1.cnpj = "AB3";

        for (int i = 0; i < 5; i++) {
            Funcionario f = new Funcionario();
            f.setSalario(1000 + i * 100);
            System.out.println(f.getSalario());
            e1.adiciona(f);
        }

        e1.mostra();

    }
}
