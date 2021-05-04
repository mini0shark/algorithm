#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, K;
vector<pair<int, int>> items;
vector<int> values;
int main() {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(0);
	cin >> N >> K;
	items.resize(N, { 0,0 });
	values.resize(K + 1, 0);
	for (int i = 0; i < N; i++) {
		cin >> items[i].first >> items[i].second;
	}

	for (auto item : items) {
		for (int i = K; i >= item.first; i--) {
			values[i] = max(values[i], values[i - item.first] + item.second);
		}
	}
	cout << values[K];
	return 0;
}