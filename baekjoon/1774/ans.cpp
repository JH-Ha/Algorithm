#include <iostream>
#include <vector>
#include <cmath>
#include <queue>

using namespace std;

int group[1010];

int getGroup(int x)
{
    if (group[x] == x)
        return x;
    return getGroup(group[x]);
}

void uni(int x, int y)
{
    int gx = getGroup(x);
    int gy = getGroup(y);
    if (gx < gy)
    {
        group[gy] = gx;
    }
    else
    {
        group[gx] = gy;
    }
}

bool isSameGroup(int x, int y)
{
    return getGroup(x) == getGroup(y);
}

class Edge
{

public:
    int x;
    int y;
    double dis;

    Edge(int x, int y, double dis)
    {
        this->x = x;
        this->y = y;
        this->dis = dis;
    }
};

struct cmp
{
    bool operator()(Edge &t, Edge &u)
    {
        return t.dis > u.dis;
    }
};

double calDis(pair<long long, long long> pos1, pair<long long, long long> pos2)
{
    return sqrt(pow(pos1.first - pos2.first, 2) + pow(pos1.second - pos2.second, 2));
}

int main()
{
    int n, m;
    cin >> n >> m;
    pair<long long, long long> pos[1010];
    for (int i = 1; i <= n; i++)
    {
        int x, y;
        cin >> x >> y;
        pos[i] = {x, y};
        group[i] = i;
    }

    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        uni(x, y);
    }
    priority_queue<Edge, vector<Edge>, cmp> pqEdge;
    for (int i = 1; i <= n; i++)
    {
        for (int j = i + 1; j <= n; j++)
        {
            double dis = calDis(pos[i], pos[j]);
            pqEdge.push(Edge(i, j, dis));
        }
    }
    double ans = 0;
    while (!pqEdge.empty())
    {
        Edge top = pqEdge.top();
        pqEdge.pop();
        if (!isSameGroup(top.x, top.y))
        {
            ans += top.dis;
            uni(top.x, top.y);
        }
    }
    printf("%.2f\n", ans);

    return 0;
}
