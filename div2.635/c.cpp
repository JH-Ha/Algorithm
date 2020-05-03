#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> roads[200010];
bool visited[200010];
int depthList[200010];

int dfs(int node, int depth)
{
    visited[node] = true;
    int numChild = 0;
    for (int i = 0; i < roads[node].size(); i++)
    {
        int ele = roads[node][i];
        if (visited[ele] == false)
        {
            numChild += dfs(ele, depth + 1) + 1;

        }
    }
    //child node의 개수만큼 손해를 본다.
    depthList[node] = depth - numChild;
    return numChild;
}
bool desc(int a, int b){
    return a>b;
}
int main()
{
    int n, k;
    cin >> n >> k;

    for (int i = 0; i < 200010; i++)
    {
        visited[i] = false;
    }
    for (int i = 0; i < n - 1; i++)
    {
        int c1, c2;
        cin >> c1 >> c2;
        roads[c1].push_back(c2);
        roads[c2].push_back(c1);
    }
    dfs(1, 0);
    sort(depthList + 1, depthList + n + 1, desc);
    long long result = 0;
    for(int i = 1; i <=k; i ++){
        result += depthList[i];
    }
    cout << result << endl;
    return 0;
}
