#include <iostream>

using namespace std;

int map[110][110];
int nMap[110][110];
bool visited[110][110];

int n, m;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

bool isValid(int i, int j)
{
    if (i >= 0 && i < n && j >= 0 && j < m)
    {
        return true;
    }
    return false;
}
void dfs(int i, int j)
{
    for (int k = 0; k < 4; k++)
    {
        int nX = i + dx[k];
        int nY = j + dy[k];
        if (isValid(nX, nY) && map[nX][nY] == 0 && !visited[nX][nY])
        {
            visited[nX][nY] = true;
            map[nX][nY] = 9;
            dfs(nX, nY);
        }
    }
}
int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> map[i][j];
        }
    }
    bool exist = true;
    int ans = 0;
    while (exist)
    {

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                visited[i][j] = false;
                if (map[i][j] == 9)
                {
                    map[i][j] = 0;
                }
            }
        }
        dfs(0, 0);

        ans++;
        exist = false;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int airCnt = 0;
                for (int k = 0; k < 4; k++)
                {
                    int nX = i + dx[k];
                    int nY = j + dy[k];
                    if (isValid(nX, nY) && map[nX][nY] == 9)
                    {
                        airCnt++;
                    }
                }
                if (airCnt >= 2)
                {
                    nMap[i][j] = 0;
                }
                else
                {
                    nMap[i][j] = map[i][j];
                }
                if (nMap[i][j] == 1)
                {
                    exist = true;
                }
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                map[i][j] = nMap[i][j];
            }
        }
    }

    cout << ans << endl;

    return 0;
}