import sys

n, m = map(int, input().split()) # lectura de n y m
g = [[] for _ in range(n + 1)] # grafo, lista de listas

for _ in range(m):
    a, b = map(int, input().split()) # lectura de aristas
    g[a].append(b) # arsta a -> b
    g[b].append(a) # arista b -> a