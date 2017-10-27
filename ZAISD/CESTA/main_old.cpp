#include <iostream>
#include <string>
using namespace std;

int main()
{
    int digit=0;
    long sum =0;
    bool divide = false;
    bool zero_found = false;
    string str_number;
    int numbers[10] = {0};
    cin>>str_number;

    for (int i=0;i< str_number.length();i++)
    {
        digit = (long)(str_number[i]) - (long)('0');
        numbers[digit]++;

        sum += digit;
        if(digit == 0)
        {
            zero_found = true;
        }
    }

    divide = (sum%3 == 0);

    if(!(zero_found && divide)) 
    {
        cout<<"-1";
        return 0;
    }

    for (int i=9; i>=0; i--)
    {
        while(numbers[i] > 0)
        {
            cout<<i;
            numbers[i]--;
        }
    }
    return 0;
}