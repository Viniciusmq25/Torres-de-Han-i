import java.util.Scanner;

public class TorreDeHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("Quantos números voce deseja usar? (quanto mais números, mais demorado!)");
        int numDiscos = scanner.nextInt();

        TorreDeHanoi jogo = new TorreDeHanoi(numDiscos);

        System.out.println("""
        MODOS DE JOGO:

        1. MANUAL
        2. AUTOMATICO
        """);
        int modo = scanner.nextInt();

        if (modo == 1) {
            jogo.modoManual();
        } else if (modo == 2) {
            jogo.modoAuto();
        } else {
            pulaLinha();
            divisor();
            System.out.println("Este modo não existe!");
            divisor();
        }
    }

    private MinhaPilha[] hastes;
    private int numDiscos;
    private int numJogadas;

    public TorreDeHanoi(int numDiscos) {
        this.numDiscos = numDiscos;
        this.numJogadas = 0;
        hastes = new MinhaPilha[3];
        for (int i = 0; i < 3; i++) {
            hastes[i] = new MinhaPilha();
        }
        iniciaJogo();
    }
    private void iniciaJogo() {
        for (int i = numDiscos; i > 0; i--) {
            hastes[0].push(i);
        }
    }

    private void mostraHastes() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Haste " + (i+1) + ": ");
            int[] elementos = hastes[i].getElements();
            for (int elemento : elementos) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    
    }

    private boolean moveDisco(int origem, int destino) {
        if (hastes[origem].isEmpty()) {
            divisor();
            System.out.println("Erro: Não tem nenhum numero na haste " + (origem+1) + "!");
            divisor();
            return false;
        } else if (!hastes[destino].isEmpty() && hastes[destino].top() < hastes[origem].top()) {
            divisor();
            System.out.println("Erro: Não é permitido colocar um numero maior sobre um numero menor!");
            divisor();
            return false;
        } else {
            hastes[destino].push(hastes[origem].pop());
            numJogadas++;
            return true;
        }
    }

    public void modoManual() {
        Scanner scanner = new Scanner(System.in);
        while (hastes[1].size() != numDiscos && hastes[2].size() != numDiscos) {
            pulaLinha();
            mostraHastes();
            pulaLinha();
            System.out.print("Digite a haste para tirar o numero (1, 2, 3): ");
            int origem = scanner.nextInt();
            System.out.print("Digite a haste para colocar o numero (1, 2, 3): ");
            int destino = scanner.nextInt();
            pulaLinha();

            if (origem < 0 || origem > 3 || destino < 0 || destino > 3) {
                divisor();
                System.out.println("Erro: numero invalido, você só tem 3 colunas");
                divisor();
                continue;
            }

            moveDisco(origem-1, destino-1);
        }
        mostraHastes();
        pulaLinha();
        divisor();
        System.out.println("Parabéns! Você concluiu o jogo em " + numJogadas + " jogadas!");
        divisor();
    }

    public void modoAuto() {
        mostraHastes();
        pulaLinha();
        resolverHanoi(numDiscos, 0, 2, 1);
        divisor();
        System.out.println("Jogo resolvido automaticamente em " + numJogadas + " jogadas!");
        divisor();
    }

    private void resolverHanoi(int n, int origem, int destino, int auxiliar) {
        if (n > 0) {
            resolverHanoi(n - 1, origem, auxiliar, destino);
            moveDisco(origem, destino);
            mostraHastes();
            pulaLinha();
            resolverHanoi(n - 1, auxiliar, destino, origem);
        }
    }

    public static void pulaLinha(){
        System.out.println();
    }

    public static void divisor(){
        System.out.println("======================//======================");
    }
}
