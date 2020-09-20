#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<long long, long long>> a;

int n;
long long dp[505][505];

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        long long l, r;
        cin >> l >> r;
        a.push_back(make_pair(l, r));
        dp[i][i] = 0;
    }
    for (int i = 0; i < n - 1; i++)
    {
        dp[i][i + 1] = a[i].first * a[i].second * a[i + 1].second;
    }
    for (int i = 0; i < n - 2; i++)
    {
        dp[i][i + 2] = dp[i][i + 1] + a[i].first * a[i + 2].first * a[i + 2].second;
        dp[i][i + 2] = a[i].first * a[i].second * a[i + 1].second + dp[i + 1][i + 2];
    }
    for (int k = 2; k < n; k++)
    {
        for (int i = 0; i + k < n; i++)
        {
            dp[i][i + k] = INT64_MAX;
            for (int j = 0; j < k; j++)
            {
                dp[i][i + k] = min(dp[i][i + k - 1 - j] + dp[i + k - j][i + k] + a[i].first * a[i + k - j].first * a[i + k].second,
                                   dp[i][i + k]);
            }
            // dp[i][i + 3] = dp[i][i + 2] + a[i].first * a[i + 3].first * a[i + 3].second;
            // dp[i][i + 3] = dp[i][i + 1] + dp[i + 2][i + 3] + a[i].first * a[i + 1].second * a[i + 3].second;
        }
    }
    cout << dp[0][n - 1] << endl;

    return 0;
}