#include <iostream>

using namespace std;

int main() {
    int n;
    unique_ptr<int[]> numbers(new int[n]); // Create dynamic table in C++11 standard.

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> numbers[i];
    }

    bool swapped; // Remember if table changed during iteration.
    for (int i = 0; i < n; i++) {
        swapped = false;
        for (int j = 0; j < n - 1; j++) {
            if (numbers[j] > numbers[j + 1]) {
                swap(numbers[j], numbers[j + 1]);
                swapped = true;
            }
        }
        if (!swapped) {
            break;
        }
    }

    for (int j = 0; j < n; j++) {
        cout << numbers[j] << " ";
    }
    return 0;
}
