package rpg;

// classe pra inimigos comuns, classe filha de personagem
public class Inimigo extends Personagem {

    private int recompensaXP;
    private boolean boss = false;

    // construtor simples
    public Inimigo(String nome) {
        super(nome);
        this.vitalidade = 8;
        this.forca = 6;
        this.destreza = 6;
        this.vida = 80;
        this.recompensaXP = 20;
    }
    // construtor completo pra criar inimigos com atributos especificos
    public Inimigo(String nome, int vida, int forca, int destreza, boolean boss, int recompensaXP) {
        super(nome);
        this.vitalidade = vida / 10;
        this.forca = forca;
        this.destreza = destreza;
        this.vida = vida;
        this.boss = boss;
        this.recompensaXP = recompensaXP;
    }

    // sobrescrita do metodo atacar
    // ataque dos inimigos é diferente do ataque do jogador
    @Override
    public int atacar() {
        System.out.println(nome + " ATACA COM FEROCIDADE!");
        return forca + (destreza / 2);
    }

    // get pra recompensa
    public int getRecompensaXP() {
        return recompensaXP;
    }

    // metodo pra saber se o inimigo é boss ou nao
    public boolean isBoss() {
        return boss;
    }

    // metodo pra gerar inimigos comuns
    public static Inimigo criarInimigo(String tipo) {
        switch (tipo) {
            case "GUARDA DE TEMPESVEU":
                return new Inimigo("GUARDA DE TEMPESVÉU", 30, 12, 8, false, 50);
            case "SOLDADO DE GODRICK":
                return new Inimigo("SOLDADO DE GODRICK", 35, 14, 10, false, 60);
            case "TROLL PUTRIDO":
                return new Inimigo("TROLL PUTRIDO", 40, 20, 6, false, 120);
            default:
                return new Inimigo("INIMIGO DESCONHECIDO");
        }
    }
}
