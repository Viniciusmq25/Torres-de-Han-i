import java.util.Scanner;

public class Manual {
  public static void modoManual() {
    Scanner inp = new Scanner(System.in);


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
  }
}
