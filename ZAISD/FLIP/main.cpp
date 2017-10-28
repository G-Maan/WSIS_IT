#include <iostream>

using namespace std;

int main() {
    int n;
    int number;
    cin >> n;

    int tab[101] = {};

    for(int i=0; i<n; i++) {
        cin >> number;
        tab[number] ++;
    }

    for(int i=0; i < 101; i++) {
        for (int j=0; j<tab[i]; j++) {
            cout << i << " ";
        }
    }

    return 0;
}