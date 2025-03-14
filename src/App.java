import java.util.Random;

public class App {
    static int[] tamanhosTesteGrande = {500_000, 1_000_000, 2_000_000, 3_000_000, 5_000_000, 10_000_000};
    static int[] tamanhosTesteMedio = {12_500, 25_000, 50_000, 100_000, 200_000};
    static int[] tamanhosTestePequeno = {3, 6, 12, 24, 48};

    static Random aleatorio = new Random(42);

    static int codigo1(int[] vetor) {
        int resposta = 0;
        int operacoes = 0;
        long inicio = System.nanoTime();

        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
            operacoes++;
        }

        long fim = System.nanoTime();
        System.out.printf("codigo1 - Operações: %d | Tempo: %.3f ms\n", operacoes, (fim - inicio) / 1e6);
        return resposta;
    }

    static int codigo2(int[] vetor) {
        int contador = 0;
        int operacoes = 0;
        long inicio = System.nanoTime();

        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
                operacoes++;
            }
        }

        long fim = System.nanoTime();
        System.out.printf("codigo2 - Operações: %d | Tempo: %.3f ms\n", operacoes, (fim - inicio) / 1e6);
        return contador;
    }

    static int codigo3(int[] vetor) {
        int operacoes = 0;
        long inicio = System.nanoTime();

        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
                operacoes++;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
            operacoes += 3;
        }

        long fim = System.nanoTime();
        System.out.printf("codigo3 - Operações: %d | Tempo: %.3f ms\n", operacoes, (fim - inicio) / 1e6);
        return 0;
    }

    static int codigo4(int n) {
        int[] operacoes = {0};  // Array para manter referência dentro da recursão
        long inicio = System.nanoTime();
        int resultado = codigo4Recursivo(n, operacoes);
        long fim = System.nanoTime();
        System.out.printf("codigo4 - Operações: %d | Tempo: %.3f ms\n", operacoes[0], (fim - inicio) / 1e6);
        return resultado;
    }

    static int codigo4Recursivo(int n, int[] operacoes) {
        operacoes[0]++;
        if (n <= 2)
            return 1;
        else
            return codigo4Recursivo(n - 1, operacoes) + codigo4Recursivo(n - 2, operacoes);
    }

    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        }
        return vetor;
    }

    public static void main(String[] args) {
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            codigo1(vetor);
            codigo2(vetor);
        }

        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);
            codigo3(vetor);
        }

        for (int tamanho : tamanhosTestePequeno) {
            codigo4(tamanho);
        }
    }
}
