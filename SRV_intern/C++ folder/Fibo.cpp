#include <bits/stdc++.h>
using namespace std;

void testFiboIndex(int n , int expectedIndex) {
    int actualIndex = fiboIndex(n);
    if (actualIndex == expectedIndex) {
        cout << "Test case for n = " << n << " passed." << endl;
    } else {
        cout << "Test case for n = " << n << " failed. Expected index: " << expectedIndex
        << ", Actual index: " << actualIndex << endl;
    }
}

int main() {
    testFiboIndex(1, 0);
    testFiboIndex(5, 21);
    return 0;
}