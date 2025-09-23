public class QuickSort {

    // Classe interna usada para manter o contador de comparações.
    // É uma classe estática para permitir a passagem por referência.
    static class Counter {
        long count = 0; // Armazena o número total de comparações realizadas
    }

    /**
     * Função principal que inicia o algoritmo Quick Sort.
     * Ela cria um contador e chama a função recursiva.
     *
     * @param arr O array a ser ordenado.
     * @return O número total de comparações realizadas durante a ordenação.
     */
    public static long sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // Retorna 0 se o array for nulo ou vazio
        }
        Counter comparisons = new Counter(); // Cria um contador para rastrear comparações
        quickSortRecursive(arr, 0, arr.length - 1, comparisons); // Chama a função recursiva
        return comparisons.count; // Retorna o número total de comparações realizadas
    }

    /**
     * Função recursiva que implementa o Quick Sort.
     *
     * @param arr O array a ser ordenado
     * @param low Índice inicial do subarray
     * @param high Índice final do subarray
     * @param comparisons Contador de comparações, passado por referência
     */
    private static void quickSortRecursive(int[] arr, int low, int high, Counter comparisons) {
        if (low < high) {
            // Particiona o array e retorna a posição do pivô
            int pi = partition(arr, low, high, comparisons);

            // Ordena recursivamente os elementos antes e depois do pivô
            quickSortRecursive(arr, low, pi - 1, comparisons);
            quickSortRecursive(arr, pi + 1, high, comparisons);
        }
    }

    /**
     * Particiona o array em torno do pivô.
     * Elementos menores ou iguais ao pivô vão para a esquerda,
     * e os maiores para a direita.
     *
     * @param arr O array a ser particionado
     * @param low Índice inicial do subarray
     * @param high Índice final do subarray (pivô)
     * @param comparisons Contador de comparações, passado por referência
     * @return A posição final do pivô no array
     */
    private static int partition(int[] arr, int low, int high, Counter comparisons) {
        int pivot = arr[high]; // Escolhe o último elemento como pivô
        int i = (low - 1); // Índice do menor elemento

        // Percorre o array e compara cada elemento com o pivô
        for (int j = low; j < high; j++) {
            comparisons.count++; // Incrementa o contador de comparações
            if (arr[j] <= pivot) {
                i++; // Move o índice do menor elemento
                swap(arr, i, j); // Troca elementos para colocar o menor à esquerda
            }
        }

        // Coloca o pivô na posição correta
        swap(arr, i + 1, high);
        return i + 1; // Retorna a posição do pivô
    }

    /**
     * Troca dois elementos no array.
     *
     * @param arr O array onde ocorrerá a troca
     * @param i Índice do primeiro elemento
     * @param j Índice do segundo elemento
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // Armazena temporariamente o valor de arr[i]
        arr[i] = arr[j]; // Atribui arr[j] a arr[i]
        arr[j] = temp; // Atribui o valor temporário a arr[j]
    }
}
