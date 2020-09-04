#include <iostream>
#include <vector>
#include <utility>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

int n, m, v;

vector<int> node[1010];
bool visited[1010];
stack<int> s;
queue<int> q;
void dfs()
{
    while (!s.empty())
    {
        int top = s.top();
        s.pop();
        if (visited[top])
            continue;
        for (int i = 0; i < node[top].size(); i++)
        {
            s.push(node[top][i]);
        }
        visited[top] = true;
        cout << top << " ";
    }
}
bool compare(int i, int j)
{
    return i > j;
}

int main()
{
    cin >> n >> m >> v;
    for (int i = 0; i < m; i++)
    {
        int l, r;
        cin >> l >> r;
        node[l].push_back(r);
        node[r].push_back(l);
    }

    for (int i = 0; i <= n; i++)
    {
        visited[i] = false;
        sort(node[i].begin(), node[i].end(), compare);
    }
    s.push(v);
    dfs();
    cout << "\n";
    for (int i = 0; i <= n; i++)
    {
        visited[i] = false;
        sort(node[i].begin(), node[i].end());
    }

    q.push(v);
    while (!q.empty())
    {
        int front = q.front();
        q.pop();
        if (visited[front])
            continue;
        for (int i = 0; i < node[front].size(); i++)
        {
            if (visited[node[front][i]])
                continue;
            q.push(node[front][i]);
        }
        visited[front] = true;
        cout << front << " ";
    }
    cout << "\n";
    return 0;
}