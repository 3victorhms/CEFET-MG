package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int x;
        System.out.print("Insira quantas pessoas deseja cadastrar: ");
        // x = scanner.nextInt();
        x = random.nextInt(10) + 1;
        while (x >= 10) {
            System.out.print("Insira um número menor que 10: ");
            // x = scanner.nextInt();
        }

        Pessoa[] pessoas = new Pessoa[x]; // criação do array pessoas
        for (int i = 0; i < x; i++) { // inicialização dos objetos
            pessoas[i] = new Pessoa();
        }

        pessoas = preencherVetor(pessoas, scanner, random);
        imprimirNome(pessoas);
        pesquisaSexo(pessoas);
        verificarParentesco(pessoas);
    }

static Pessoa[] preencherVetor(Pessoa[] pessoas, Scanner scanner, Random random) {

        String[] nomes = {"Ana", "Maria", "Pedro", "Ricardo", "Patricia"};
        String[] sobrenomes = {"Soares", "Fernandes", "Silva", "Souza", "Castro"};
        char[] sexo = {'M', 'F'};

        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("Insira o primeiro nome da pessoa " + (i + 1) + ": ");
            //pessoas[i].primeiroNome = scanner.next();
            pessoas[i].primeiroNome = nomes[random.nextInt(nomes.length)];

            System.out.println("Insira o sobrenome da pessoa " + (i + 1) + ": ");
            //pessoas[i].sobrenome = scanner.next();
            pessoas[i].sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];

            System.out.println("Insira o sexo da pessoa " + (i + 1) + "(M ou F): ");
            //pessoas[i].sexo = scanner.next();
            pessoas[i].sexo = sexo[random.nextInt(sexo.length)];
            while (pessoas[i].sexo != 'M' && pessoas[i].sexo != 'F') {
                System.out.println("O sexo deve ser 'M' ou 'F': ");
                //pessoas[i].sexo = scanner.next();
            }
        }
        return pessoas;
    }

    static void imprimirNome(Pessoa[] pessoas) {
        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("Nome: " + pessoas[i].primeiroNome + " " + pessoas[i].sobrenome);
        }
    }

    static void pesquisaSexo(Pessoa[] pessoas) {
        int indiceM = 0;
        int indiceF = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].sexo == 'M') {
                indiceM++;
            }
            if (pessoas[i].sexo == 'F') {
                indiceF++;
            }
        }
        System.out.println();
        System.out.println("M: " + indiceM);
        System.out.println("F: " + indiceF);
    }

    static void verificarParentesco(Pessoa[] pessoas) {
        int indiceParentes = 0;
        for (int i = 0; i < pessoas.length; i++) {
            for (int j = (i+1); j < pessoas.length; j++) {
                if (pessoas[i].sobrenome == pessoas[j].sobrenome && i != j){
                    System.out.println("Pessoas possivelmente parentes: " + pessoas[i].primeiroNome + " " + pessoas[i].sobrenome +
                    " e " + pessoas[j].primeiroNome + " " + pessoas[j].sobrenome);
                    indiceParentes++;
                }
            }
        }
        if (indiceParentes == 0) {
            System.out.println("De acordo com os sobrenomes não há nenhum parentesco no vetor.");
        }
    }

    static class Pessoa {
        String primeiroNome;
        String sobrenome;
        char sexo;
    }
}