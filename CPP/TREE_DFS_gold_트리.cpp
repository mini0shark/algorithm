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
	if (arr[root].children.size() == 0) return 1; // �������
	if (arr[root].children.size() == 1 && arr[root].children[0] == del) return 1;
	// �ϳ� �ִ� �ڽ��� ����� ������尡 �ȴ�.

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

		cin >> temp;		// i��° ����� �θ���

		if (temp < 0) 
			root = i;
		else							// �ڽ��� �ϳ���
			arr[temp].children.push_back(i);

	}
	cin >> del;
	cout << dfs(root);

	return 0;
}
// https://develaniper-devpage.tistory.com/52?category=476411