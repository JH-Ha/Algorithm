#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    int checkN = n;
    int numDigit = 0;
    while (checkN > 0)
    {
        numDigit++;
        checkN = checkN / 10;
    }
    int ans = 0;
    for (int i = n - numDigit * 9; i < n; i++)
    {
        int digitSum = 0;
        checkN = i;
        while (checkN > 0)
        {
            digitSum += checkN % 10;
            checkN = checkN / 10;
        }
        if (digitSum + i == n)
        {
            ans = i;
            break;
        }
    }
    cout << ans << endl;
    return 0;
}