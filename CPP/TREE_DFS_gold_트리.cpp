#include<iostream>
#include<vector>
using namespace std;
int solution(string s) {
    int answer = 0;
    string number = "";
    string temp = "";
    for (int i = 0; s[i]; i++) {
        if ('0' <= s[i] && s[i] <= '9') { //¼ýÀÚ¸é
            number += stringToInt(temp);
            temp = "";
            number += s[i];
        }
        else {
            //temp+=s[i];
        }
    }
    number += temp;
    answer = stoi(number);
    return answer;
}
int main() {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(0);
	cout<< solution("1234");
	return 0;
}