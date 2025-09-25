# Projeto PAA: Análise do QuickSort Recursivo em Java

_Este trabalho acadêmico foi desenvolvido por estudantes do curso de Ciência da Computação da Universidade Federal de Alagoas (UFAL), Campus Arapiraca, com o objetivo de atender aos requisitos da disciplina de Projeto e Análise de Algoritmos, ministrada pelo docente Alexandre Paes. O projeto explora o algoritmo QuickSort de forma recursiva, apresentando tanto os conceitos teóricos quanto sua aplicação prática. Para isso, o trabalho inclui explicações detalhadas sobre o funcionamento do algoritmo, imagens ilustrativas, trechos de código, gráficos de desempenho e análises comparativas, proporcionando uma compreensão completa de seu comportamento e eficiência em diferentes cenários._  

**Palavras-chaves:** `quick sort`, `análise de algoritmos`, `análises comparativas`, `computação`

---

## 📌 Descrição

Este projeto implementa o **QuickSort recursivo** em Java e realiza uma análise de desempenho em termos de:

- ⏱ **Tempo de execução** (ms)  
- 📊 **Número de comparações** realizadas  
- 💾 **Memória utilizada** (bytes)  

O projeto gera:

- Uma **tabela no terminal** com os resultados  
- Um **arquivo CSV (`saida_quicksort.csv`)** com os dados, permitindo a criação de gráficos de desempenho em Python usando Matplotlib.

O QuickSort é um algoritmo de ordenação eficiente baseado em **dividir e conquistar**, e este projeto permite avaliar seu comportamento para diferentes tamanhos de arrays aleatórios.

---

## 📁 Estrutura do Projeto

    src/
        QuickSortAnalysis.java # Programa principal que executa testes e gera CSV
        QuickSort.java # Implementação do QuickSort recursivo
        ArrayGenerator.java # Geração de arrays aleatórios
        graph_generator # Criação dos gráficos
        saida_quicksort.csv # Arquivo gerado com resultados dos testes
        img/ # Diretório para armazenar gráficos gerados em Python
---

## 🗂 Estrutura do CSV

O arquivo `saida_quicksort.csv` tem o seguinte formato:

| Coluna          | Descrição                               |
|-----------------|----------------------------------------|
| `n`             | Tamanho do array                        |
| `tempo_ms`      | Tempo de execução em milissegundos      |
| `comparacoes`   | Número total de comparações             |
| `memoria_bytes` | Memória utilizada pelo array (bytes)    |

> ⚠️ **Observação:** Arrays muito grandes (ex.: 99.999.999 elementos) podem causar `OutOfMemoryError` dependendo da memória da máquina.

---

## 📈 Visualização de Dados

- Os gráficos usam **escala logarítmica (log-log)** para melhor visualização dos dados em diferentes ordens de magnitude.  
- A análise permite entender como o QuickSort se comporta em termos de **complexidade de tempo**, **comparações realizadas** e **uso de memória**.

---

# 📌 Explicação do Código - Quick Sort em Java

Este projeto contém três classes principais que, juntas, geram arrays aleatórios, aplicam o algoritmo **Quick Sort recursivo** e analisam seu desempenho.

---

## 🔹 `ArrayGenerator.java`
Classe responsável por **gerar arrays aleatórios** para os testes.

- **`generateRandomArray(int n)`**  
  - Cria um array de tamanho `n`.  
  - Usa a classe `Random` para preencher cada posição com números inteiros aleatórios no intervalo `[0, 100000)`.  
  - Retorna o array preenchido.  

---

## 🔹 `QuickSort.java`
Classe que implementa o algoritmo **Quick Sort recursivo** com contagem de comparações.

- **Classe interna `Counter`**  
  - Possui o atributo `count`.  
  - É usada para armazenar e atualizar o número de comparações feitas durante a ordenação.  

- **`sort(int[] arr)`**  
  - Verifica se o array é nulo ou vazio.  
  - Cria um objeto `Counter` para iniciar a contagem de comparações.  
  - Chama o método recursivo `quickSortRecursive`.  
  - Retorna o total de comparações realizadas.  

- **`quickSortRecursive(int[] arr, int low, int high, Counter comparisons)`**  
  - Implementa a recursividade do Quick Sort.  
  - Chama o método `partition` para dividir o array em duas partes (antes e depois do pivô).  
  - Ordena recursivamente as duas partes.  

- **`partition(int[] arr, int low, int high, Counter comparisons)`**  
  - Define o **pivô** como o último elemento do subarray.  
  - Percorre o array comparando cada elemento com o pivô.  
  - Se um elemento for menor ou igual ao pivô, ele é trocado de posição para ficar à esquerda.  
  - Retorna a posição final do pivô após as trocas.  

- **`swap(int[] arr, int i, int j)`**  
  - Função auxiliar que troca os elementos de posição no array.  

---

## 🔹 `QuickSortAnalysis.java`
Classe responsável por **executar os testes de desempenho** do Quick Sort.

- **`main(String[] args)`**  
  - Define diferentes tamanhos de arrays no vetor `nValues`.  
  - Para cada tamanho `n`:  
    1. Gera um array aleatório com `ArrayGenerator`.  
    2. Mede o tempo inicial e final da execução usando `System.nanoTime()`.  
    3. Executa o Quick Sort e captura o número de comparações.  
    4. Calcula o tempo em milissegundos (`executionTimeMs`).  
    5. Estima o uso de memória em bytes (`memoria_bytes`).  
    6. Mostra os resultados formatados em uma tabela no console.  
    7. Salva os resultados em um arquivo CSV (`saida_quicksort.csv`).  

