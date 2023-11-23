#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

signed main() {
	ios_base::sync_with_stdio(0); cin.tie(0);

	while (true) {
		int n; cin >> n;

		if (!n) break;

		int grid[n];

		memset(grid, 0, sizeof grid);

		bool constructable = true;

		for (int i = 0; i < n; ++i) {
			int c, p; cin >> c >> p;

			if (i+p < 0 || i + p >= n || grid[i+p]) constructable = false;
			else grid[i+p] = c;
		}

		if (!constructable) cout << "-1\n";
		else {
			for (int i = 0; i < n; ++i) {
				cout << grid[i];
				if (i < n-1) cout << ' ';
			}
			cout << '\n';
		}
	}

	return 0;
}
