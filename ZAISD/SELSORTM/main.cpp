#include <iostream>

using namespace std;

int main() {
    int n;
    int max = 0;
    int index_max;
    int diff;

    cin >> n;

    unique_ptr<int[]> tab(new int[n]); // Create dynamic table in C++11 standard.

    for (int i = 0; i < n; i++) {
        cin >> tab[i];
    }

    for (int i = 0; i < n; i++) {
        index_max = i;

        for (int j = i; j < n; j++) {
            if (tab[j] > max) { // Remember max value and index of max value.
                max = tab[j];
                index_max = j;
            }
        }
        diff = index_max - i; // Calculate distance.

        tab[index_max] -= diff; // Subtract distance from max value.
        if (tab[index_max] < 0) {
            tab[index_max] = 0;
        }

        tab[i] -= diff; // Subtract distance from start value.
        if (tab[i] < 0) {
            tab[i] = 0;
        }

        swap(tab[index_max], tab[i]); // Swap max value with start value.

        max = 0;
    }

    for (int i = 0; i < n; i++) {
        cout << tab[i] << " ";
    }

    return 0;
}