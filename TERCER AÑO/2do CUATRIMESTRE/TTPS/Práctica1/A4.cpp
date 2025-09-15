#include <bits/stdc++.h>
using namespace std;
int main() {
    long long n, m, a;
    cin >> n >> m >> a;
    
    long long flag_n = (n + a - 1) / a;
    long long flag_m = (m + a - 1) / a;
    long long total = (flag_n * flag_m);
    cout << total;
}