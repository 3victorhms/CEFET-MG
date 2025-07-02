package Exercicio37;

import java.util.Scanner;

public class Funcionario {
    private String nome, departamento, rg, cpf;
    private double salario;
    private Data dtEntrada = new Data();

    public Funcionario() {
    }

    public Funcionario(String nome) {
        if (!nome.isEmpty())
            this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public Data getDtEntrada() {
        return dtEntrada;
    }

    public void setSalario(double salario) {
        if (salario >= 0)
            this.salario = salario;
    }

    public void lerFuncionario() {
        Scanner scn = new Scanner(System.in);

        this.nome = validarEntrada("Digite o nome do funcionário:", scn);
        this.departamento = validarEntrada("Digite o departamento do funcionário:", scn);
        this.rg = validarEntrada("Digite o RG do funcionário:", scn);

        this.cpf = validarEntrada("Digite o CPF do funcionário:", scn);
        this.validarCPF();
        while (!this.validarCPF()) {
            this.cpf = validarEntrada("Insira um CPF válido:", scn);
        }

        this.salario = validarSalario("Digite o salário do funcionário:", scn);
        this.dtEntrada.dia = validarData("Digite a data de entrada do funcionário (dia):", scn, 1, 31);
        this.dtEntrada.mes = validarData("Digite a data de entrada do funcionário (mês):", scn, 1, 12);
        this.dtEntrada.ano = validarData("Digite a data de entrada do funcionário (ano):", scn, 1900, 2025);

        scn.close();
    }

    private String validarEntrada(String mensagem, Scanner leia) {
        String entrada;
        do {
            System.out.println(mensagem);
            entrada = leia.nextLine();
            if (entrada == null || entrada.isEmpty()) {
                System.out.println("Entrada inválida. Tente novamente.");
                entrada = leia.nextLine();
            }
        } while (entrada == null || entrada.isEmpty());
        return entrada;
    }

    private double validarSalario(String mensagem, Scanner leia) {
        double salario;
        do {
            System.out.println(mensagem);
            salario = leia.nextDouble();
            if (salario < 0) {
                System.out.println("Salário inválido. Tente novamente.");
                salario = leia.nextDouble();
            }
        } while (salario < 0);
        return salario;
    }

    private int validarData(String mensagem, Scanner leia, int min, int max) {
        int data;
        do {
            System.out.println(mensagem);
            data = leia.nextInt();
            if (data < min || data > max) {
                System.out.println("Data inválida. Tente novamente.");
                data = leia.nextInt();
            }
        } while (data < min || data > max);
        return data;
    }

    private boolean validarCPF() {
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
            return false;
        }

        // se chegar aqui o formato do cpf é válido, agora vai verificar o dígito
        // verificador

        // primeiro copia todos os números para um vetor, considerando as duas situações
        // (length == 11 ou length == 14)
        int[] numerosCPF = new int[11];
        if (tamanhoCPF == 14) {
            // se for 14 o código tem que pegar somente os numeros
            int indice = 0;
            for (int i = 0; i < 14; i++) {
                if (Character.isDigit(this.cpf.charAt(i))) {
                    numerosCPF[indice] = this.cpf.charAt(i) - '0';
                    indice++;
                }
            }
        } else {
            // então o tamanho é 11 e o usuário escreveu no formato de somente números
            for (int i = 0; i < 11; i++) {
                numerosCPF[i] = this.cpf.charAt(i) - '0';
            }
        }

        // calculando o primeiro DV
        int dv1;
        // primeiro separa os 9 dígitos e multiplica cada número por um número
        // decrescente começando em 10 e terminando em 2
        int numeroMultiplicador = 10;
        int[] numerosVerificacao = new int[10];
        for (int i = 0; i < 9; i++) {
            numerosVerificacao[i] = numerosCPF[i] * numeroMultiplicador;
            numeroMultiplicador--;
        }
        // agora soma os valores e divide por 11
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numerosVerificacao[i];
        }

        if (soma % 11 < 2) {
            dv1 = 0;
        } else {
            dv1 = 11 - (soma % 11);
        }

        if (dv1 != numerosCPF[9]) {
            // já verifica direto se o primeiro dígito verificador está correto
            // se não tiver já retorna falso, se estiver continua a função
            return false;
        } else {
            // se chegar aqui o primeiro dígito verificador está correto
            // agora vai verificar o segundo dígito verificador

            numerosVerificacao[9] = dv1;
            int dv2;
            // mesma lógica do primeiro DV, porém agora considerando os 9 dígitos do CPF + o
            // segundo DV
            numeroMultiplicador = 11;
            for (int i = 0; i < 10; i++) {
                numerosVerificacao[i] = numerosCPF[i] * numeroMultiplicador;
                numeroMultiplicador--;
            }
            // agora soma os valores e divide por 11
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += numerosVerificacao[i];
            }

            if (soma % 11 < 2) {
                dv2 = 0;
            } else {
                dv2 = 11 - (soma % 11);
            }

            // já verifica direto se o primeiro dígito verificador está correto
            // se não tiver já retorna falso, se estiver continua a função
            // se chegar aqui o segundo dígito verificador está correto
            return dv2 == numerosCPF[10];
        }
    }

    private void recebeAumento(double aumento) {
        this.salario += aumento;
    }

    public double getGanhoAnual() {
        return this.salario * 12;
    }

}

class Empresa {
    String nome;
    Funcionario[] empregados = new Funcionario[0];
    String cnpj;

    void adiciona(Funcionario f) {
        this.empregados = aumentarEmpregados(this.empregados);
        this.empregados[empregados.length - 1] = f;
    }

    Funcionario[] aumentarEmpregados(Funcionario[] empregados) {
        Funcionario[] empregadosNovos = new Funcionario[empregados.length + 1];
        System.arraycopy(empregados, 0, empregadosNovos, 0, empregados.length);
        empregadosNovos[empregados.length] = new Funcionario();
        return empregadosNovos;
    }

    void mostra() {
        if (empregados != null) {
            for (int i = 0; i < empregados.length; i++) {
                if (empregados[i] != null) {
                    System.out.println("Nome: " + empregados[i].getNome());
                    System.out.println("Departamento: " + empregados[i].getDepartamento());
                    System.out.println("RG: " + empregados[i].getRg());
                    System.out.println("Data de entrada: " + empregados[i].getDtEntrada().dia + "/"
                            + empregados[i].getDtEntrada().mes + "/" + empregados[i].getDtEntrada().ano);
                    System.out.println("Salário: " + empregados[i].getSalario());
                    System.out.println("Ganho anual: " + empregados[i].getGanhoAnual());
                }
            }
        }
    }
}
