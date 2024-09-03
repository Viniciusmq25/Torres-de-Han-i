import java.util.Scanner;

public class Torres {

  public static Scanner inp = new Scanner(System.in);

  public static void main(String[] args) {

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
    
    System.out.println("""
        MODOS DE JOGO:

        1. MANUAL
        2. AUTOMATICO
        """);
    int modo = inp.nextInt();

    if(modo == 1) {
      Manual.modoManual();
    }
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