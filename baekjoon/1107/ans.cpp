#include <iostream>

using namespace std;

int n;
int m;
bool broken[10];
bool validateNumber(int num)
{
    if (num == 0 && broken[0])
    {
        return false;
    }

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
int getLen(int num)
{
    if (num == 0)
    {
        return 1;
    }
    int len = 0;
    while (num > 0)
    {
        len++;
        num /= 10;
    }
    return len;
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
    int ans = abs(n - 100);
    for (int i = 0; i <= 1000000; i++)
    {
        bool isValidNumber = validateNumber(i);
        if (isValidNumber)
        {
            int len = getLen(i);
            ans = min(ans, abs(i - n) + len);
        }
    }
    cout << ans << endl;
    return 0;
}