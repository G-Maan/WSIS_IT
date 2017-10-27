#include<iostream>

using namespace std;

int main()
{
    int n;
    int number;
    int values[2001] = {0};

    cin >> n;

    for(int i=0;i<n;i++)
    {
        cin>>number;
        values[number+1000]++;
    }

    for(int i=0;i<2001;i++)
    {
        if(values[i]%2 == 1)
        {
            cout<<i-1000<<" ";
        }
    }

    return 0;
}