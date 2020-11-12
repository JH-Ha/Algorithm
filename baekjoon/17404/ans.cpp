#include <iostream>

using namespace std;

#define MAX_N 1010

int dp[MAX_N][3];
int color[MAX_N][3];
int startColor[MAX_N][3];
int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> color[i][0] >> color[i][1] >> color[i][2];
    }
    int ans = 1000 * 1000 + 1;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (j == i)
            {
                dp[0][j] = color[0][j];
            }
            else
            {
                dp[0][j] = 1000 * 1000 + 1;
            }
        }
        for (int j = 1; j < n; j++)
        {
            dp[j][0] = min(dp[j - 1][1], dp[j - 1][2]) + color[j][0];
            dp[j][1] = min(dp[j - 1][0], dp[j - 1][2]) + color[j][1];
            dp[j][2] = min(dp[j - 1][0], dp[j - 1][1]) + color[j][2];
        }
        for (int j = 0; j < 3; j++)
        {
            if (j == i)
                continue;
            ans = min(ans, dp[n - 1][j]);
        }
    }
    cout << ans << endl;
    return 0;
}