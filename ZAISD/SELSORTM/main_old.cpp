#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    long tab[10001] = {0};
    int max = 0;
    int index_max = 0;
    int start_index = 0;
    int diff;

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> tab[i];
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = start_index; j < n; j++)
        {
            if (tab[j] > max)
            {
                max = tab[j];
                index_max = j;
            }
        }
        diff = index_max - start_index;
        
        tab[index_max] -= diff;
        if (tab[index_max] < 0)
        {
            tab[index_max] = 0;
        }

        tab[start_index] -= diff;
        if(tab[start_index] < 0)
        {
            tab[start_index] = 0;
        }

        swap(tab[index_max],tab[start_index]);

        start_index++;
        index_max = start_index;
        max = 0;
    }

    for (int i = 0; i < n; i++)
    {
        cout << tab[i] << " ";
    }

    return 0;
}