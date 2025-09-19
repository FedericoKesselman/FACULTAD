#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    vector<int> lista(n);
    for (int i = 0; i < n; i++) {
        cin >> lista[i];
    }

    int puntaje = lista[k - 1]; // el puntaje del k-ésimo lugar
    int cant = 0;

    for (int i = 0; i < n; i++) {
        if (lista[i] >= puntaje && lista[i] > 0)
            cant++;
    }

    cout << cant << "\n";
    return 0;
}