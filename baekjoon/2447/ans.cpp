#include <iostream>

using namespace std;

bool board[10000][10000];

void solve(int n, int x, int y)
{
    if (n == 0)
        return;
    for (int i = x; i < x + n; i++)
    {
        for (int j = y; j < y + 3 * n; j++)
        {
            board[i][j] = true;
        }
    }
    for (int i = x + n; i < x + 2 * n; i++)
    {
        for (int j = y; j < y + n; j++)
        {
            board[i][j] = true;
        }
        for (int j = y + n; j < y + 2 * n; j++)
        {
            board[i][j] = false;
        }
        for (int j = y + 2 * n; j < y + 3 * n; j++)
        {
            board[i][j] = true;
        }
    }
    for (int i = x + 2 * n; i < x + 3 * n; i++)
    {
        for (int j = y; j < y + 3 * n; j++)
        {
            board[i][j] = true;
        }
    }
    solve(n / 3, x, y);
    solve(n / 3, x + n, y);
    solve(n / 3, x + 2 * n, y);
    solve(n / 3, x, y + n);

    solve(n / 3, x + 2 * n, y + n);
    solve(n / 3, x, y + 2 * n);
    solve(n / 3, x + n, y + 2 * n);
    solve(n / 3, x + 2 * n, y + 2 * n);
}

int main()
{
    int n;
    cin >> n;
    solve(n / 3, 0, 0);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (board[i][j])
                printf("*");
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}