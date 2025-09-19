#include <bits/stdc++.h>
using namespace std;

int main() {
    string word;
    cin >> word;
    int cant = 0;

    string resultado = "";
    string vocales = "aeiouy";

    for (char c: word) {
        if (c.find("T"))

    }
    
    cout << resultado << "\n";
    return 0;
}

if (vocales.find(c) == string::npos) { // la palabra NO esta en vocales
    resultado.push_back('.');
    resultado.push_back(c);
}