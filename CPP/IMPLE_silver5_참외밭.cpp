#include<iostream>
#include <vector>
using namespace std;


int main() {
	int K;
	int result = 0;
	vector<pair<int, int>> len(6);
	cin >> K;
	for (int i = 0; i < 6; i++) {
		cin >> len[i].first >> len[i].second;
		if (i > 0) result += len[i].second * len[i - 1].second;
	}
	result += len.back().second * len.front().second;
	for (int i = 0; i < 3; i++)len.push_back(len[i]);
	int hole = 0;
	for (int i = 3; i < len.size(); i++) {
		if (len[i].first == len[i - 2].first && len[i - 1].first == len[i - 3].first) {
			hole = len[i - 1].second * len[i - 2].second;
			break;
		}
	}
	cout << ((result - 2*hole) / 3)*K;
	return 0;
}