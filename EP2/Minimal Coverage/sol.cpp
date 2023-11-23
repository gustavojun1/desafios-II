#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

pair <int, int> p[100010];

void solve() {
	int m; cin >> m;
	int i = 0;

	while (true) {
		int l, r; cin >> l >> r;
		if (!l && !r) break;

		if (r <= 0 || l >= m) continue;

		p[i++] = make_pair(l, r);
	}

	int n = i;

	sort(p, p + n, [](pair<int, int>&l, pair<int, int>&r) {
			return l.first < r.first;
			});

	int covered = 0;
	vector <pair<int, int>> ans;

	for (i = 0; i < n && covered < m; ++i) {
		if (p[i].second < covered) continue;
		if (p[i].first > covered) break;
		int maxR = 0;
		int maxId;
		for (int j = i; j < n && p[j].first <= covered; ++j) {
			if (p[j].second > maxR) {
				maxR = p[j].second;
				maxId = j;
			}
		}
		covered = maxR;
		ans.push_back(p[maxId]);
	}

	if (covered >= m) {
		cout << ans.size() << '\n';
		for (auto x : ans) {
			cout << x.first << ' ' << x.second << '\n';
		}
		cout << '\n';
	} else cout << "0\n\n";

}

signed main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int t = 1;

	cin >> t;
	while (t--) solve();

	return 0;
}