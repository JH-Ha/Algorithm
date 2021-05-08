#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;

    vector<int> node[n + 1];

    for (int i = 0; i < n; i++)
    {
        int l, r;
        cin >> l >> r;
        node[l].push_back(r);
        node[r].push_back(l);
    }
    int parent[n + 1];

    queue<int> q;
    bool visited[n + 1];
    for (int i = 0; i <= n; i++)
    {
        visited[i] = false;
    }
    visited[1] = true;
    q.push(1);
    while (!q.empty())
    {
        int front = q.front();
        q.pop();
        for (int i = 0; i < node[front].size(); i++)
        {
            if (!visited[node[front][i]])
            {
                visited[node[front][i]] = true;
                parent[node[front][i]] = front;
                q.push(node[front][i]);
            }
        }
    }
    for (int i = 2; i <= n; i++)
    {
        cout << parent[i] << '\n';
    }
    return 0;
}