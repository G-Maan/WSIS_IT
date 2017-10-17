#include <iostream>

using namespace std;

int main() {
    int n;
    int number;

    cin >> n;

    unique_ptr<bool[]> numbers(new int[n]); // Create dynamic table in C++11 standard.

    for (int i = 0; i < n; i++) {
        numbers[i] = false;
    }

    for (int i = 0; i < n; i++) {
        cin >> number;
        numbers[number - 1] = true; // Note the occurrence of specific number.
    }

    for (int i = 0; i < n; i++) {
        if (!numbers[i]) { // Check if at least one number didn't appear.
            cout << "NIE";
            return 0;
        }
    }

    cout << "TAK";
    return 0;
}