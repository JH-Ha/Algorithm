#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

int tomato[1005][1005];
bool visited[1005][1005];
int m, n;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
bool isSafe(int x, int y)
{
    if (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1 && tomato[x][y] != -1)
    {
        return true;
    }
    return false;
}
int main()
{

    cin >> m >> n;
    queue<tuple<int, int, int>> q;
    int answer = 0;
    int numRipen = 0;
    int maxRipen = m * n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> tomato[i][j];
            visited[i][j] = false;
            if (tomato[i][j] == 1)
            {
                q.push(make_tuple(i, j, 0));
                visited[i][j] = true;
                numRipen++;
            }
            else if (tomato[i][j] == -1)
            {
                maxRipen--;
            }
        }
    }
    while (!q.empty())
    {
        tuple<int, int, int> t = q.front();
        q.pop();
        int x = get<0>(t);
        int y = get<1>(t);
        int time = get<2>(t);
        answer = time;
        for (int i = 0; i < 4; i++)
        {
            if (isSafe(x + dx[i], y + dy[i]) && !visited[x + dx[i]][y + dy[i]])
            {
                q.push(make_tuple(x + dx[i], y + dy[i], time + 1));
                visited[x + dx[i]][y + dy[i]] = true;
                numRipen++;
            }
        }
    }
    if (numRipen == maxRipen)
    {
        cout << answer << '\n';
    }
    else
    {
        cout << -1 << '\n';
    }

    return 0;
}