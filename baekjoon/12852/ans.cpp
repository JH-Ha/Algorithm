#include <iostream>
#include <queue>
using namespace std;

int cache[1000010];

int main()
{
    int n;
    cin >> n;
    queue<pair<int, int>> q;
    q.push(make_pair(n, -1));
    for (int i = 0; i <= n; i++)
    {
        cache[i] = -1;
    }
    while (!q.empty())
    {
        pair<int, int> top = q.front();
        q.pop();

        if (cache[top.first] == -1)
        {
            cache[top.first] = top.second;
            if (top.first == 1)
                break;

            //-1
            q.push(make_pair(top.first - 1, top.first));
            // /2
            if (top.first % 2 == 0)
            {
                q.push(make_pair(top.first / 2, top.first));
            }
            // /3
            if (top.first % 3 == 0)
            {
                q.push(make_pair(top.first / 3, top.first));
            }
        }
        else
        {
            continue;
        }
    }
    vector<int> ans;
    int next = 1;
    while (next != -1)
    {
        ans.push_back(next);
        next = cache[next];
    }
    printf("%ld\n", ans.size() - 1);
    for (int i = 0; i < ans.size(); i++)
    {
        printf("%d ", ans[ans.size() - 1 - i]);
    }
    printf("\n");
    return 0;
}