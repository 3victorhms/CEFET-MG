package Exercício25_27;

import java.util.Scanner;

public class Funcionario {
    String nome, departamento, rg, cpf;
    double salario;
    Data dtEntrada = new Data();


    void lerFuncionario () {
        Scanner scn = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário: ");
        this.nome = scn.nextLine();
        do {
            System.out.println("Insira um nome válido: ");
        } while (this.nome == null || this.nome.equals(""));

        System.out.println("Digite o departamento do funcionário: ");
        this.departamento = scn.nextLine();
        do {
            System.out.println("Insira um departamento válido: ");
        } while (this.departamento == null || this.departamento.equals(""));

        System.out.println("Digite o rg do funcionário: ");
        this.rg = scn.nextLine();
        do {
            System.out.println("Insira um rg válido: ");
        } while (this.rg == null || this.rg.equals(""));

        this.cpf = scn.nextLine();
        this.salario = Double.parseDouble(scn.nextLine());
        this.dtEntrada.dia = Integer.parseInt(scn.nextLine());
        this.dtEntrada.mes = Integer.parseInt(scn.nextLine());
        this.dtEntrada.ano = Integer.parseInt(scn.nextLine());

        scn.close();
    }

    boolean validarCPF () {
        int tamanhoCPF = this.cpf.length();
        if (tamanhoCPF == 11 || tamanhoCPF == 14) {
            for (int i = 0; i < tamanhoCPF; i++) {
                if (!Character.isDigit(this.cpf.charAt(i))) {
                    if (this.cpf.charAt(i) != '.' && this.cpf.charAt(i) != '-') {
                        return false;
                    }
                }
            }
        } else {
            // se for falso não vai estar em nenhum dos casos:
            // 1: 00011122233 (length == 11)
            // 2: 000.111.222-33 (length == 14)
            System.out.println("CPF inválido");
            return false;
        }

        // se chegar aqui o formato do cpf é válido, agora vai verificar o dígito verificador

        // primeiro copia todos os números para um vetor, considerando as duas situações (length == 11 ou length == 14)
        int[] numerosCPF = new int[11];
        if (tamanhoCPF == 14) {
            // se for 14 o código tem que pegar somente os numeros
            int indice = 0;
            for (int i = 0; i < 11; i++) {
                if (Character.isDigit(this.cpf.charAt(i))) {
                    numerosCPF[indice] = this.cpf.charAt(i);
                    indice++;
                }
            }
        } else {
            // então o tamanho é 11 e o usuário escreveu no formato de somente números
            for (int i = 0; i < 11; i++) {
                numerosCPF[i] = this.cpf.charAt(i);
            }
        }

        // calculando o primeiro DV
        int dv1;
        // primeiro separa os 9 dígitos e multiplica cada número por um número decrescente começando em 10 e terminando em 2
        int numeroMultiplicador = 9;
        int[] numerosVerificacao = new int[9];
        for (int i = 0; i < 9; i++) {
            numerosVerificacao[i] = numerosCPF[i] * numeroMultiplicador;
            numeroMultiplicador--;
        }
        // agora soma os valores e divide por 11
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+= numerosVerificacao[i];
        }

        if (soma % 11 < 2) {
            dv1 = 0;
        } else {
            dv1 = 11 - (soma % 11);
        }

        if (dv1 != numerosCPF[10]) {
            // já verifica direto se o primeiro dígito verificador está correto
            // se não tiver já retorna falso, se estiver continua a função
            return false;
        } else {
            // se chegar aqui o primeiro dígito verificador está correto
            // agora vai verificar o segundo dígito verificador

        }

        return false;
    }

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
