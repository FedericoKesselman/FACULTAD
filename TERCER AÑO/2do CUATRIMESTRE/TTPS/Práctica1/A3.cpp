#include <bits/stdc++.h>
using namespace std;
int main() {
    int n;
    cin >> n;
    
    int cant = 0;

    while (n>0) {
        int a, b, c;
        cin >> a >> b >> c;

        if ((a+b+c) >= 2)
            cant++;

        n--;
    }

    cout << cant << "\n";
    return 0;
}