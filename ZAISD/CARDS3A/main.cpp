#include<iostream>

using namespace std;

int main()
{
    int n;
    int number;
    int values[2001] = {0}; // For values from -1000 to +1000, for example: cards with value "13" will be counted in
                            // value[13+1000].

    cin >> n;

    for(int i=0;i<n;i++)
    {
        cin>>number;
        values[number+1000]++;  // Count card with specific value.
    }

    for(int i=0;i<2001;i++)
    {
        if(values[i]%2 == 1) // Check if number of cards with specific value is odd.
        {
            cout<<i-1000<<" ";
        }
    }

    return 0;
}
