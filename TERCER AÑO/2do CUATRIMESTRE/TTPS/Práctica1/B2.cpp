#include <bits/stdc++.h>
using namespace std;

int main() {
    int A, B, C;
    cin >> A >> B >> C;
    char answer;
    int cambio = B-A; 

    if (cambio % C == 0)
        answer = 'S';
    else
        answer = 'N';

    cout << answer << "\n";
    return 0;
}