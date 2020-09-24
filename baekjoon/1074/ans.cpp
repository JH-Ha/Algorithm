#include <iostream>

using namespace std;

int maxWidth = 2;
int N, r, c;

int map[17000][17000];

void createMap(int width)
{
    if (width >= maxWidth)
        return;

    for (int i = 0; i < width; i++)
    {
        for (int j = width; j < width * 2; j++)
        {
            map[i][j] = map[i][j - width] + width * width;
        }
    }
    for (int i = width; i < 2 * width; i++)
    {
        for (int j = 0; j < width; j++)
        {
            map[i][j] = map[i - width][j] + width * width * 2;
        }
    }
    for (int i = width; i < 2 * width; i++)
    {
        for (int j = width; j < 2 * width; j++)
        {
            map[i][j] = map[i - width][j - width] + width * width * 3;
        }
    }
    createMap(width * 2);
}

int main()
{

    cin >> N >> r >> c;

    for (int i = 0; i < N; i++)
    {
        maxWidth *= 2;
    }
    map[0][0] = 0;
    createMap(1);
    cout << map[r][c] << '\n';
    return 0;
}