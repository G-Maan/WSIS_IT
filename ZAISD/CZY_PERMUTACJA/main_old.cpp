#include <iostream>

using namespace std;

int main()
{
    int n, number;
    cin >> n;
    bool numbers[1000000];

    for(int i=0;i<n;i++){
        numbers[i] = false;
    }

    for (int i = 0; i < n; i++)
    {
        cin >> number;
        numbers[number-1] = true;
    }

    for (int i = 0; i < n; i++)
    {
        if (!numbers[i])
        {
            cout << "NIE";
            return 0;
        }
    }

    cout << "TAK";
    return 0;
}