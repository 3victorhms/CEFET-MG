package exercicios;

import java.util.Random;
// import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[50];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno();
            alunos[i].inscricao = new Data();
            alunos[i].obtencaoDaCarta = new Data();
        }

        // Scanner scanner = new Scanner(System.in);
        // coloquei o scanner como comentário para caso eu queira testar manualmente
        // dps, ai n precisa escrever tudo dnv, somente apagar as barras
        Random random = new Random();

        // banco de dados para armazenar dados padrão de alunos
        String[] nomes = { "João", "Maria", "Pedro", "Ana", "Lucas", "Juliana", "Carlos", "Fernanda", "Ricardo",
                "Patrícia" };
        String[] enderecos = { "Rua A", "Rua B", "Rua C", "Rua D", "Rua E", "Rua F", "Rua G", "Rua H", "Rua I",
                "Rua J" };

        boolean continuarCadastro = true;
        int indiceAlunos = 0;
        int[] escolha = { 0, 1 };
        // Basicamente, a entrada de dados será "dinâmica", ou seja, eu posso ir
        // digitando até eu quiser parar, então essas três variáveis são para controlar
        // essa entrada de dados.
        // "continuarCadastro": variável booleana ou lógica que continua o cadastro até
        // receber falso.
        // "indiceAlunos": um contador que é incrementado sempre que "continuarCadastro"
        // continua true.
        // "escolha": se for 0 não continua, se for 1 continua, ai o random le um indice
        // aleatorio.

        while (continuarCadastro) {
            System.out.println("");
            System.out.print("Insira o nome do " + (indiceAlunos + 1) + "° aluno: ");
            alunos[indiceAlunos].nome = nomes[random.nextInt(nomes.length)];
            // alunos[indiceAlunos].nome = scanner.next();

            System.out.println("Insira a idade do " + (indiceAlunos + 1) + "° aluno: ");
            alunos[indiceAlunos].idade = random.nextDouble();
            // alunos[indiceAlunos].idade = scanner.nextInt();

            System.out.println("Insira o endereço do " + (indiceAlunos + 1) + "° aluno: ");
            alunos[indiceAlunos].endereco = enderecos[random.nextInt(enderecos.length)];
            // alunos[indiceAlunos].endereco = scanner.next();

            System.out.println("Insira a data de inscrição do " + (indiceAlunos + 1) + "° aluno: ");
            alunos[indiceAlunos].inscricao.dia = random.nextInt(31) + 1;
            alunos[indiceAlunos].inscricao.mes = random.nextInt(12) + 1;
            alunos[indiceAlunos].inscricao.ano = random.nextInt(26) + 2000;

            System.out.println("Insira a data de obtenção da carta do " + (indiceAlunos + 1) + "° aluno: ");
            alunos[indiceAlunos].obtencaoDaCarta.dia = random.nextInt(31) + 1;
            alunos[indiceAlunos].obtencaoDaCarta.mes = random.nextInt(12) + 1;
            alunos[indiceAlunos].obtencaoDaCarta.ano = random.nextInt(26) + 2000;

            if (indiceAlunos < alunos.length) {
                System.out.println("");
                System.out.println("Deseja cadastrar mais algum aluno? S/N");
                int maisUmCadastro = random.nextInt(escolha.length);
                if (maisUmCadastro == 0) {
                    continuarCadastro = false;
                    System.out.println("FIM DO CADASTRO. ");
                } else {
                    continuarCadastro = true;
                    indiceAlunos++;
                }
            } else {
                System.out.println("Não é possível cadastrar mais alunos.");
                continuarCadastro = false;
            }

            Aluno maisNovo = procurarMaisNovo(alunos, indiceAlunos);
            System.out.println("Informações do aluno menor idade: ");
            System.out.println("Nome: " + maisNovo.nome);
            System.out.println("Idade: " + maisNovo.idade);
            System.out.println("Endereco: " + maisNovo.endereco);
            System.out.println("Data de inscricao: " + maisNovo.inscricao.dia + "/" + maisNovo.inscricao.mes + "/"
                    + maisNovo.inscricao.ano);
            System.out.println(
                    "Data de obtenção de carta: " + maisNovo.obtencaoDaCarta.dia + "/" + maisNovo.obtencaoDaCarta.mes
                            + "/"
                            + maisNovo.obtencaoDaCarta.ano);

        }
    }

    static Aluno procurarMaisNovo(Aluno[] alunos, int indiceAlunos) {
        double menorIdade = alunos[0].idade;
        Aluno alunoComMenorIdade;
        alunoComMenorIdade = alunos[0];

        for (int i = 0; i < indiceAlunos; i++) {
            if (alunos[i].idade < menorIdade) {
                menorIdade = alunos[i].idade;
                alunoComMenorIdade = alunos[i];
            }
        }
        return alunoComMenorIdade;
    }

    static class Aluno { // se der errado coloca static
        String nome;
        double idade;
        String endereco;
        Data inscricao;
        Data obtencaoDaCarta;
    }

    static class Data {
        int dia;
        int mes;
        int ano;
    }
}
