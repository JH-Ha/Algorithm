#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int board[55][55];

int main()
{
    int n, m;
    cin >> n >> m;
    string s;
    for (int i = 0; i < n; i++)
    {
        cin >> s;
        for (int j = 0; j < m; j++)
        {
            if (s[j] == 'W')
            {
                board[i][j] = 0;
            }
            else
            {
                board[i][j] = 1;
            }
        }
    }
    int nuruNum = 65;
    for (int i = 0; i <= n - 8; i++)
    {
        for (int j = 0; j <= m - 8; j++)
        {
            int localNuru1 = 0;
            int localNuru2 = 0;
            for (int x = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    if ((x + y) % 2 == 0)
                    {
                        if (board[x + i][y + j] == 0)
                        {
                            localNuru1++;
                        }
                        else
                        {
                            localNuru2++;
                        }
                    }
                    else
                    {
                        if (board[x + i][y + j] == 1)
                        {
                            localNuru1++;
                        }
                        else
                        {
                            localNuru2++;
                        }
                    }
                }
            }
            nuruNum = min(nuruNum, localNuru1);
            nuruNum = min(nuruNum, localNuru2);
        }
    }
    cout << nuruNum << '\n';
    return 0;
}