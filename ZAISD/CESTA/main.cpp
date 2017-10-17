#include <iostream>

using namespace std;

int main() {
    int digit = 0;
    long sum = 0;

    string str_number;
    int numbers[10] = {0}; // Table used for counting digits with specific values.

    cin >> str_number;

    for (char &i : str_number) {
        digit = (int) i - (int) ('0'); // Convert char to int by subtraction of ASCII codes.
        numbers[digit]++; // Count digit occurrence.

        sum += digit;
    }

    if ((numbers[0] == 0) && (sum % 3 != 0)) { // Check if number cannot be divided by 30.
        cout << "-1";
        return 0;
    }

    for (int i = 9; i >= 0; i--) { // Print digits (999...888...777...66...)
        while (numbers[i] > 0) {
            cout << i;
            numbers[i]--;
        }
    }
    return 0;
}