import java.util.Scanner;

public class Manual {
  public static void modoManual() {
    Scanner inp = new Scanner(System.in);

    System.out.println("quantos números voce deseja usar? (quanto mais números, mais demorado!)");
    int qntDiscos = inp.nextInt();

    int [] []torres = new int[qntDiscos+1] [3];
    int [] []possivelResultado1 = new int[qntDiscos+1] [3];
    int [] []possivelResultado2 = new int[qntDiscos+1] [3];

    Torres.pulaLinha();
    System.out.println("Sua piramide tem " + qntDiscos + " números!");

    int cont = 0;

    //inicializando as torres
    for (int i = 0; i < torres.length; i++) {
        torres[i][0] = cont;
        possivelResultado1[i][1] = cont;
        possivelResultado2[i][2] = cont;
        cont++;
    }

    Torres.MostraMatriz(torres);
    Torres.pulaLinha();

    int value = 0;
    int jogadas = 0;
    do {
        System.out.println("você pode desistir a qualquer momento digitando -1");
        System.out.println("digite o valor que deseja mover: ");

        int numeroPMover = inp.nextInt();
        value = numeroPMover;

        //verifica se o valor digitado é zero
        if (numeroPMover == 0){
          Torres.divisor();
          System.out.println("O valor zero indica que o espaço está vazio!");
          Torres.divisor();
        }
        int [] localizacaoDoNum = Torres.localizaPosicao(torres, numeroPMover);
        
        //verifica se o valor digitado existe na torre
        if(localizacaoDoNum == null && value != -1) {
          Torres.divisor();
          System.out.println("O numero digitado não existe na torre!");
          Torres.divisor();
        }
        else if(torres[localizacaoDoNum[0]-1][localizacaoDoNum[1]] > 0) {
          Torres.divisor();
          System.out.println("você só pode mover o numero do topo de uma coluna! ");
          Torres.divisor();
        }
        else {
          System.out.println("digite a coluna para onde deseja mover o numero");
          int coluna = inp.nextInt();
          value = coluna;
          //verifica se a coluna existe
          if (coluna > 3 || coluna < 1) {
            Torres.divisor();
            System.out.println("numero invalido, você só tem 3 colunas");
            Torres.divisor();
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
                Torres.MostraMatriz(torres);
              } else {
                Torres.pulaLinha();
                Torres.divisor();
                System.out.println("Um número maior nunca pode ser colocado sobre um número menor.");
                Torres.divisor();
              }
            } else {
              torres[localizacaoDoNum[0]][localizacaoDoNum[1]] = 0;
              torres[linha][coluna-1] = numeroPMover;
              System.out.println("numero movido");
              Torres.MostraMatriz(torres);
            }
          } 

          jogadas++;

          if (Torres.compararMatrizes(torres, possivelResultado1, possivelResultado2)) {
            Torres.pulaLinha();
            Torres.divisor();
            System.out.println("Parabéns, Você completou o jogo em " + jogadas + " jogadas!");
            Torres.divisor();
            value = 10;
          }
        }
      }while (value != -1);

    inp.close();
  }
}
