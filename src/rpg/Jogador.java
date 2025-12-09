package rpg;


// classe que vai representar o jogador controlado pelo usuario
public class Jogador extends Personagem {

    private Classe classe;
    private int frascosDeCura = 4;

    // construtor de jogador
    public Jogador(String nome, Classe classe) {
        super(nome);
        this.classe = classe;
        configurarAtributosPorClasse();
        calcularVida();
    }

    // define os atributos de cada classe
    private void configurarAtributosPorClasse() {
        switch (classe) {
            case GUERREIRO:
                vitalidade = 14;
                mente = 9;
                tenacidade = 12;
                forca = 14;
                destreza = 11;
                inteligencia = 8;
                fe = 8;
                arcano = 9;
                break;
            case ASTROLOGO:
                vitalidade = 9;
                mente = 15;
                tenacidade = 8;
                forca = 7;
                destreza = 12;
                inteligencia = 16;
                fe = 7;
                arcano = 10;
                break;
            case BANDIDO:
                vitalidade = 11;
                mente = 10;
                tenacidade = 10;
                forca = 10;
                destreza = 14;
                inteligencia = 9;
                fe = 8;
                arcano = 12;
                break;
            case MISERAVEL:
                vitalidade = 10;
                mente = 10;
                tenacidade = 10;
                forca = 10;
                destreza = 10;
                inteligencia = 10;
                fe = 10;
                arcano = 10;
                break;
        }
    }

    // sobrescrita de atacar
    @Override
    public int atacar() {
        System.out.println(nome + " DESFERIU UM GOLPE.");
        return forca + (destreza / 2);
    }

    // metodo pra curar a vida e tambem reduz a quantidade de frascos
    public void usarFrasco() {
        if (frascosDeCura > 0) {
            int cura = vitalidade * 5;
            vida += cura;
            int vidaMax = vitalidade * 10;
            if (vida > vidaMax) {
                vida = vidaMax;
            }
            frascosDeCura--;
            System.out.println(nome + " USOU UM FRASCO DE LÁGRIMAS CARMESIM E RECUPEROU " + cura + " DE VIDA! (VIDA ATUAL: " + vida + ")");
            System.out.println("FRASCOS RESTANTES: " + frascosDeCura);
        } else {
            System.out.println("VOCÊ NÃO TEM MAIS FRASCOS!");
        }
    }

    // metodo pra restaurar os fracos ao descansar
    public void restaurarFrascos() {
        frascosDeCura = 3;
        System.out.println("FRASCOS COMPLETAMENTE RESTAURADOS!");
    }

    // get de classe
    public Classe getClasse() {
        return classe;
    }
}
