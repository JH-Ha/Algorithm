#include <stdio.h>

int map[510][510];
int dp[510][510];
int m, n;

int find(int x, int y)
{
    //printf("%d %d\n", x, y);
    if (x == m - 1 && y == n - 1)
    {
        //printf("return 1\n");
        return 1;
    }
    if (dp[x][y] == -1)
    {
        dp[x][y] = 0;
        if (x < m - 1)
        {
            if (map[x][y] > map[x + 1][y])
            {
                dp[x][y] += find(x + 1, y);
            }
        }
        if (x > 0)
        {
            if (map[x][y] > map[x - 1][y])
            {
                dp[x][y] += find(x - 1, y);
            }
        }
        if (y < n - 1)
        {
            if (map[x][y] > map[x][y + 1])
            {
                dp[x][y] += find(x, y + 1);
            }
        }
        if (y > 0)
        {
            if (map[x][y] > map[x][y - 1])
            {
                dp[x][y] += find(x, y - 1);
            }
        }
    }
    return dp[x][y];
}

int main()
{

    scanf("%d %d", &m, &n);
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &map[i][j]);
            dp[i][j] = -1;
        }
    }
    printf("%d\n", find(0, 0));

    return 0;
}