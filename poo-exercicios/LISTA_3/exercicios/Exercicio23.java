package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int indiceAlunos = 100;

        Aluno[] alunos = new Aluno[indiceAlunos]; // criação do array pessoas
        for (int i = 0; i < indiceAlunos; i++) { // inicialização dos objetos
            alunos[i] = new Aluno();
        }

        alunos = preencherVetor(alunos, scanner, random);
        calcularMedia(alunos);

    }

    static Aluno[] preencherVetor(Aluno[] alunos, Scanner scanner, Random random) {

        String[] nomes = {"Ana", "Maria", "Pedro", "Ricardo", "Patricia"};

        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Insira o nome do aluno " + (i + 1) + ": ");
            //alunos[i].nome = scanner.next();
            alunos[i].nome = nomes[random.nextInt(nomes.length)];
            while (alunos[i].nome.length() > 30) {
                System.out.println("Insira um nome com menos de 30 caracteres: ");
                //alunos[i].nome = scanner.next();
                alunos[i].nome = nomes[random.nextInt(nomes.length)];
            }

            alunos[i].numero = i + 1;
            for (int j = 0; j < (alunos[i].notas.length); j++) {
                System.out.println("Insira a " + (j + 1) + "a nota do aluno " + alunos[i].numero + ": ");
                alunos[i].notas[j] = random.nextDouble(10) + 1;
                //alunos[i].notas[j] = scanner.nextDouble();
            }
        }
        return alunos;
    }

    static void imprimir(Aluno[] alunos, double[] maioresMedias) {

        System.out.println("As maiores médias foram: ");
        for (int i = 0; i < maioresMedias.length; i++) {
            System.out.println(maioresMedias[i]);
        }

        System.out.println("Os alunos que alcançaram as três (3) maiores médias foram: ");

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i].media >= maioresMedias[maioresMedias.length - 1]) {
                System.out.println("--------------------");
                System.out.println("Nome: " + alunos[i].nome);
                System.out.println("Numero: " + alunos[i].numero);
                System.out.println("Média: " + alunos[i].media);
            }
        }
    }

    static void calcularMedia(Aluno[] alunos) {
        double total;

        for (int i = 0; i < alunos.length; i++) {
            total = 0.0;
            for (int j = 0; j < alunos[i].notas.length; j++) {
                total = total + alunos[i].notas[j];
            }
            alunos[i].media = Math.floor((total / alunos[i].notas.length) * 100) / 100;
        }

        double[] mediasOrdenadas = new double[alunos.length];
        for (int i = 0; i < alunos.length; i++) {
            mediasOrdenadas[i] = alunos[i].media;
        }

        for (int i = 0; i < (mediasOrdenadas.length - 1); i++) {
            for (int j = (i + 1); j < mediasOrdenadas.length; j++) {
                if (mediasOrdenadas[i] < mediasOrdenadas[j]) {
                    double temp = mediasOrdenadas[i];
                    mediasOrdenadas[i] = mediasOrdenadas[j];
                    mediasOrdenadas[j] = temp;
                }
            }
        }

        double[] maioresMedias = new double[3];
        int controleMedias = 0;

        for (int i = 0; i < mediasOrdenadas.length && controleMedias < 3; i++) {
            boolean jaExiste = false;
            for (int j = 0; j < controleMedias; j++) {
                if (mediasOrdenadas[i] == mediasOrdenadas[j]) {
                    jaExiste = true;
                    break;
                }
            }
            if (!jaExiste) {
                maioresMedias[controleMedias] = mediasOrdenadas[i];
                controleMedias++;
            }
        }

        imprimir(alunos, maioresMedias);
    }


    static class Aluno {
        String nome;
        int numero;
        double[] notas = new double[10];
        double media = 0;
    }
}