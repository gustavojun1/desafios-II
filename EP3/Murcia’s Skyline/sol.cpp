#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

void solve() {
  int n; cin >> n;

  int dplis[n], dplds[n];
  int width[n], height[n];

  for (int i = 0; i < n; ++i) {
    cin >> height[i];
  }
  for (int i = 0; i < n; ++i) {
    cin >> width[i];
    dplis[i] = dplds[i] = width[i];
  }

  for (int i = 0; i < n; ++i) 
    for (int j = i+1; j < n; ++j) {
      if (height[i] < height[j] && dplis[i] + width[j] > dplis[j])
        dplis[j] = dplis[i] + width[j];
      if (height[i] > height[j] && dplds[i] + width[j] > dplds[j])
        dplds[j] = dplds[i] + width[j];
    }

  int lis = 0, lds = 0;
  lis = *max_element(dplis, dplis+n);
  lds = *max_element(dplds, dplds+n);

  if (lis >= lds) {
    cout << "Increasing (" << lis << "). Decreasing (" << lds << ").\n";
  } else {
    cout << "Decreasing (" << lds << "). Increasing (" << lis << ").\n";
  }
}

signed main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
  int t = 1;

  cin >> t;
  for (int i =1; i <= t; ++i) {
    cout << "Case " << i << ". ";
    solve();
  }

  return 0;
}
