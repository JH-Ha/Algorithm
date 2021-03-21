#include <iostream>

using namespace std;

int n;
int m;
bool broken[10];
bool validateNumber(int num)
{
    while (num > 0)
    {
        if (broken[num % 10])
        {
            return false;
        }
        num /= 10;
    }
    return true;
}

int main()
{
    cin >> n;
    cin >> m;

    for (int i = 0; i < 10; i++)
    {
        broken[i] = false;
    }
    int brokenNumber;
    for (int i = 0; i < m; i++)
    {
        cin >> brokenNumber;
        broken[brokenNumber] = true;
    }

    for (int i = 0; i <= 1000000; i++)
    {
        bool isValidNumber = validateNumber(i);
    }
    return 0;
}