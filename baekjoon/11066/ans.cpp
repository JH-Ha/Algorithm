#include <iostream>

using namespace std;

long long dp[505][505];
long long sum[505];
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                dp[i][j] = INT32_MAX;
            }
        }
        sum[0] = 0;
        for (int i = 0; i < n; i++)
        {
            int input;
            cin >> input;
            sum[i + 1] = sum[i] + input;
            dp[i][i] = 0;
        }
        for (int i = 0; i + 1 < n; i++)
        {
            //dp[i][i + 1] = dp[i][i] + dp[i + 1][i + 1];
            dp[i][i + 1] = sum[i + 2] - sum[i];
        }
        for (int k = 2; k < n; k++)
        {
            for (int i = 0; i + k < n; i++)
            {
                for (int j = 0; j < k; j++)
                {
                    dp[i][i + k] = min(dp[i][i + j] + dp[i + j + 1][i + k] + (sum[i + k + 1] - sum[i]), dp[i][i + k]);
                    //dp[i][i + k] = min(dp[i][i + j] + dp[i + j + 1][i + k], dp[i][i + k]);
                }
            }
        }
        cout << dp[0][n - 1] << '\n';
    }
    return 0;
}