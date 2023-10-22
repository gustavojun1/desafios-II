#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

char image[30][30];

void dfs(int i, int j) {
    // verifica o adjacente acima e à esquerda
  int x = i-1, y = j-1; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   } 
    // verifica o adjacente imediatamente acima
  x = i-1, y = j; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   } 
    // verifica o adjacente acima e à direita
  x = i-1, y = j+1; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   } 
    // verifica o adjacente imediatamente à esquerda
  x = i, y = j-1; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   } 
    // verifica o adjacente imediatamente à direita
  x = i, y = j+1; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   }   
    // verifica o adjacente abaixo e à esquerda
  x = i+1, y = j-1; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   }   
    // verifica o adjacente imediatamente abaixo
  x = i+1, y = j; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   } 
    // verifica o adjacente abaixo e à direita
   x = i+1, y = j+1; 
   if (image[x][y] == '1') {
     image[x][y] = '0';
     dfs(x, y); 
   } 
}

signed main() {
	ios_base::sync_with_stdio(0); cin.tie(0);

	int n, count = 1;

	while (cin >> n) {
		int ans = 0;
		memset(image, 0, sizeof image);

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				cin >> image[i][j];
			}
		}
    
		for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (image[i][j] == '1') {
          dfs(i, j);
          ++ans;
        }
      }
    }

		cout << "Image number " << count++ << " contains " << ans << " war eagles.\n";
	}
	return 0;
}
