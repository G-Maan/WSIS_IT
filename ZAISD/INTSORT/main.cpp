#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int* numbers = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> numbers[i];
    }


    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n-1;j++)
        {
            if(numbers[j] > numbers[j+1])
            {
                swap(numbers[j], numbers[j+1]);
            }
        }
    }

    for(int j=0;j<n;j++)
    {
        cout<< numbers[j]<< " ";
    }
    return 0;
}