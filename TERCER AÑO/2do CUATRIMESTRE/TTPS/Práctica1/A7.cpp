#include <bits/stdc++.h>
using namespace std;

int main() {
    string word;
    cin >> word;

    string resultado = "";
    string vocales = "aeiouy";

    for (char c: word) {
        c = tolower(c);
        if (vocales.find(c) == string::npos) { // la palabra NO esta en vocales
            resultado.push_back('.');
            resultado.push_back(c);
        }
    }
    
    cout << resultado << "\n";
    return 0;
}