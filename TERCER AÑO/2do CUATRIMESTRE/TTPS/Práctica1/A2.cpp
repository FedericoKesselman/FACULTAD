#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    while (n>0) {
        string palabra;
        cin >> palabra;

        if (palabra.length() > 10) 
            cout << palabra.front() << palabra.length()-2 << palabra.back() << "\n";
        else
            cout << palabra << "\n";

        n--;
    }
}