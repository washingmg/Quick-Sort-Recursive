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