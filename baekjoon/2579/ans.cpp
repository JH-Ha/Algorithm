#include <iostream>
#include <utility>

using namespace std;

int n;
int kaidan[310];
int dp[310][2];
int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> kaidan[i];
    }
    dp[0][0] = kaidan[0];
    dp[0][1] = kaidan[0];
    dp[1][0] = kaidan[1];
    dp[1][1] = dp[0][0] + kaidan[1];

    for (int i = 2; i < n; i++)
    {
        dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + kaidan[i];
        dp[i][1] = dp[i - 1][0] + kaidan[i];
    }
    cout << max(dp[n - 1][0], dp[n - 1][1]) << endl;
    return 0;
}