#include <iostream>

using namespace std;

int tri[501][501];
int sum[501][501];
int n;
int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j < i + 1; j++)
        {
            cin >> tri[i][j];
        }
    }

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j < i + 1; j++)
        {
            sum[i][j] = 0;
        }
    }
    sum[1][1] = tri[1][1];

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j < i + 1; j++)
        {
            int topMax = max(sum[i - 1][j - 1], sum[i - 1][j]);
            sum[i][j] = topMax + tri[i][j];
        }
    }
    int ans = -999999999;
    for (int i = 1; i <= n; i++)
    {
        ans = max(ans, sum[n][i]);
    }
    cout << ans << endl;

    return 0;
}