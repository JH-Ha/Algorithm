#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n;
int t[10010], timeSave[10010];
vector<int> node[10010];
int numIn[10010];
queue<int> q;
int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int w, nPrev;
        cin >> w >> nPrev;
        timeSave[i] = t[i] = w;
        numIn[i] = 0;
        if (nPrev > 0)
        {
            for (int j = 0; j < nPrev; j++)
            {
                int jobId;
                cin >> jobId;
                node[jobId].push_back(i);
                numIn[i]++;
            }
        }
    }
    for (int i = 1; i <= n; i++)
    {
        if (numIn[i] == 0)
        {
            q.push(i);
        }
    }
    while (!q.empty())
    {
        int cur = q.front();
        q.pop();
        for (int i = 0; i < node[cur].size(); i++)
        {
            int child = node[cur][i];

            if (t[child] < timeSave[child] + t[cur])
            {
                t[child] = timeSave[child] + t[cur];
            }
            numIn[child]--;
            if (numIn[child] == 0)
            {
                q.push(child);
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <= n; i++)
    {
        if (ans < t[i])
            ans = t[i];
    }
    cout << ans << endl;
}