        package Exercicio35_36;

        import java.util.Scanner;

        public class Pig {
            Scanner leia = new Scanner(System.in);
            Jogador j1 = new Jogador();
            Jogador j2 = new Jogador();
            ParDeDados dados = new ParDeDados();

            void jogar() {
                j1.indice = 1;
                j2.indice = 2;

                Jogador jogadorAtual = j1;
                int pontosDaRodada;

                boolean fimDeJogo = false;

                while (!fimDeJogo) {

                    boolean continuarRodada = true;
                    pontosDaRodada = 0;

                    while (continuarRodada) {
                        int[] resultado = dados.rolar();
                        int d1 = resultado[0];
                        int d2 = resultado[1];

                        if (d1 != 1 && d2 != 1) {
                            pontosDaRodada += d1 + d2;
                            if (pontosDaRodada >= 20) {
                                if (jogadorAtual.indice == 1) {
                                    j1.adicionarPontos(pontosDaRodada);
                                    jogadorAtual = j2;
                                } else {
                                    j2.adicionarPontos(pontosDaRodada);
                                    jogadorAtual = j1;
                                }
                                continuarRodada = false;
                            }
                        } else {
                            if (!jogadorAtual.taArriscando()) {
                                System.out.println("ESCOLHA: ");
                                System.out.println("1 - PERDER TODOS PONTOS DA RODADA E PASSAR A VEZ");
                                System.out.println("2 - ARRISCAR");
                                int escolha = leia.nextInt();

                                if (escolha == 1) {
                                    pontosDaRodada = 0;
                                    if (jogadorAtual.indice == 1) {
                                        j1.arriscando = false;
                                        jogadorAtual = j2;

                                    } else {
                                        j2.arriscando = false;
                                        jogadorAtual = j1;
                                    }
                                    continuarRodada = false;
                                } else {
                                    jogadorAtual.arriscando = true;
                                }
                            } else {
                                jogadorAtual.pontos = 0;
                                jogadorAtual = jogadorAtual == j1 ? j2 : j1;
                                continuarRodada = false;
                            }
                        }
                    }
                    if (j1.ganhou()) {
                        System.out.println("O vencedor foi o jogador 1");
                        fimDeJogo = true;
                    } else if (j2.ganhou()) {
                        System.out.println("O vencedor foi o jogador 2");
                        fimDeJogo = true;
                    } else {
                        System.out.println("A partida continua");
                    }
                }
            }
        }
