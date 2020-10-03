#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<pair<int, int>> node[100010];
bool visited[100010];
stack<int> s;

int dis = 0;

int maxIdx = 0;
int maxDis = -1;
void dfs(int start)
{
    //cout << "dfs : " << start << endl;
    for (int i = 0; i < node[start].size(); i++)
    {

        pair<int, int> p = node[start][i];
        if (visited[p.first])
            continue;
        //s.push(p.first);
        dis += p.second;
        if (dis > maxDis)
        {
            maxIdx = p.first;
            maxDis = dis;
        }
        visited[p.first] = true;
        dfs(p.first);
        dis -= p.second;
    }
}

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        visited[i] = false;
        int nodeNum;
        cin >> nodeNum;
        int r, w;
        cin >> r;
        while (r != -1)
        {
            cin >> w;
            node[nodeNum].push_back(make_pair(r, w));
            cin >> r;
        }
    }
    visited[1] = true;
    dfs(1);
    //cout << maxDis << '\n';
    for (int i = 1; i <= n; i++)
    {
        visited[i] = false;
    }
    visited[maxIdx] = true;
    dfs(maxIdx);
    cout << maxDis << '\n';

    return 0;
}