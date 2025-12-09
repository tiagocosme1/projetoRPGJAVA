package rpg;

// classe para criar os chefes (Malenia, Radahn, Malekith)
// os chefes tem os atributos bem maiores
public class Boss extends Personagem {

    // construtor completo de boss
    public Boss(String nome, int vitalidade, int forca, int destreza, int inteligencia, int fe) {
        super(nome);
        this.vitalidade = vitalidade;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.fe = fe;
        this.mente = 20;
        this.tenacidade = 25;
        this.arcano = 15;
        calcularVida();
    }

    // sobrescrita do metodo atacar
    // o ataque dos chefes é bem mais forte do que os inimigos comuns
    @Override
    public int atacar() {
        System.out.println(nome + " REALIZOU UM ATAQUE!");
        return forca + destreza + 5;
    }

    // factory pra criar o boss
    public static Boss criarBoss(String nomeBoss) {
        switch (nomeBoss) {
            case "Malenia":
                return new Boss("MALENIA, LÂMINA DE MIQUELLA", 40, 35, 28, 20, 25);
            case "Malekith":
                return new Boss("MALEKITH, A LÂMINA DE ÉBANO", 45, 38, 22, 15, 30);
            case "Radahn":
                return new Boss("RADHAN, FLAGELO ESTELAR", 50, 40, 30, 10, 15);
            default:
                return new Boss(nomeBoss, 30, 20, 15, 10, 10);
        }
    }
}
