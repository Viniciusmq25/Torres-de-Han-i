import java.util.Scanner;

public class Torres {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);

    pulaLinha();
    pulaLinha();
    System.out.println("Quabra cabeça das Torres de Hanoi!");
    System.out.println("""

    O objetivo é mover uma coluna de números de diferentes tamanhos de uma coluna para outra, 
    utilizando uma coluna intermediária, respeitando as seguintes regras:

    1. Apenas um números pode ser movido por vez.
    2. Um número maior nunca pode ser colocado sobre um número menor.
    3. Todos os números devem estar empilhados em ordem decrescente de tamanho em uma das colunas ao final do processo.

    Comece o jogo:
    """);
    System.out.println("quantos números voce deseja usar? (quanto mais números, mais demorado!)");
    int qntDiscos = inp.nextInt();
  
    int [] []torres = new int[qntDiscos+1] [3];
    int [] []possivelResultado1 = new int[qntDiscos+1] [3];
    int [] []possivelResultado2 = new int[qntDiscos+1] [3];

    pulaLinha();
    System.out.println("Sua piramide tem " + qntDiscos + " números!");

    int cont = 0;

    //inicializando as torres
    for (int i = 0; i < torres.length; i++) {
        torres[i][0] = cont;
        possivelResultado1[i][1] = cont;
        possivelResultado2[i][2] = cont;
        cont++;
    }

    MostraMatriz(torres);
    pulaLinha();

    int value = 0;
    int jogadas = 0;
    do {
        System.out.println("você pode desistir a qualquer momento digitando 10");
        System.out.println("digite o valor que deseja mover: ");

        int numeroPMover = inp.nextInt();
        value = numeroPMover;

        //verifica se o valor digitado é zero
        if (numeroPMover == 0){
          divisor();
          System.out.println("O valor zero indica que o espaço está vazio!");
          divisor();
        }
        int [] localizacaoDoNum = localizaPosicao(torres, numeroPMover);
        
        //verifica se o valor digitado existe na torre
        if(localizacaoDoNum == null) {
          divisor();
          System.out.println("O numero digitado não existe na torre!");
          divisor();
        }
        else if(torres[localizacaoDoNum[0]-1][localizacaoDoNum[1]] > 0) {
          divisor();
          System.out.println("você só pode mover o numero do topo de uma coluna! ");
          divisor();
        }
        else {
          System.out.println("digite a coluna para onde deseja mover o numero");
          int coluna = inp.nextInt();
          value = coluna;
          //verifica se a coluna existe
          if (coluna > 3 || coluna < 1) {
            divisor();
            System.out.println("numero invalido, você só tem 3 colunas");
            divisor();
          } else{
            int linha = qntDiscos;

            //verifica se o numero a ser movido pode ser colocado na torre
            if (torres[linha][coluna-1] != 0 ){
              while (torres[linha][coluna-1] != 0 ) {
                linha--;
              }

              //verifica se o numero pode ser colocado
              if(torres[linha+1][coluna-1] > numeroPMover) {
                torres[localizacaoDoNum[0]][localizacaoDoNum[1]] = 0;
                torres[linha][coluna-1] = numeroPMover;

                System.out.println("numero movido");
                MostraMatriz(torres);
              } else {
                pulaLinha();
                divisor();
                System.out.println("Um número maior nunca pode ser colocado sobre um número menor.");
                divisor();
              }
            } else {
              torres[localizacaoDoNum[0]][localizacaoDoNum[1]] = 0;
              torres[linha][coluna-1] = numeroPMover;
              System.out.println("numero movido");
              MostraMatriz(torres);
            }
          } 

          jogadas++;

          if (compararMatrizes(torres, possivelResultado1, possivelResultado2)) {
            pulaLinha();
            divisor();
            System.out.println("Parabéns, Você completou o jogo em " + jogadas + " jogadas!");
            divisor();
            value = 10;
          }
        }
      }while (value != 10);

    inp.close();
  }

  public static void MostraMatriz(int [][]torres) {
    for (int i = 0; i < torres.length; i++) {
      pulaLinha();
      for (int j = 0; j < torres[i].length; j++) {
          System.out.print("["+ torres[i][j]+"]" + " " );
      }
      System.out.println();
    }
  }

  public static int[] localizaPosicao(int[][] matriz, int numero) {
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] == numero) {
                return new int[]{i, j};
            }
        }
    }
    return null;
  }

  public static boolean compararMatrizes(int[][] torres, int[][] possivelResultado1, int[][] possivelResultado2) {
    return matrizIgual(torres, possivelResultado1) || matrizIgual(torres, possivelResultado2);
  }

  private static boolean matrizIgual(int[][] matriz1, int[][] matriz2) {

    // Compara elemento por elemento
    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1[i].length; j++) {
            if (matriz1[i][j] != matriz2[i][j]) {
                return false;
            }
        }
    }
    return true;
  }

  public static void pulaLinha(){
    System.out.println("");
  }

  public static void divisor(){
    System.out.println("======================//======================");
  }
}