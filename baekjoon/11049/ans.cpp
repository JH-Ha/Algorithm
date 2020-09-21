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
    for (int k = 1; k < n; k++)
    {
        for (int i = 0; i + k < n; i++)
        {
            dp[i][i + k] = INT64_MAX;
            for (int j = 0; j < k; j++)
            {
                dp[i][i + k] = min(dp[i][i + j] + dp[i + j + 1][i + k] + a[i].first * a[i + j + 1].first * a[i + k].second,
                                   dp[i][i + k]);
            }
        }
    }
    cout << dp[0][n - 1] << endl;

    return 0;
}