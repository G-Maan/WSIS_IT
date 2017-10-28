#include <iostream>

using namespace std;

int main() {
    int n;
    int number;
    int tab[128] = {};

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> number;
        tab[number]++;
    }

    for (int i = 0; i < 128; i++) {
        while (tab[i] > 0) {
            cout << i << " ";
            tab[i]--;
        }
    }

    return 0;
}