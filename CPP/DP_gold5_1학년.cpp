#include<iostream>
#include<vector>
using namespace std;

int N;
vector<int> arr;
vector<vector<long long>> dp;
int main() {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(0);
	cin >> N;
	arr.resize(N + 1);
	dp.resize(N + 1, vector<long long>(21, 0));
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
	}
	dp[1][arr[1]] = 1;
	for (int i = 2; i <= N; i++) {
		int cur = arr[i];
		for (int j = 0; j <= 20; j++) {
			if (0 <= j - cur) {
				dp[i][j - cur] += dp[i - 1][j];
			}
			if (j + cur <= 20 && i < N) {
				dp[i][j + cur] += dp[i - 1][j];
			}
		}
	}
	cout << dp[N][0];
	return 0;
}