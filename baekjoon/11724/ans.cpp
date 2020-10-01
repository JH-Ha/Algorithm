#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> node[1010];
int visited[1010];
int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        visited[i] = false;
    }
    for (int i = 0; i < m; i++)
    {
        int l, r;
        cin >> l >> r;
        node[l].push_back(r);
        node[r].push_back(l);
    }
    int answer = 0;
    for (int i = 1; i <= n; i++)
    {
        if (visited[i] == false)
        {
            answer++;
            visited[i] = true;
            queue<int> q;
            q.push(i);
            while (!q.empty())
            {
                int front = q.front();
                q.pop();
                for (int j = 0; j < node[front].size(); j++)
                {
                    if (visited[node[front][j]] == false)
                    {
                        visited[node[front][j]] = true;
                        q.push(node[front][j]);
                    }
                }
            }
        }
    }
    cout << answer << '\n';

    return 0;
}