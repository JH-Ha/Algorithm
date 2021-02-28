#include <iostream>
#include <string>

using namespace std;

int sum[1025][1025];

int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0; i <= n; i++)
    {
        sum[0][i] = 0;
        sum[i][0] = 0;
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            int input;
            cin >> input;
            if (j == 1)
            {
                sum[i][j] = input;
            }
            else
            {
                sum[i][j] = sum[i][j - 1] + input;
            }
        }
    }
    for (int i = 2; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            sum[i][j] += sum[i - 1][j];
        }
    }
    string ans = "";
    for (int i = 0; i < m; i++)
    {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        ans += to_string(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]) + '\n';
    }
    cout << ans;
    return 0;
}