package exercicios;

// import java.util.Random;
import java.util.Scanner;

public class Exercicio21 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Random random = new Random();

        Funcionario[] funcionarios = new Funcionario[250];
        for (int i = 0; i < funcionarios.length; i++) {
            funcionarios[i] = new Funcionario();
            funcionarios[i].nascimento = new Data();
            funcionarios[i].entradaNaEmpresa = new Data();
        }

        int indiceFuncionarios = 0;

        Empresa[] empresas = new Empresa[10];
        for (int i = 0; i < empresas.length; i++) {
            empresas[i] = new Empresa();
        }

        int indiceEmpresas = 0;

        int escolha = menu(scanner);
        while (escolha != 0) {
            switch (escolha) {
                case 1:
                    funcionarios[indiceFuncionarios] = cadastrarFuncionario(scanner);
                    indiceFuncionarios++;
                    break;
                case 2:
                    empresas[indiceEmpresas] = cadastrarEmpresa(scanner);
                    indiceEmpresas++;
                    break;
                case 3:
                    funcionarios = aumentarFuncionarios(funcionarios);
                    break;
                case 4:
                    empresas = aumentarEmpresas(empresas);
                    break;
                case 5:
                    pesquisarFuncionario(funcionarios);
                    break;
                case 6:
                    menu(scanner);
                    break;
            }
            escolha = menu(scanner);
        }
    }

    static int menu(Scanner scanner) {
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Cadastrar Empresa");
        System.out.println("3 - Aumentar quantidade de funcionários");
        System.out.println("4 - Aumentar quantidade de empresas");
        System.out.println("5 - Funcionários com mais de 5 dependentes");
        System.out.println("6 - Voltar");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.println("-----------------------------");

        int opc = scanner.nextInt();
        while (opc > 6 || opc < 0) {
            System.out.print("Insira uma opção: ");
            opc = scanner.nextInt();
        }
        return opc;
    }

    static Funcionario cadastrarFuncionario(Scanner scanner) {
        Funcionario f = new Funcionario();
        f.nascimento = new Data();
        f.entradaNaEmpresa = new Data();
        System.out.println("Digite o nome do Funcionario: ");
        f.nome = scanner.next();

        System.out.println("Digite a idade do Funcionario: ");
        f.idade = scanner.nextInt();

        System.out.println("Digite o CPF do Funcionario: ");
        f.cpf = scanner.next();

        System.out.println("Digite o nome da empresa que ele trabalha: ");
        f.empresa = scanner.next();

        System.out.println("Quantos dependentes o funcionário tem? ");
        f.dependentes = scanner.nextInt();
        while (f.dependentes < 0) {
            System.out.print("Insira um número maior ou igual a 0: ");
            f.dependentes = scanner.nextInt();
        }

        System.out.println("Digite o salário do funcionário: ");
        f.salario = scanner.nextDouble();
        while (f.salario < 0) {
            System.out.println("Insira um salário maior que zero: ");
            f.salario = scanner.nextDouble();
        }

        System.out.println("Digite o email do funcionário: ");
        f.email = scanner.next();

        System.out.println("Qual o cargo do funcionário? ");
        f.cargo = scanner.next();

        System.out.println("Insira a data de nascimento do funcionário: ");
        System.out.println("Dia: ");
        f.nascimento.dia = scanner.nextInt();
        System.out.println("Mês: ");
        f.nascimento.mes = scanner.nextInt();
        System.out.println("Ano: ");
        f.nascimento.ano = scanner.nextInt();

        System.out.println("Insira a data de entrada do funcionário na empresa: ");
        System.out.println("Dia: ");
        f.entradaNaEmpresa.dia = scanner.nextInt();
        System.out.println("Mês: ");
        f.entradaNaEmpresa.mes = scanner.nextInt();
        System.out.println("Ano: ");
        f.entradaNaEmpresa.ano = scanner.nextInt();

        return f;
    }

    static Empresa cadastrarEmpresa(Scanner scanner) {
        Empresa e = new Empresa();

        System.out.println("Digite o nome do Empresa: ");
        e.nome = scanner.next();

        System.out.println("Digite o CNPJ da Empresa: ");
        e.cnpj = scanner.next();

        System.out.println("Digite o telefone do Empresa: ");
        e.telefone = scanner.next();

        return e;
    }

    static Funcionario[] aumentarFuncionarios(Funcionario[] funcionarios) {
        int novoTamanho = funcionarios.length * 2;
        Funcionario[] f = new Funcionario[novoTamanho];

        for (int i = 0; i < funcionarios.length; i++) {
            f[i] = funcionarios[i];
        }

        return f;
    }

    static Empresa[] aumentarEmpresas(Empresa[] empresas) {
        int novoTamanho = empresas.length * 2;
        Empresa[] e = new Empresa[novoTamanho];

        for (int i = 0; i < empresas.length; i++) {
            e[i] = empresas[i];
        }

        return e;
    }

    static void pesquisarFuncionario(Funcionario[] funcionarios) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i].dependentes > 5) {
                System.out.println(funcionarios[i].nome);
                System.out.println(funcionarios[i].idade);
                System.out.println(funcionarios[i].empresa);
                System.out.println(funcionarios[i].dependentes);
                System.out.println(funcionarios[i].salario);
                System.out.println(funcionarios[i].email);
                System.out.println(funcionarios[i].cpf);
                System.out.println(funcionarios[i].cargo);
                System.out.println(funcionarios[i].nascimento.dia + "/" + funcionarios[i].nascimento.mes + "/" + funcionarios[i].nascimento.ano);
                System.out.println(funcionarios[i].entradaNaEmpresa.dia + "/" + funcionarios[i].entradaNaEmpresa.mes + "/" + funcionarios[i].entradaNaEmpresa.ano);
            }
        }
    }

    static class Funcionario {
        String nome;
        int idade;
        String empresa;
        int dependentes;
        double salario;
        String email;
        String cpf;
        String cargo;
        Data nascimento;
        Data entradaNaEmpresa;

    }

    static class Empresa {
        String nome;
        String cnpj;
        String telefone;
    }

    static class Data {
        int dia;
        int mes;
        int ano;
    }
}

