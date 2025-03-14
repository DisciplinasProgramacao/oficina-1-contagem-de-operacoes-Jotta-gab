import matplotlib.pyplot as plt

# Dados dos algoritmos
dados = {
    "codigo1": [(250000, 8.602), (500000, 2.077), (1000000, 23.516), (1500000, 5.814), (2500000, 6.640), (5000000, 25.952)],
    "codigo2": [(250000, 19.002), (500000, 42.134), (1000000, 0.0), (1500000, 0.0), (2500000, 0.0), (5000000, 0.0)],
    "codigo3": [(12500, 441.698), (25000, 551.460), (50000, 1622.897), (100000, 4068.143), (200000, 20116.013)],
    "codigo4": [(3, 0.003), (6, 0.002), (12, 0.073), (24, 1.200), (48, 45505.883)]
}

# Gerar gráficos
for algoritmo, valores in dados.items():
    tamanhos, tempos = zip(*valores)
    plt.figure()
    plt.plot(tamanhos, tempos, marker='o', label=f'{algoritmo} - Tempo (ms)')
    plt.title(f'Desempenho do {algoritmo}')
    plt.xlabel('Tamanho da Entrada')
    plt.ylabel('Tempo de Execução (ms)')
    plt.grid(True)
    plt.legend()
    plt.show()
