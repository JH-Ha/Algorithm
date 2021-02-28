#include <iostream>
#include <queue>

using namespace std;

#define MAX_NODE 10010
#define MAX_NUM 10000000

int dist[MAX_NODE];
vector<pair<int, int>> node[MAX_NODE];

int n;
void dij(int start)
{
    priority_queue<pair<int, int>> pq;
    pq.push({0, start});
    for (int i = 0; i < MAX_NODE; i++)
    {
        dist[i] = MAX_NUM;
    }
    dist[start] = 0;
    while (!pq.empty())
    {
        pair<int, int> top = pq.top();
        pq.pop();
        int cost = -top.first;
        int curPos = top.second;
        for (int i = 0; i < node[top.second].size(); i++)
        {
            pair<int, int> child = node[top.second][i];
            int nextCost = child.first;
            int nextPos = child.second;
            if (cost + nextCost < dist[nextPos])
            {
                dist[nextPos] = cost + nextCost;
                pq.push({-dist[nextPos], nextPos});
            }
        }
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n - 1; i++)
    {
        int a, b, w;
        cin >> a >> b >> w;
        node[a].push_back({w, b});
        node[b].push_back({w, a});
    }
    dij(1);
    int maxIdx = 0;
    int maxDist = 0;
    for (int i = 1; i <= n; i++)
    {
        if (dist[i] == MAX_NUM)
            continue;
        if (dist[i] > maxDist)
        {
            maxIdx = i;
            maxDist = dist[i];
        }
    }
    //cout << maxIdx << " " << maxDist << endl;
    dij(maxIdx);
    int ans = 0;
    for (int i = 1; i <= n; i++)
    {
        ans = max(ans, dist[i]);
    }
    if (ans == MAX_NUM)
        ans = 0;
    cout << ans << endl;
    return 0;
}