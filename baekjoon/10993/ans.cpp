#include <iostream>
#include <vector>

using namespace std;

void drawStar(int x, int y, int n, int width, vector<vector<int>> &map)
{
    if (n == 0)
        return;
    if (n % 2 == 0)
    {
        for (int j = 0; j < width; j++)
        {
            map[x][y + j] = 1;
        }
        for (int i = x + 1; i <= x + width / 2; i++)
        {
            int pos = i - x;
            map[i][y + pos] = 1;
            map[i][y + width - 1 - pos] = 1;
        }
        drawStar(x + 1, y + width / 4 + 1, n - 1, (width - 3) / 2, map);
    }
    else
    {
        for (int j = 0; j < width; j++)
        {
            map[x + width / 2][y + j] = 1;
        }
        for (int i = x + width / 2; i >= x; i--)
        {
            int pos = x + width / 2 - i;
            map[i][y + pos] = 1;
            map[i][y + width - 1 - pos] = 1;
        }
        drawStar(x + width / 4, y + width / 4 + 1, n - 1, (width - 3) / 2, map);
    }
}

int main()
{
    int n;
    cin >> n;

    int width = 1;
    for (int i = 1; i < n; i++)
    {
        width = width * 2 + 3;
    }
    vector<vector<int>> map;
    for (int i = 0; i < 3000; i++)
    {
        vector<int> row;
        for (int j = 0; j < 3000; j++)
        {
            row.push_back(0);
        }
        map.push_back(row);
    }
    //cout << width << endl;
    drawStar(0, 0, n, width, map);
    for (int i = 0; i < width / 2 + 1; i++)
    {
        int last = 0;
        for (int j = 0; j < width; j++)
        {
            if (map[i][j] == 1)
            {
                last = j;
            }
        }
        for (int j = 0; j <= last; j++)
        {
            if (map[i][j] == 1)
            {
                cout << "*";
            }
            else
            {
                cout << " ";
            }
        }
        cout << endl;
    }
    return 0;
}