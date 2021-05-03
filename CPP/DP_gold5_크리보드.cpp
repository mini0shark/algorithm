#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int N;
vector<int> arr;

int main() {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(0);
	N = 100;
	arr.resize(N+1, 0 );
	// 1~6�� ȭ�鿡 �׳� ���� ���� ���� ���� �ø��� ���̴�.(6�� �Ȱ���)
	for (int i = 1; i <= 6 && i <= N; i++) {
		arr[i] = i;
	}
	// ���� & �ٿ��ֱ� �Ϸ��� �ּ� 3��° ���� �ε����� ���� *(3-1)�� �ؼ� ���ϸ� �ȴ�.
	for (int i = 7; i <= N; i++) {
		for (int j = 3; j <= i; j++) {
			arr[i] = max(arr[i], arr[i - j] * (j - 1));
		}
	}
	cout << arr[N];
	return 0;
}