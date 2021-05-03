#include <iostream>
#include <vector>
#define MX 1000001
using namespace std;
int N;
vector<int> arr;
vector<int> boj;
int main() {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(0);
	cin >> N;
	arr.resize(N + 1, MX);
	boj.resize(N + 1, 0);
	string temp;
	cin >> temp;
	for (int i = 0; temp[i]; i++) {
		if (temp[i] == 'B')
			boj[i+1] = 0;
		else if (temp[i] == 'O')
			boj[i+1] = 1;
		else
			boj[i+1] = 2;
	}
	arr[1] = 0;
	for (int i = 1; i <= N; i++) {
		if (arr[i] == MX) continue;
		for (int j = i + 1; j <= N; j++) {
			if (boj[j] == (boj[i] + 1) % 3) { // 다음것이 맞음
				arr[j] = min(arr[j],(j - i) * (j - i)+arr[i]);
			}
		}
	}
	cout << (arr[N]!=MX?arr[N]:(-1));
	return 0;
}