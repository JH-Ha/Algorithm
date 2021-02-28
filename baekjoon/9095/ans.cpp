#include <iostream>

using namespace std;

int dp[12];
int num[3] = {1, 2, 3};

int main()
{
    dp[0] = 1;
    for (int i = 1; i <= 11; i++)
    {
        dp[i] = 0;
        for (int j = 0; j < 3; j++)
        {
            if (i - num[j] >= 0)
            {
                dp[i] += dp[i - num[j]];
            }
        }
    }

    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        cout << dp[n] << '\n';
    }
    return 0;
}