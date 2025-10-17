from collections import deque

n, m = map(int, input().split()) # lectura de n y m
g = [[] for _ in range(n + 1)] # grafo, lista de listas

for _ in range(m):
    a, b = map(int, input().split()) # lectura de aristas
    g[a].append(b) # arsta a -> b
    g[b].append(a) # arista b -> a

dist = [-1] * (n + 1) # distancia minima
prev = [0] * (n + 1) # padre

q = deque([1]) # cola inicializada para bfs
dist[1] = 0 # distancia al nodo 1 es 0

while q: 
    u = q.popleft() # nodo actual
    for v in g[u]: # para cada vecino
        if dist[v] == -1: # si no fue visitado
            dist[v] = dist[u] + 1 # distancia 
            prev[v] = u # padre
            q.append(v) # agregar a la cola

if dist[n] == -1: # si no se llego al nodo n
    print("IMPOSSIBLE")
else:
    path = []
    x = n
    while x:
        path.append(x)
        x = prev[x]
    path.reverse()
    print(len(path))
    print(*path)
