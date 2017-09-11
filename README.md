# Projeto Sesqui
### Especificações de Requisito de Software
Versão 1.0 - 22/08/2017

|Versão|Autor(es)                            |Data      |Ação                          |
|------|-------------------------------------|----------|------------------------------|
|1.0   |Rodrigo Chaves, Luis Armando da Silva|22/08/2017|Estabelecimento dos Requisitos|

## Conteúdo
1. Introdução
2. Visão Geral
3. Requisitos de Software
4. Esboço da Interface Gráfica

## 1. Introdução
### Objetivo
Desenvolvimento de um sistema distribuido que possibilite que dois usuários joguem entre sí o jogo Sesqui.

### O jogo
O jogo ocorre em um tabuleiro 8 por 8 e é jogado com 30 peças brancas e 30 peças pretas. O jogador com peças negras pretende conectar os lados norte e sul, enquanto o jogador com peças brancas pretende conectar do mesmo modo os lados leste e oeste.

### Regras do jogo
- O tabuleiro começa vazio.
- O jogador com peças brancas começa colocando uma peça em qualquer posição. Em seguida o jogador com peças pretas coloca suas peças em duas casas vazias.
- A partir do segundo lançe cada jogador efetua uma colocação e uma movimentação de peças suas pela ordem que quiser (colocar, movimentar ou movimentar, colocar).
- A colocação de uma nova peça deve ser numa casa vazia adjacente, na vertical ou horizontal, a uma outra peça da mesma cor.
- A movimentação de uma peça já no tabuleiro deve efetuar-se como se fosse uma rainha de xadrez, a peça deve terminar numa casa vazia.
- É proibido em qualquer momento da partida, realizar um cruzamento de peças, isto é, criar no tabuleiro qualquer um dos seguintes padrões de quatro peças:

![Imagem demonstrando cruzamento de peças](https://raw.githubusercontent.com/chavesfop/sesqui/master/cruzamento_pecas.png)

## 2. Visão geral
### Arquitetura do programa
Programa orientado a objetos, e um sistema distribuido do tipo cliente servidor.

### Premissas de desenvolvimento
- O programa deve apresentar uma interface gráfica bidimensional.
- O programa deve ser implementado em Java.
- A aplicação deverá suportar rede, atraves da arquitetura cliente/servidor, fazendo uso da ferramenta NetGamesNRT, permitindo assim uma aplicação integrada/distribuida.

## 3. Requisitos de software 
### 3.1 Requisitos funcionais
#### Requisito funcional 1: Conectar
O software deve apresentar em seu menu a opção "Conectar", para assim estabelecer conexão com o NetGamesNRT.

#### Requisito funcional 2: Desconectar
O software deve apresentar a opção de menu "Desconectar", permitindo desconectar do servidor, encerrando assim uma possível partida em andamento.

#### Requisito funcional 3: Iniciar partida
O software deve apresentar a opção de menu "Iniciar" para o início de uma nova partida, operação em que é definido a identificação de jogadores.

#### Requisito funcional 4: Sortear cores
O software, no inicio da partida, irá sortear as cores dos jogadores conectados.

#### Requisito funcional 5: Realizar Turno / Rodada
O software deve apresentar o jogador do turno (ou rodada), possibilitando que o jogador realize a colocação de uma peça (de acordo com as regras) ao clicar em um espaço vazio. Ou selecionar uma peça para movimentação utilizando um clique com o botão esquerdo, e em seguida outro clique com o botão esquerdo para uma posição de movimentação válida. Ao terminar qualquer uma destas
ações o jogador deve apertar o botão 'confirmar movimento/colocação'.

### 3.2 Requisitos não funcionais
#### Requisito não funcional 1: Especificação de projeto
Código em linguagem Java e especificação de projeto baseada em UML2.

#### Requisito não funcional 2: Interface gráfica para usuário
O software deverá ter interface gráfica única, partilhada pelos usuários.

#### Requisito não funcional 3: Símbolos dos jogadores
As peças dos jogadores serão identificadas com a cor preta e do outro jogador com a cor branca.

#### Requisito não funcional 4: Tecnologia de interface gráfica
Interface gráfica baseada em Java, utilizando a biblioteca Swing.

## Esboço da interface gráfica

![Janela de interface grafica com o titulo Sesqui, abaixo um tabuleiro de oito por oito e a esquerda do tabuleiro dois contadores denominados movimentar e colocar, abaixo dos contadores um botão](https://raw.githubusercontent.com/chavesfop/sesqui/master/esboco_interace_grafica.png)
