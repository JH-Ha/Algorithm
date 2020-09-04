#include <iostream>
#define MOD 1000000000
using namespace std;

long long dp[105][10];

int main()
{
    for (int i = 1; i < 10; i++)
    {
        dp[1][i] = 1;
    }
    dp[1][0] = 0;
    for (int i = 2; i < 105; i++)
    {
        dp[i][0] = dp[i - 1][1] % MOD;
        //dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
        for (int j = 1; j <= 8; j++)
        {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
        }
        dp[i][9] = dp[i - 1][8] % MOD;
    }
    int n;
    cin >> n;
    long long ans = 0;
    for (int i = 0; i < 10; i++)
    {
        //cout << dp[n][i] << endl;
        ans += dp[n][i];
    }
    cout << ans % MOD << endl;
    return 0;
}