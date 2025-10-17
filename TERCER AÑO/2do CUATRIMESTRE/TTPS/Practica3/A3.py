import sys
from collections import deque

n, m = map(int, input().split()) # lectura de n y m
g = [[] for _ in range(n + 1)] # grafo, lista de listas

for _ in range(m):
    a, b = map(int, input().split()) # lectura de aristas
    g[a].append(b) # arsta a -> b
    g[b].append(a) # arista b -> a

visitados = [False] * (n + 1) # nodos visitados
representantes = [] # representante de cada componente. es el primer visitado

def bfs(inicio):
    q = deque([inicio]) # inicializa cola con nodo inicio
    visitados[inicio] = True
    while q: # mientras la cola no este vacia
        u = q.popleft() # desencola
        for v in g[u]: # vecinos de u 
            if not visitados[v]: 
                visitados[v] = True
                q.append(v)

for i in range(1, n+1):
    if not visitados[i]:
        representantes.append(i) # primero del componente
        bfs(i) # recorrido a partir de ese nodo

print(len(representantes)-1) # cantidad de rutas requeridas
for i in range(1, len(representantes)):
    print(representantes[i], representantes[i-1])