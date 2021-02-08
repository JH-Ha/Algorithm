#include <iostream>
#include <string>

using namespace std;

int map[50][50];
int dp[50][50];

bool visited[50][50];
int n, m;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

bool isValid(int x, int y)
{
    bool result = false;
    if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] != -1)
    {
        result = true;
    }
    return result;
}
int ans = 0;

int dfs(int x, int y)
{
    if (ans == -1)
    {
        return -1;
    }
    if (!isValid(x, y))
    {
        return 0;
    }
    if (visited[x][y])
    {
        ans = -1;
        return -1;
    }
    if (dp[x][y] != -1)
    {
        return dp[x][y];
    }
    visited[x][y] = true;
    for (int i = 0; i < 4; i++)
    {
        int nextX = x + dx[i] * map[x][y];
        int nextY = y + dy[i] * map[x][y];
        dp[x][y] = max(dfs(nextX, nextY) + 1, dp[x][y]);
    }
    visited[x][y] = false;
    return dp[x][y];
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < m; j++)
        {
            if (s[j] == 'H')
                map[i][j] = -1;
            else
                map[i][j] = s[j] - '0';
            visited[i][j] = false;
            dp[i][j] = -1;
        }
    }
    dfs(0, 0);
    if (ans == -1)
        cout << ans << endl;
    else
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                ans = max(ans, dp[i][j]);
            }
        }
        cout << ans << endl;
    }
    return 0;
}