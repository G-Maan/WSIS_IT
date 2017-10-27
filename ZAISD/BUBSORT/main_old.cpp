#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int numbers[1001];
    int n;

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> numbers[i];
    }

    bool swapped;
    for (int i=0;i<n;i++) 
    {
        swapped = false;
        for (int j=0;j<n-1;j++)
        {
            if(numbers[j] > numbers[j+1])
            {
                swap(numbers[j], numbers[j+1]);
                swapped = true;
            }
        }
        if(swapped)
        {
            for(int j=0;j<n;j++)
            {
                cout<< numbers[j]<< " ";
            }
        }
        else
        {
            return 0;
        }
    }
    return 0;
}