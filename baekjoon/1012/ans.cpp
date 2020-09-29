#include <iostream>
#include <queue>

using namespace std;

int hatake[55][55];
bool visited[55][55];

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int m, n, k;

bool isSafe(int x, int y)
{
    if (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1)
    {
        return true;
    }
    return false;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {

        cin >> m >> n >> k;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                hatake[i][j] = 0;
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < k; i++)
        {
            int x, y;
            cin >> x >> y;
            hatake[y][x] = 1;
        }
        int answer = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // cout << "--- " << i << " --- " << j << endl;
                // for (int x = 0; x < n; x++)
                // {
                //     for (int y = 0; y < m; y++)
                //     {
                //         cout << visited[x][y] << " ";
                //     }
                //     cout << endl;
                // }
                if (hatake[i][j] == 1 && visited[i][j] == false)
                {
                    answer++;
                    queue<pair<int, int>> q;
                    q.push(make_pair(i, j));
                    visited[i][j] = true;
                    while (!q.empty())
                    {
                        pair<int, int> p = q.front();
                        q.pop();
                        //cout << "x : " << p.first << " y : " << p.second << endl;
                        //visited[p.first][p.second] = true;
                        for (int k = 0; k < 4; k++)
                        {
                            if (isSafe(p.first + dx[k], p.second + dy[k]) && hatake[p.first + dx[k]][p.second + dy[k]] == 1 && visited[p.first + dx[k]][p.second + dy[k]] == false)
                            {
                                q.push(make_pair(p.first + dx[k], p.second + dy[k]));
                                visited[p.first + dx[k]][p.second + dy[k]] = true;
                            }
                        }
                    }
                }
            }
        }
        cout << answer << '\n';
    }

    return 0;
}