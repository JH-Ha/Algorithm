#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

#define INF 987654321

int w[20][20];
int cache[20][65536];

int n;
int tsp(int cur, int visited)
{
    if (visited == (1 << n) - 1)
    {
        if (w[cur][0] != 0)
        {
            return w[cur][0];
        }
        else
        {
            return INF;
        }
    }
    int &ret = cache[cur][visited];
    if (ret != -1)
        return ret;

    ret = INF;

    for (int next = 0; next < n; next++)
    {
        if (visited & (1 << next))
            continue;
        if (w[cur][next] == 0)
            continue;
        ret = min(ret, tsp(next, visited | (1 << next)) + w[cur][next]);
    }
    return ret;
}

int main()
{

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> w[i][j];
        }
    }
    memset(cache, -1, sizeof(cache));
    int ans = tsp(0, 1);
    cout << ans << endl;
    return 0;
}