package rpg;

import java.util.Scanner;

// classe principal
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("BEM-VINDO AO ELDEN RING TEXT EDITION");
        System.out.print("DIGITE O NOME DO SEU PERSONAGEM: ");
        String nome = sc.nextLine();

        Classe classe = escolherClasse(sc);
        Jogador jogador = new Jogador(nome, classe);

        jogador.mostrarStatus();

        int inimigosDerrotados = 0;

        // menu de exploração
        while (jogador.estaVivo()) {
            System.out.println("\nÁREA DE TEMPESVÉU");
            System.out.println("1 - EXPLORAR");
            System.out.println("2 - DESCANSAR (RECUPERA FRASCOS)");
            System.out.println("3 - VER STATUS");
            System.out.println("4 - ENFRENTAR O BOSS");
            System.out.println("ESCOLHA: ");

            int escolha = Integer.parseInt(sc.nextLine());

            switch (escolha) {

                case 1: // explorar
                    System.out.println("\nVOCÊ AVANÇA PELA ÁREA...");
                    Personagem inimigo = gerarInimigoAleatorio();
                    new Batalha(jogador, inimigo).iniciar();

                    if (jogador.estaVivo()) {
                        inimigosDerrotados++;
                        System.out.println("\nVOCÊ DERROTOU " + inimigosDerrotados + " INIMIGO(S).");
                    }
                    break;

                case 2: // descansar
                    System.out.println("VOCÊ DESCANSA EM UM LOCAL DA GRAÇA...");
                    jogador.restaurarFrascos();
                    break;

                case 3:
                    jogador.mostrarStatus();
                    break;

                case 4: // boss
                    if (inimigosDerrotados < 2) {
                        System.out.println("VOCÊ SENTE QUE AINDA NÃO ESTÁ PREPARADO... (DERROTE PELO MENOS 2 INIMIGOS)");
                    } else {
                        Boss boss = Boss.criarBoss("MALENIA");
                        new Batalha(jogador, boss).iniciar();
                        System.out.println("\nVOCÊ MORREU.");
                        return;
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA.");
            }
        }

        System.out.println("\nVOCÊ MORREU...");
        sc.close();
    }

    // seleciona um inimigo de forma aleatoria
    private static Personagem gerarInimigoAleatorio() {
        String[] nomes = {
                "GUARDA DE TEMPESVEU",
                "SOLDADO DE GODRICK",
                "TROLL PUTRIDO"
        };

        int sorteio = (int)(Math.random() * nomes.length);
        return Inimigo.criarInimigo(nomes[sorteio]);
    }

    // aqui o usuario vai escolher a classe que ele quer
    private static Classe escolherClasse(Scanner sc) {
        System.out.println("\nESCOLHA SUA CLASSE:");
        System.out.println("1 - GUERREIRO");
        System.out.println("2 - ASTROLOGO");
        System.out.println("3 - BANDIDO");
        System.out.println("4 - MISERAVEL");

        int escolha = Integer.parseInt(sc.nextLine());

        switch (escolha) {
            case 1: return Classe.GUERREIRO;
            case 2: return Classe.ASTROLOGO;
            case 3: return Classe.BANDIDO;
            case 4: return Classe.MISERAVEL;
            default:
                System.out.println("INVÁLIDO — MISERÁVEL SELECIONADO.");
                return Classe.MISERAVEL;
        }
    }
}
