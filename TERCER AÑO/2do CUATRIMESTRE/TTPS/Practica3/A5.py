import heapq # cola de prioridades

# Algoritmo Kruskal
class DSU:
    def __init__(self, n):
        self.parent = [i for i in range(n + 1)] # cada nodo es su representante
        self.size = [1] * (n + 1) # tamano en 1 

    def find(self, x):
        if self.parent[x] != x: # si no es el mismo 
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y): # path compression
        x = self.find(x)
        y = self.find(y)
        if x == y: return False # misma componente
        if self.size[x] < self.size[y]:
            x,y = y,x
        self.parent[y] = x
        self.size[x] += self.size[y]
        return True 

n, m = map(int, input().split()) # lectura de n y m
g = [tuple(map(int, input().split())) for _ in range(m)] # lectura
g.sort(key=lambda x: x[2]) # ordenar aristas por costos

dsu = DSU(n)

peso = 0
aristas = 0

for x,y,w in g:
    if dsu.union(x,y): # si hubo que unirlas 
        peso += w
        aristas += 1
    if aristas == n-1:
        break # ya estan todos conectados

if aristas == n-1:
    print(peso)
else:
    print("IMPOSSIBLE")


## Time limit, este anduvo 

import sys
input = sys.stdin.readline
write = sys.stdout.write

# Algoritmo Kruskal optimizado para PyPy
class DSU:
    __slots__ = ("p", "s")                     # evita diccionario interno
    def __init__(self, n):
        self.p = list(range(n + 1))
        self.s = [1] * (n + 1)

    def find(self, x):
        p = self.p
        while p[x] != x:
            p[x] = p[p[x]]                     # path compression
            x = p[x]
        return x

    def union(self, a, b):
        p, s = self.p, self.s
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return False
        if s[a] < s[b]:
            a, b = b, a
        p[b] = a
        s[a] += s[b]
        return True


n, m = map(int, input().split())
edges = [None] * m                            # prealoco la lista
for i in range(m):
    a, b, c = map(int, input().split())
    edges[i] = (c, a, b)                      # (peso, nodo1, nodo2)

edges.sort()                                  # orden por peso

dsu = DSU(n)
peso = 0
usadas = 0
u = dsu.union                                 # alias local para evitar lookups

for w, a, b in edges:
    if u(a, b):
        peso += w
        usadas += 1
        if usadas == n - 1:
            break

if usadas == n - 1:
    write(str(peso))
else:
    write("IMPOSSIBLE")