#include <iostream>
#include <algorithm>

using namespace std;

#define MAX_NUM 50005
int dp[50005];

int main()
{
    int n;
    cin >> n;
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++)
    {
        int localMin = MAX_NUM;
        for (int j = 1; j * j <= i; j++)
        {
            localMin = min(localMin, dp[i - j * j] + 1);
        }
        dp[i] = localMin;
    }
    cout << dp[n] << '\n';
    return 0;
}