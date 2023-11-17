#include <bits/stdc++.h>
#include <ios>

using namespace std;

typedef long long ll;

signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    int t = 1;

    int n, m, c;
    while (true) {
        cin >> n >> m >> c;
        if(!n) break;

        n-=7; m-=7;
        cout << n * m / 2 + ((n & 1 && m & 1) ? c : 0) << '\n'; 
    }
    return 0;
}
