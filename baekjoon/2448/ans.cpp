#include <iostream>

using namespace std;

#define MAX_SIZE 4000

char map[MAX_SIZE][MAX_SIZE];

char find(int x, int y, int n)
{
    if (n == 1)
    {
        return '*';
    }

    if (y > x + (n - 1) || y < -x + n - 1)
    {
        return ' ';
    }
    if (x >= n / 2 && y >= n / 2 && y < n && y >= x)
    {
        return ' ';
    }
    if (x >= n / 2 && y >= n && y < (2 * n - 1) * 3 / 4 && y < -x + 2 * n - 1)
    // && y < -x + (3 * n) / 2 - 1)
    {
        return ' ';
    }
    if (x >= n / 2)
    {
    }

    return '*';
}

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < MAX_SIZE; i++)
    {
        for (int j = 0; j < MAX_SIZE; j++)
        {
            map[i][j] = ' ';
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < 2 * n - 1; j++)
        {
            cout << find(i, j, n);
        }
        cout << endl;
    }

    return 0;
}