- **Saída no console**  
  Exibe uma tabela com:
  - Tamanho do array (`n`)  
  - Tempo de execução (ms)  
  - Número de comparações  
  - Memória utilizada (bytes)  

# Análise Gráfica do Desempenho do QuickSort em Python

O código realiza a leitura de métricas de desempenho do QuickSort a partir de um arquivo CSV gerado em Java, cria gráficos individuais e comparativos, e salva as imagens para análise.

---

## 🔹 Importação de Bibliotecas

- **pandas**: leitura e manipulação do CSV.  
- **matplotlib.pyplot**: criação e visualização de gráficos.  
- **numpy**: suporte a arrays numéricos.  
- **os**: manipulação de diretórios e caminhos de arquivos.  

---


🔹 Leitura do CSV
      csv_path = "projetoPAA/src/saida_quicksort.csv"
      df = pd.read_csv(csv_path, sep=";")

Define o caminho do CSV gerado pelo Java.
Lê os dados usando pandas com separador ;.

🔹 Extração das Métricas
      n = df["n"].values
      tempos = df["tempo_ms"].values
      comparacoes = df["comparacoes"].values
      memoria = df["memoria_bytes"].values


Converte cada coluna do CSV em arrays NumPy:
n: tamanho dos arrays testados.
tempos: tempo de execução em milissegundos.
comparacoes: número de comparações realizadas.
memoria: memória utilizada em bytes.

  🔹 Criação de Diretório para Salvar Imagens
        img_dir = "projetoPAA/src/img"
        os.makedirs(img_dir, exist_ok=True)


Cria a pasta img dentro de src.
exist_ok=True evita erro se a pasta já existir.

  🔹 Função para Gráficos Individuais

        def plot_individual(x, y, title, xlabel, ylabel, filename, color):
            plt.figure(figsize=(10,6))
            plt.plot(x, y, marker='o', linestyle='-', color=color)
            plt.title(title)
            plt.xlabel(xlabel)
            plt.ylabel(ylabel)
            plt.xscale('log')
            plt.yscale('log')
            plt.grid(True, which="both", ls="--")
            plt.savefig(os.path.join(img_dir, filename))
            plt.show()
            plt.close()


Cria um gráfico individual com:

    Pontos (marker='o') e linha (linestyle='-').

Títulos e rótulos dos eixos.
Escala log-log para melhor análise de crescimento exponencial.
Grid com linhas tracejadas.
Salva o gráfico na pasta img e mostra na tela.

    🔹 Criação de Gráficos Individuais
        plot_individual(n, tempos, "Tempo de Execução do QuickSort", "Tamanho do Array (n)", "Tempo (ms)", "grafico_tempo_log.png", "blue")
        plot_individual(n, comparacoes, "Número de Comparações do QuickSort", "Tamanho do Array (n)", "Comparações", "grafico_comparacoes_log.png", "orange")
        plot_individual(n, memoria, "Memória Usada pelo QuickSort", "Tamanho do Array (n)", "Memória (bytes)", "grafico_memoria_log.png", "green")


Gera três gráficos individuais, cada um representando:

Tempo de execução.
Número de comparações.
Memória utilizada.

🔹 Gráfico Comparativo com Subplots
    fig, axs = plt.subplots(3, 1, figsize=(12, 18))


    Cria uma figura com 3 subplots verticais, permitindo comparar todas as métricas lado a lado.

  🔹 Configuração de Cada Subplot

    Tempo de Execução

        axs[0].plot(n, tempos, marker='o', color='blue', label='Tempo (ms)')
        axs[0].set_xscale('log')
        axs[0].set_yscale('log')
        axs[0].set_title('Tempo de Execução vs Tamanho do Array')
        axs[0].set_ylabel('Tempo (ms)')
        axs[0].grid(True, which="both", ls="--")
        axs[0].legend()


    Número de Comparações

        axs[1].plot(n, comparacoes, marker='o', color='orange', label='Comparações')
        axs[1].set_xscale('log')
        axs[1].set_yscale('log')
        axs[1].set_title('Comparações vs Tamanho do Array')
        axs[1].set_ylabel('Comparações')
        axs[1].grid(True, which="both", ls="--")
        axs[1].legend()


    Memória Utilizada

        axs[2].plot(n, memoria, marker='o', color='green', label='Memória (bytes)')
        axs[2].set_xscale('log')
        axs[2].set_yscale('log')
        axs[2].set_title('Memória vs Tamanho do Array')
        axs[2].set_xlabel('Tamanho do Array (n)')
        axs[2].set_ylabel('Memória (bytes)')
        axs[2].grid(True, which="both", ls="--")
        axs[2].legend()


Cada subplot possui título, labels, legenda, grid e escala log-log.

  🔹 Salvamento e Exibição do Gráfico Comparativo
      plt.tight_layout()
      plt.savefig(os.path.join(img_dir, "grafico_comparativo.png"))
      plt.show()
      plt.close()


Ajusta automaticamente o layout (tight_layout) para evitar sobreposição.
Salva o gráfico comparativo em img/grafico_comparativo.png.
Mostra o gráfico e fecha a figura para liberar memória
