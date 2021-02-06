#include <iostream>

using namespace std;

#define MAX_SIZE 4000

//char map[MAX_SIZE][MAX_SIZE];
char map[3][5];

char find(int x, int y, int n)
{
    if (n == 3)
    {
        return map[x][y];
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
    {
        return ' ';
    }
    if (x >= n / 2 && y < n)
    {
        return find(x - n / 2, y, n / 2);
    }
    if (x >= n / 2 && y >= n)
    {
        return find(x - n / 2, y - n, n / 2);
    }

    return find(x, y - n / 2, n / 2);
}

int main()
{
    int n;
    cin >> n;

    string line[3] = {"  *  ",
                      " * * ",
                      "*****"};
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            map[i][j] = line[i][j];
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