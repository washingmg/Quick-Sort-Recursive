import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import os

# Caminho do CSV gerado pelo Java
csv_path = "projetoPAA/src/saida_quicksort.csv"

# Lê o CSV
df = pd.read_csv(csv_path, sep=";")

# Extrai os dados
n = df["n"].values
tempos = df["tempo_ms"].values
comparacoes = df["comparacoes"].values
memoria = df["memoria_bytes"].values

# ---------- Criar pasta para salvar imagens ----------
img_dir = "projetoPAA/src/img"
os.makedirs(img_dir, exist_ok=True)

# ---------- Função para gráficos individuais ----------
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
    plt.show()  # Mostra o gráfico individualmente
    plt.close() # Fecha a figura após mostrar

# ---------- Gráficos Individuais ----------
plot_individual(n, tempos, "Tempo de Execução do QuickSort", 
                "Tamanho do Array (n)", "Tempo (ms)", 
                "grafico_tempo_log.png", "blue")

plot_individual(n, comparacoes, "Número de Comparações do QuickSort", 
                "Tamanho do Array (n)", "Comparações", 
                "grafico_comparacoes_log.png", "orange")

plot_individual(n, memoria, "Memória Usada pelo QuickSort", 
                "Tamanho do Array (n)", "Memória (bytes)", 
                "grafico_memoria_log.png", "green")

# ---------- Gráficos Comparativos em Subplots ----------
fig, axs = plt.subplots(3, 1, figsize=(12, 18))

# Tempo
axs[0].plot(n, tempos, marker='o', color='blue', label='Tempo (ms)')
axs[0].set_xscale('log')
axs[0].set_yscale('log')
axs[0].set_ylabel('Tempo (ms)')
axs[0].set_title('Tempo de Execução vs Tamanho do Array')
axs[0].grid(True, which="both", ls="--")
axs[0].legend()

# Comparações
axs[1].plot(n, comparacoes, marker='o', color='orange', label='Comparações')
axs[1].set_xscale('log')
axs[1].set_yscale('log')
axs[1].set_ylabel('Comparações')
axs[1].set_title('Comparações vs Tamanho do Array')
axs[1].grid(True, which="both", ls="--")
axs[1].legend()

# Memória
axs[2].plot(n, memoria, marker='o', color='green', label='Memória (bytes)')
axs[2].set_xscale('log')
axs[2].set_yscale('log')
axs[2].set_xlabel('Tamanho do Array (n)')
axs[2].set_ylabel('Memória (bytes)')
axs[2].set_title('Memória vs Tamanho do Array')
axs[2].grid(True, which="both", ls="--")
axs[2].legend()

plt.tight_layout()
plt.savefig(os.path.join(img_dir, "grafico_comparativo.png"))
plt.show()  # Mostra o conjunto de subplots
plt.close()
