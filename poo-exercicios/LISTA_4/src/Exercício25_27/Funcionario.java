package Exercício25_27;

public class Funcionario {
    String nome, departamento, rg, cpf;
    double salario;
    Data dtEntrada = new Data();

    void recebeAumento(double aumento) {
        this.salario += aumento;
    }

    double calculaGanhoAnual() {
        return this.salario * 12;
    }

}

class Empresa {
    String nome;
    Funcionario[] empregados = new Funcionario[0];
    String cnpj;

    void adiciona(Funcionario f) {
        this.empregados = aumentarEmpregados(this.empregados);
        this.empregados[empregados.length-1] = f;
    }

    Funcionario[] aumentarEmpregados(Funcionario[] empregados) {
        Funcionario[] empregadosNovos = new Funcionario[empregados.length + 1];
        for (int i = 0; i < empregados.length; i++) {
            empregadosNovos[i] = empregados[i];
        }
        empregadosNovos[empregados.length] = new Funcionario();
        return empregadosNovos;
    }

    void mostra() {
        if (empregados != null) {
            for (int i = 0; i < empregados.length; i++) {
                if (empregados[i] != null) {
                    System.out.println("Nome: " + empregados[i].nome);
                    System.out.println("Departamento: " + empregados[i].departamento);
                    System.out.println("RG: " + empregados[i].rg);
                    System.out.println("Data de entrada: " + empregados[i].dtEntrada.dia + "/" + empregados[i].dtEntrada.mes + "/" + empregados[i].dtEntrada.ano);
                    System.out.println("Salário: " + empregados[i].salario);
                    System.out.println("Ganho anual: " + empregados[i].calculaGanhoAnual());
                }
            }
        }
    }
}
