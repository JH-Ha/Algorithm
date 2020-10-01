#include <iostream>

using namespace std;
long long dp[1010];

int main()
{
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i < 1010; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2];
        dp[i] = dp[i] % 10007;
    }
    int n;
    cin >> n;
    cout << dp[n] % 10007 << '\n';
    return 0;
}