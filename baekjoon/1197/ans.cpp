#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int set[10010];
int getParent(int x)
{
    if (set[x] == x)
        return x;
    return set[x] = getParent(set[x]);
}
void unionParent(int a, int b)
{
    a = getParent(a);
    b = getParent(b);
    if (a < b)
        set[b] = a;
    else
        set[a] = b;
}
bool find(int a, int b)
{
    a = getParent(a);
    b = getParent(b);
    if (a == b)
        return true;
    else
        return false;
}

class Edge
{
public:
    int node[2];
    int distance;
    Edge(int a, int b, int distance)
    {
        this->node[0] = a;
        this->node[1] = b;
        this->distance = distance;
    }
    bool operator<(Edge &edge)
    {
        return this->distance < edge.distance;
    }
};

int main()
{
    int nv, ne;
    cin >> nv >> ne;
    vector<Edge> v;
    for (int i = 0; i < ne; i++)
    {
        int l, r, w;
        cin >> l >> r >> w;
        v.push_back(Edge(l, r, w));
    }
    sort(v.begin(), v.end());
    for (int i = 1; i <= nv; i++)
    {
        set[i] = i;
    }
    int sum = 0;
    for (int i = 0; i < v.size(); i++)
    {
        if (!find(v[i].node[0], v[i].node[1]))
        {
            sum += v[i].distance;
            unionParent(v[i].node[0], v[i].node[1]);
        }
    }
    printf("%d\n", sum);
    return 0;
}