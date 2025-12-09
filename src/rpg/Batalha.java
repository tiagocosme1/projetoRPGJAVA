package rpg;

import java.util.Scanner;

// classe pra controlar o combate
public class Batalha {

    private Jogador jogador;
    private Personagem inimigo;
    private Scanner scanner = new Scanner(System.in);

    public Batalha(Jogador jogador, Personagem inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    // metodo pra criar um loop de batalha
    // se o jogador e o inimigo estiverem vivos, os turnos vao alternar
    public void iniciar() {
        System.out.println("\nA BATALHA COMEÇOU ENTRE " + jogador.getNome() + " E " + inimigo.getNome() + "!");

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            turnoJogador();
            if (!inimigo.estaVivo()) break;
            turnoInimigo();
        }

        if (jogador.estaVivo()) {
            System.out.println("VOCÊ VENCEU A BATALHA!");
        }
    }

    // metodo que permite escolher entre atacar,
    // usar frasco e ver status
    private void turnoJogador() {
        System.out.println("\nSUA VEZ! ESCOLHA:");
        System.out.println("1 - ATACAR");
        System.out.println("2 - USAR FRASCO DE CURA");
        System.out.println("3 - STATUS");

        int opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1:
                int dano = jogador.atacar();
                inimigo.receberDano(dano);
                break;
            case 2:
                jogador.usarFrasco();
                break;
            case 3:
                jogador.mostrarStatus();
                inimigo.mostrarStatus();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA.");
        }
    }

    // metodo pro inimigo atacar automaticamente
    private void turnoInimigo() {
        System.out.println("\nTURNO DO INIMIGO!");
        int dano = inimigo.atacar();
        jogador.receberDano(dano);
    }
}
