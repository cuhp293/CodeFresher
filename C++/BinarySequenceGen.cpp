#include <bits/stdc++.h>
using namespace std;

int n;
string curString;

void gen(int pos) {
    cout << "gen(" << pos << ")" << endl;
	if (pos > n) {
		cout << curString << endl;
		return;
	}

	for (char i = '0'; i <= '1'; i++) {
		curString.push_back(i);
		cout << "push_back(" << i << ")" << endl;
		gen(pos+1);
		curString.pop_back();
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n;
	curString = "";
	gen(1);

	return 0;
}