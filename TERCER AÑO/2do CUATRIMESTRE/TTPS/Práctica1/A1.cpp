#include <bits/stdc++.h>
using namespace std;

int main() {
    int pesoSandia;
    cin >> pesoSandia; 

    if (pesoSandia % 2 == 0 && pesoSandia != 2)
        cout << "YES";
    else
        cout << "NO";
      
    return 0;
}