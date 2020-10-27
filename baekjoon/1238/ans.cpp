#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

vector<pair<int, int>> node[1010];
long long t[1010][1010];

void dij(int x)
{
    t[x][x] = 0;
    priority_queue<pair<long long, int>> pq;
    pq.push(make_pair(0, x));
    while (!pq.empty())
    {
        long long cost = -pq.top().first;
        int cur = pq.top().second;
        pq.pop();
        for (int i = 0; i < node[cur].size(); i++)
        {
            pair<int, long long> nextNode = node[cur][i];
            int next = nextNode.first;
            long long weight = nextNode.second;
            if (t[x][next] > cost + weight)
            {
                t[x][next] = cost + weight;
                pq.push(make_pair(-t[x][next], next));
            }
        }
    }
}

int main()
{
    int n, m, x;
    cin >> n >> m >> x;

    for (int i = 0; i < m; i++)
    {
        long long l, r, w;
        cin >> l >> r >> w;
        node[l].push_back(make_pair(r, w));
    }
    memset(t, 1000000, sizeof(t));
    for (int i = 1; i <= n; i++)
    {
        dij(i);
    }
    long long ans = 0;
    for (int i = 1; i <= n; i++)
    {
        if (i == x)
            continue;
        ans = max(ans, t[x][i] + t[i][x]);
    }
    cout << ans << endl;
    return 0;
}