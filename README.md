# Elden Ring (Text Edition) — RPG em Java

Bem-vindo ao **Elden Ring (Text Edition)** — um RPG baseado em texto, escrito em Java, inspirado no universo de Elden Ring.  
Neste jogo, você cria seu personagem, escolhe uma classe, explora áreas, luta contra inimigos e desafia bosses fortes, tudo por console.

## ⚙️ Estrutura & Tecnologias

- Linguagem: **Java**  
- Paradigma: **Programação Orientada a Objetos (POO)** — com herança, polimorfismo, sobrecarga, enumerações.  
- Projeto simples: roda no console, sem interface gráfica.  

## 🧱 Como o jogo funciona

### 🎮 Criação e escolha de classe  
O jogador insere um nome e escolhe uma classe entre:  
- Guerreiro  
- Astrologo  
- Bandido  
- Miserável  

Cada classe define atributos diferentes (vitalidade, força, destreza etc.), criando estilos distintos de personagem.

### 👥 Personagens & Inimigos  
- `Personagem`: classe base com atributos comuns e métodos como atacar, receber dano, mostrar status.  
- `Jogador`: herda Personagem — representa o jogador, com atributos definidos pela classe escolhida, e sistema de cura com frascos.  
- `Inimigo`: herda Personagem — representa inimigos comuns. A criação de inimigos usa **Factory Method** (`criarInimigo(...)`) para escolher tipo e atributos.  
- `Boss`: herda Personagem — chefes poderosos do jogo. Também criados via **Factory Method** (`criarBoss(...)`) com atributos fortes.  

### ⚔️ Combates & Exploração  
- `Batalha`: gerencia combate por turnos entre jogador e inimigo/boss. Permite atacar, usar frascos de cura, ver status e até fugir (com chance).  
- `Main`: controla o fluxo completo do jogo: menu de exploração, geração aleatória de inimigos, descanso (recupera frascos), e o combate final contra o boss (quando o jogador estiver preparado).

## 🛠️ Como rodar o jogo localmente

1. Clone o repositório:

```bash
git clone https://github.com/tiagocosme1/projetoRPGJAVA.git
```

2. Navegue até a pasta do projeto:

```bash
cd projetoRPGJAVA
```

3. Compile o código (supondo que você tenha o `javac` instalado):

```bash
javac rpg/*.java
```

4. Rode o jogo:

```bash
java rpg.Main
```

> Se estiver usando uma IDE como IntelliJ IDEA ou Eclipse, basta abrir o projeto e executar a classe `Main`.

## ✅ Funcionalidades implementadas

- Criação de personagem com escolha de classe  
- Atributos variados (vitalidade, força, destreza, inteligência etc.)  
- Inimigos comuns variados e bosses poderosos  
- Sistema de combate por turnos  
- Sistema de cura com frascos limitados  
- Menu de exploração com opções: explorar, descansar, ver status, enfrentar boss  
- Tratamento de entradas inválidas (uso correto de conversão e verificação de dados)

## 🧑‍💻 Autores
**Tiago Cosme**

**Gustavo Barboza**

