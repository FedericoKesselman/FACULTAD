import sys 

class DSU:
    def __init__(self, n):
        self.link = [0] * n # padre de cada nodo
        self.sz = [1] * n # tamano de cada componente
        for i in range(n):
            self.link[i] = i # cada nodo es su propio padre
    
    def getlink(self, x):
        if self.link[x] != x: # no es su propio padre
            self.link[x] = self.getlink(self.link[x]) # path compression
        return self.link[x] 
    
    def union(self, x, y):
        x = self.getlink(x) # padre de x
        y = self.getlink(y) # padre de y 
        if x != y: # si no forman parte de la misma componente
            if self.sz[x] < self.sz[y]: # se invierten si es mas chico
                x, y = y, x # x es la componente mas grande
            self.link[y] = x
            self.sz[x] += self.sz[y]
        return self.sz[x]
    

n, m = map(int, sys.stdin.readline().split())
dsu = DSU(n)
size = 1

for _ in range(m):
    a,b = map(int, sys.stdin.readline().split())
    a -= 1
    b -= 1
    if dsu.getlink(a) != dsu.getlink(b):
        n -= 1 # se reduce porque se van a conectar
    size = max(size, dsu.union(a,b)) # maximo entre size y compoennte mas grande 
    sys.stdout.write(f"{n} {size}\n")
# por cada dia imprime la cantidad de componentes conexas y la cant de nodos del componente mas grande 