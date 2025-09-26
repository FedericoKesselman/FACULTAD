#include <bits/stdc++.h>
using namespace std;

int main() {
    string word;
    cin >> word;
    int cant = 0;

    char answer = 'N';

    for (char c: word) {
        if (c == 'T' && cant==0)
            cant++;
        else if (c == 'A' && cant==1)
            cant++; 
        else if (c == 'P' && cant==2)
            cant++; 
    }

    if (cant == 3)
        answer = 'S';
    
    cout << answer << "\n";
    return 0;
}