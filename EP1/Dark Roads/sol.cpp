#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

class Road {
public:
    int length;
    int start_junction;
    int next_junction;

    Road(int length, int start_junction, int next_junction) : length(length), start_junction(start_junction), next_junction(next_junction) {}

    int getLength() const {
        return length;
    }
};

vector<int> pai(200000);
vector<int> rankNode(200000);

vector<int> receiveNextLine() {
    string line;
    getline(cin, line);
    vector<int> current_nums(3);
    stringstream ss(line);
    for (int i = 0; i < 3; i++) {
        ss >> current_nums[i];
    }
    return current_nums;
}

void makeSet(int x) {
    pai[x] = x;
    rankNode[x] = 0;
}

int find_set(int x) {
    if (pai[x] == x) {
        return x;
    }
    return pai[x] = find_set(pai[x]);
}

void link(int x, int y) {
    if (rankNode[x] >= rankNode[y]) {
        pai[y] = x;
        if (rankNode[x] == rankNode[y]) {
            ++rankNode[x];
        }
    } else {
        pai[x] = y;
    }
}

void union_sets(int x, int y) {
    int x_root = find_set(x);
    int y_root = find_set(y);
    if (x_root != y_root) {
        link(x_root, y_root);
    }
}

int main() {
    while (true) {
        vector<int> current_nums = receiveNextLine();
        if (current_nums[0] == 0 && current_nums[1] == 0) {
            break;
        }
        int num_junctions = current_nums[0];
        int num_roads = current_nums[1];

        int total_weight = 0;
        vector<Road> roads;
        for (int i = 0; i < num_roads; i++) {
            current_nums = receiveNextLine();
            roads.emplace_back(current_nums[2], current_nums[0], current_nums[1]);
            total_weight += current_nums[2];
        }
        int new_weight = 0;

        for (int i = 0; i < num_junctions; i++) {
            makeSet(i);
        } // O(num_junctions)

        sort(roads.begin(), roads.end(), [](const Road& a, const Road& b) {
            return a.getLength() < b.getLength();
        }); // O(num_roads * log(num_roads))

        for (const Road& r : roads) {
            if (find_set(r.start_junction) != find_set(r.next_junction)) {
                new_weight += r.length; // O(num_roads * log*(num_junctions))
                union_sets(r.start_junction, r.next_junction); // O(num_roads * log*(num_junctions))
            }
        }
        cout << total_weight - new_weight << endl;
    }
    return 0;
}

