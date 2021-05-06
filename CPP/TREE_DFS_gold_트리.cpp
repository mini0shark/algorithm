#include<iostream>
#include<vector>
using namespace std;

int N;
int del;
typedef struct NODE {
	int no;
	vector<int> children;
}NODE;
vector<NODE> arr;
int dfs(int root) {
	if (arr[root].children.size() == 0) return 1; // 리프노드
	if (arr[root].children.size() == 1 && arr[root].children[0] == del) return 1;
	// 하나 있는 자식을 지우면 리프노드가 된다.

	int ans = 0;
	for (int i = 0; i < arr[root].children.size(); i++) {
		int child = arr[root].children[i];
		if (child == del) continue;
		ans += dfs(child);
	}
	return ans;
}
int main() {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(0);
	cin >> N;
	arr.resize(N, {-1,vector<int>(0)});

	int temp;
	int root;
	for (int i = 0; i < N; i++) {
		arr[i].no = i;

		cin >> temp;		// i번째 노드의 부모노드

		if (temp < 0) 
			root = i;
		else							// 자식이 하나면
			arr[temp].children.push_back(i);

	}
	cin >> del;
	cout << dfs(root);

	return 0;
}
// https://develaniper-devpage.tistory.com/52?category=476411