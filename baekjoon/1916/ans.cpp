#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

vector<pair<int, long long>> node[1010];
long long d[1010];
int n, m;
int main()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int l, r, w;
        cin >> l >> r >> w;
        node[l].push_back(make_pair(r, w));
    }
    int start, end;
    cin >> start >> end;
    for (int i = 0; i <= n; i++)
    {
        d[i] = 987654321;
    }
    d[start] = 0;
    priority_queue<pair<long long, int>> pq;
    pq.push(make_pair(0, start));
    while (!pq.empty())
    {
        pair<long long, int> top = pq.top();
        int cur = top.second;
        long long cost = -top.first;
        pq.pop();
        for (int i = 0; i < node[cur].size(); i++)
        {
            pair<int, long long> nextNode = node[cur][i];
            int next = nextNode.first;
            long long nextCost = nextNode.second;
            if (d[next] > cost + nextCost)
            {
                d[next] = cost + nextCost;
                pq.push(make_pair(-d[next], next));
            }
        }
    }
    cout << d[end] << endl;
    return 0;
}