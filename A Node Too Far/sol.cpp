#include <bits/stdc++.h>

using namespace std;

unordered_multimap <int, int> arestas;
unordered_set <int> vertices;

// BFS
int solve(int node, int ttl) {
  unordered_map<int, bool> visited;
  unordered_map <int, int> dist;

  queue<int> queue;
  unordered_set<int> notTooFar;

  visited[node] = true;
  queue.push(node);
  dist[node] = 0;
  notTooFar.insert(node);

  while(!queue.empty()){
    node = queue.front();
    queue.pop();

    auto range = arestas.equal_range(node);

    for (auto i = range.first; i != range.second; ++i) {
      if(!visited[i->second]) {
        visited[i->second] = true;
        queue.push(i->second);
        dist[i->second] = dist[node] + 1;
        if(dist[i->second] <= ttl) notTooFar.insert(i->second);
      }
    }
  }

  return vertices.size() - notTooFar.size();
}

signed main() {
  int case_num = 1;
  while (true) {
    vertices.clear();
    arestas.clear();
    int nc; cin >> nc;
    if (nc == 0)
      return 0;
    for (int i = 0; i < nc; ++i) {
      int x, y;
      cin >> x >> y;
      arestas.insert({x, y});
      arestas.insert({y, x});
      vertices.insert(x);
      vertices.insert(y);
    }
    while (true) {
      int x, y;
      cin >> x >> y;
      if (x == 0 && y == 0) break;
      cout << "Case " << case_num << ": " << solve(x, y) << " nodes not reachable from node " << x << " with TTL = " << y << ".\n";
      ++case_num;
    }

  }
}