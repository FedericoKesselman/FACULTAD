#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    int x = 0;

    while (n > 0) {
        string instruccion;
        cin >> instruccion;   // lee la palabra entera

        if (instruccion.find("++") != string::npos)
            x++;
        else if (instruccion.find("--") != string::npos)
            x--;

        n--;
    }

    cout << x << "\n";
    return 0;
}