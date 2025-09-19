#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    int pos;
    bool pares;

    int cantPares = 0;
    int cantImpares = 0;

    vector<int> lista(n);
    for (int i = 0; i < n; i++) { // guardar elementos en lista
        cin >> lista[i];
    }

    for (int i = 0; i < 3; i++) { // saber si es lista de pares o impares
        if (lista[i] % 2 == 0)
            cantPares++;
        else
            cantImpares++;
    }

    if (cantPares > cantImpares)
        pares = true;
    else 
        pares = false;

    for (int i = 0; i < n; i++) { // buscar al numero incorrecto
        if (pares) {
            if (lista[i] % 2 != 0) {
                pos = i+1; 
                break;
            }
        }
        else {
            if (lista[i] % 2 == 0) {
                pos = i+1; 
                break;
            }
        }
    }

    cout << pos << "\n";
    return 0;
}