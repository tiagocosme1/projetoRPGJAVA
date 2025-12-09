package rpg;

// classe pai que contem todos os atributos do personagem de elden ring
public class Personagem {

    // atributos do personagem
    protected String nome;
    protected int vitalidade;
    protected int mente;
    protected int tenacidade;
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int fe;
    protected int arcano;

    protected int vida;

    // construtor sem nada
    public Personagem() {
    }

    // construtor com nome (sobrecarga)
    public Personagem(String nome) {
        this.nome = nome;
    }

    // metodo que calcula a vida do personagem com base na vitalidade
    protected void calcularVida() {
        this.vida = this.vitalidade * 10;
    }

    // metodo pra saber se o personagem ta vivo
    public boolean estaVivo() {
        return vida > 0;
    }

    // metodo que reduz a vida ao levar dano
    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
        System.out.println(nome + " RECEBEU " + dano + " DE DANO! (VIDA RESTANTE: " + vida + ")");
    }

    // metodo pra mostrar os atributos do personagem
    public void mostrarStatus() {
        System.out.println("\nSTATUS DE " + nome);
        System.out.println("VIDA: " + vida);
        System.out.println("VITALIDADE: " + vitalidade);
        System.out.println("MENTE: " + mente);
        System.out.println("TENACIDADE: " + tenacidade);
        System.out.println("FORÇA: " + forca);
        System.out.println("DESTREZA: " + destreza);
        System.out.println("INTELIGÊNCIA: " + inteligencia);
        System.out.println("FÉ: " + fe);
        System.out.println("ARCANO: " + arcano);
    }

    // metodo pra fazer o personagem atacar
    // retorna o dano base: força + destreza
    // pode ser sobrescrito pelas classes filhas (polimorfismo)
    public int atacar() {
        return forca + destreza;
    }

    // get de nome
    public String getNome() {
        return nome;
    }

    // get de vida
    public int getVida() {
        return vida;
    }
}
