#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

int N;

bool checkPrime(int num) {
	if (num < 2)  return false;
	int sq = sqrt(num);
	while (sq>1) {
		if (num % sq == 0) return false; // 소수X
		sq--;
	}
	return true;	// 소수O
}
void dfs(int n, int num) {
	if (n == N) {
		if (checkPrime(num)) cout << num <<endl;
		return;
	}
	
	for (int i = 0; i < 10; i++) {
		int next = num * 10 + i;
		if(checkPrime(next)) dfs(n + 1, next);
	}
}
int main() {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(0);
	cin >> N;

	dfs(0, 0);
	return 0;
}
// 포스팅
// https://develaniper-devpage.tistory.com/49