# Relatório do trabalho das Torres de Hanoi
Autores:
Lucas Ferreira, Arthur Brito e Vinicius Quintian

> [!NOTE]
> (A) detalhes sobre como a solução foi elaborada/modelada

## Resumo:
### Classe TorreDeHanoi: Representa o jogo das Torres de Hanoi e contém métodos para o modo de jogo manual e automático.
 - Propriedades:
    * hastes: Um array de tres pilhas (MinhaPilha[]) que representam as tres hastes do jogo.
    * numDiscos: Numero de discos(numeros) que o usuário deseja jogar.
    * numJogadas: Contador de jogadas realizadas.
    * iniciaJogo(): Inicializa o jogo colocando todos os discos na primeira haste.
    * mostraHastes(): Exibe o estado atual das hastes.
    * moveDisco(int origem, int destino): Move um disco da haste de origem para a haste de destino, validando as regras do jogo.
    * modoManual(): Permite que o usuário jogue manualmente.
    * modoAuto(): Resolve automaticamente o problema das Torres de Hanoi utilizando recursão (resolverHanoi).

> [!NOTE]
> (B) Como o código enviado deve ser compilado
> 
## Para compilar o código Java, siga os seguintes passos:

  1. Salve o .zip enviado e extraia os arquivos.

  2. Abra o terminal ou prompt de comando e navegue até o diretório onde o arquivo foi salvo.

  3. Compile o código usando o comando:
  javac TorreDeHanoi.java

  4. Execute o programa com o comando:
  java TorreDeHanoi

> [!NOTE]
> (C) Exemplo de Validação do Trabalho
  - Exemplo 1: Modo Manual
    * Execute o programa e escolha o numero de discos.
    * Selecione o modo de jogo "MANUAL" digitando 1.
    * Siga as instruções na tela para mover os discos de uma haste para outra.
    * Ao finalizar o jogo com sucesso, o programa exibirá a mensagem indicando o numero de jogadas realizadas.
      
  - Exemplo 2: Modo Automático
    * Execute o programa e escolha o numero de discos.
    * Selecione o modo de jogo "AUTOMATICO" digitando 2.
    * O programa irá automaticamente mover os discos, mostrando cada movimento passo a passo até a solução e mostrando quantas jogadas foram necessarias para completar.
      
> [!NOTE]     
> (D) Contribuição de Cada Aluno

  * Lucas Ferreira: Implementação dos métodos iniciaJogo, mostraHastes e moveDisco, e validação do modo manual.
  * Vinicius Quintian: Desenvolvimento do método resolverHanoi e do modo automático, além da lógica de recursão.
  * Arthur Brito: Testes do jogo nos modos manual e automático, e análise da complexidade dos métodos.

Análise de Complexidade
  * iniciaJogo(): Complexidade é O(n), onde n é o numero de discos, pois cada disco é empilhado uma vez.
  * mostraHastes(): Complexidade é O(n) para exibir o estado atual de cada haste.
  * moveDisco(): Complexidade é O(1) para mover um disco.
  * modoManual(): Complexidade depende do numero de jogadas, mas cada jogada é O(1).
  * modoAuto() e resolverHanoi(): A solução recursiva para o problema das Torres de Hanoi tem uma complexidade O(2^n), onde n é o numero de discos. Isso ocorre porque cada chamada para resolverHanoi se desdobra em duas outras chamadas recursivas.
