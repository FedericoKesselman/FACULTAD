import heapq # cola de prioridades

n, m = map(int, input().split()) # lectura de n y m
g = [[] for _ in range(n + 1)] # grafo, lista de listas

for _ in range(m):
    a, b, c = map(int, input().split()) # lectura de aristas y el peso 
    g[a].append((b, c)) # grafo dirigido, por eso no es agregado en b. tupla de destino y peso

# inicialización
INF = 10**15
dist = [INF] * (n + 1)
dist[1] = 0  # distancia desde 1 a 1 es 0

q = [(0, 1)]  # cola de prioridad (min-heap)

while q:
    d, u = heapq.heappop(q)
    if d > dist[u]:
        continue # ya procesado con distancia menor 
    for v, w in g[u]: # vecino, weight
        if dist[u] + w < dist[v]: # si la distancia es menor a la que tenia actualizo
            dist[v] = dist[u] + w
            heapq.heappush(q, (dist[v], v))

# mostrar resultado
for i in range(1, n + 1):
    print(dist[i], end=" ")
print()
