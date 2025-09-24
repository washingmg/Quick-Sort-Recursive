import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QuickSortAnalysis {

    public static void main(String[] args) {
        // Lista de tamanhos de arrays para teste
        int[] nValues = {10, 50, 100, 500, 1000, 5000, 10000, 20000, 50000, 100000, 200000, 500000, 1000000, 99999999};

        // Imprime cabeçalho da tabela no terminal
        System.out.println("### Tabela de Desempenho do Quick Sort Recursivo (Java)\n");
        System.out.println("### Esperar o programa concluir a execução para gerar os gráficos\n");
        System.out.println("| Tamanho da Entrada (n)   | Tempo (ms)   | Comparações   | Memória (bytes)  |");
        System.out.println("|--------------------------|--------------|---------------|------------------|");

        try {
            // Cria a pasta "projetoPAA/src" se não existir
            File pastaSrc = new File("projetoPAA/src");
            if (!pastaSrc.exists()) {
                pastaSrc.mkdirs(); 
            }

            // Define o arquivo CSV que armazenará os resultados
            File arquivoCSV = new File(pastaSrc, "saida_quicksort.csv");

            // Cria o PrintWriter para escrever no CSV
            try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoCSV))) {

                // Escreve cabeçalho do CSV
                writer.println("n;tempo_ms;comparacoes;memoria_bytes");

                // Loop principal: executa QuickSort para cada tamanho de array
                for (int n : nValues) {
                    // Gera um array aleatório de tamanho n
                    int[] testArray = ArrayGenerator.generateRandomArray(n);

                    // Mede o tempo de execução do QuickSort
                    long startTime = System.nanoTime();
                    long numComparisons = QuickSort.sort(testArray); // Retorna número de comparações
                    long endTime = System.nanoTime();

                    // Calcula memória usada pelo array (int = 4 bytes)
                    long memoryUsed = testArray.length * Integer.BYTES;

                    // Converte tempo de execução de nanosegundos para milissegundos
                    double executionTimeMs = (endTime - startTime) / 1_000_000.0;

                    // Imprime resultados no terminal (formato tabela)
                    System.out.printf("| %-22d   | %-10.4f   | %-11d   | %-14d   |\n",
                            n, executionTimeMs, numComparisons, memoryUsed);

                    // Escreve resultados no CSV
                    writer.printf("%d;%.4f;%d;%d\n", n, executionTimeMs, numComparisons, memoryUsed);

                    // Intervalo de 0,5 segundos entre cada execução
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Execução interrompida!");
                    }
                }
            }

            // Mensagem final indicando onde o CSV foi salvo
            System.out.println("\nArquivo CSV gerado em: " + arquivoCSV.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
