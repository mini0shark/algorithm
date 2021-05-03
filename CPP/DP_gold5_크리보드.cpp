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
	// 1~6은 화면에 그냥 쓰는 것이 가장 많이 늘리는 것이다.(6은 똑같음)
	for (int i = 1; i <= 6 && i <= N; i++) {
		arr[i] = i;
	}
	// 복사 & 붙여넣기 하려면 최소 3번째 전의 인덱스의 값을 *(3-1)배 해서 비교하면 된다.
	for (int i = 7; i <= N; i++) {
		for (int j = 3; j <= i; j++) {
			arr[i] = max(arr[i], arr[i - j] * (j - 1));
		}
	}
	cout << arr[N];
	return 0;
}